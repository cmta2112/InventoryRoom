package pe.edu.cibertec.inventoryroom;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductPrototype> {

    private List<Product> items;

    public ProductAdapter(List<Product> items) {
        this.items = items;
    }

    // Crea la vista en base el prototipo por cada celda

    @NonNull
    @Override
    public ProductPrototype onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {

        View view;

        // esto sirve para jalar el diseño para la vista

        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.prototype_product,viewGroup,false);

        ProductPrototype productPrototype = new ProductPrototype(view);


        return productPrototype;


    }

    // carga la informacion por cada celda de acuerdo a la posicion
    @Override
    public void onBindViewHolder(@NonNull ProductPrototype productPrototype, int position) {
        Product product = items.get(position);

        // si se cre la variable de arriba se modifica :
        productPrototype.tvName.setText(product.getName());
        productPrototype.tvDescription.setText(product.getDescription());
        productPrototype.tvQuantity.setText(String.valueOf(product.getQuantity()));

    }

    //Indica la cantidad de registros en el Recycler View
    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ProductPrototype extends RecyclerView.ViewHolder {

        TextView tvName, tvDescription, tvQuantity;

        public ProductPrototype(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvQuantity = itemView.findViewById(R.id.tvQuantity);
        }
    }
}
