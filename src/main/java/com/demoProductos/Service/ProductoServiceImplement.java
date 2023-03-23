package com.demoProductos.Service;

import com.demoProductos.Repository.ProductoRepository;
import com.demoProductos.Model.Producto;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImplement  implements ProductoService{
    @Autowired
    private ProductoRepository productoRepository;
    
    @Override
    @Transactional(readOnly=true)
    public List<Producto> findAll()
    {
        return (List<Producto>) productoRepository.findAll();
    }
    
    @Override
     @Transactional(readOnly=false)
    public Producto save(Producto producto)
    {
        return productoRepository.save(producto);
    }
    
    @Override
     @Transactional(readOnly=true)
    public Producto findById(Integer id)
    {
        return productoRepository.findById(id).orElse(null);
    }
    
    @Override
     @Transactional(readOnly=false)
    public void delete(Integer id)
    {
        productoRepository.deleteById(id);
    }
    
}
