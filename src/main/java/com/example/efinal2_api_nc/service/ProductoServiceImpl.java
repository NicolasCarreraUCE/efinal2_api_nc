package com.example.efinal2_api_nc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.efinal2_api_nc.model.Producto;
import com.example.efinal2_api_nc.repository.IProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService {
    
    @Autowired
    private IProductoRepository productoRepository;
    
    @Override
    public Producto buscarProductoPorCodigoBarras(String codigoBarras, Integer cantidad) {
        Producto producto = this.productoRepository.buscarProductoPorCodigoBarras(codigoBarras);
        if(producto.getStock() > cantidad)
            return producto;
        else
            return null;
    }

    @Override
    public void ingresarProducto(Producto producto) {
        if(producto.getStock() != 0 || producto.getStock() != null)
            this.productoRepository.ingresarProducto(producto);
    }
}
