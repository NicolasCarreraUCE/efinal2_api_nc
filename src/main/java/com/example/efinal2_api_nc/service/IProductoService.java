package com.example.efinal2_api_nc.service;

import com.example.efinal2_api_nc.model.Producto;

public interface IProductoService {
    Producto buscarProductoPorCodigoBarras(String codigoBarras, Integer cantidad);
    void ingresarProducto(Producto producto);
}
