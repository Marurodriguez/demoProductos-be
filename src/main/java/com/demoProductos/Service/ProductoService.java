package com.demoProductos.Service;

import com.demoProductos.Model.Producto;
import java.util.List;

public interface ProductoService {
    public List<Producto> findAll();
    public Producto save(Producto producto);
    public Producto findById(Integer id);
    public void delete(Integer id);
    
}
