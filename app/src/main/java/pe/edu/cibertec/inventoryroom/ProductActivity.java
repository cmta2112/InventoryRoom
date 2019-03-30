package pe.edu.cibertec.inventoryroom;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class ProductActivity extends AppCompatActivity {


    TextInputEditText etName, etDescription, etQuantity;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        etName = findViewById(R.id.etName);
        etDescription = findViewById(R.id.etDescription);
        etQuantity= findViewById(R.id.etQuantity);

        id = getIntent().getIntExtra("id",-1);

        if (id > -1){
            String name= getIntent().getStringExtra("name");
            String description = getIntent().getStringExtra("description");
            int quantity= Integer.parseInt(etQuantity.getText().toString());
            etName.setText(name);
            etDescription.setText(description);
            etQuantity.setText(quantity);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.product_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Product product;
        product = new Product();

        switch (item.getItemId()){
            case R.id.optionSave:
                String name = etName.getText().toString();
                String description = etDescription.getText().toString();
                int quantity= Integer.parseInt(etQuantity.getText().toString());



                if(id == -1){
                    product = new Product(name, description, quantity);

                    //esto te permite cargarlo a la base de datos
                    AppDatabase.getInstance(this).productDao().insert(product);

                }else{
                    product.setId(id);
                    product.setName(name);
                    product.setDescription(description);
                    product.setQuantity(quantity);

                    AppDatabase.getInstance(this).productDao().update(product);
                }



                break;
            case R.id.optionDelete:
                product.setId(id);
                AppDatabase.getInstance(this).productDao().delete(product);
                break;
        }

        finish();
        return true;

    }
}
