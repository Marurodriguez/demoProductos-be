package com.demoProductos.Controller;

import com.demoProductos.Model.Producto;
import com.demoProductos.Service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins={"*"})
@RequestMapping("/api")
public class ProductoController {
    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/productos")
    public List<Producto> listar()
    {
        return productoService.findAll();
    }
    
    @PostMapping("/productos")
    public  Producto guardar(@RequestBody Producto producto)
    {
        return productoService.save(producto);
    }
    
    @GetMapping("/productos/{id}")
    public Producto getUnProducto(@PathVariable Integer id)
    {
        return productoService.findById(id);
    }
    
    @PutMapping("/productos/{id}")
    public Producto modificar(@RequestBody Producto producto,@PathVariable Integer id)
    {
        Producto productoActual= productoService.findById(id);
        productoActual.setNombre(producto.getNombre());
        productoActual.setCodigo(producto.getCodigo());
        productoActual.setStock(producto.getStock());
        productoActual.setPrecioCIVA(producto.getPrecioCIVA());

        
        return productoService.save(productoActual);
    }
    
    @DeleteMapping("/productos/{id}")
    public void eliminar(@PathVariable Integer id)
    {
        productoService.delete(id);
    }
    
}
