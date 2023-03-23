package com.demoProductos.Repository;

import com.demoProductos.Model.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto, Integer>{
    
}
