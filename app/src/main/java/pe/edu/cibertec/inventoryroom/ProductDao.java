
package pe.edu.cibertec.inventoryroom;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

//permite administrar mi BD

@Dao
public interface ProductDao {

    @Query("select * from product")
    List<Product> getAll();

    @Insert
    void insert(Product... products);

    @Update
    void update (Product...products);

    @Delete
    void delete (Product product);




}