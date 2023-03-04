package com.example.efinal2_api_nc.repository;

import com.example.efinal2_api_nc.model.Producto;

public interface IProductoRepository {
    Producto buscarProductoPorCodigoBarras(String codigoBarras);
    void ingresarProducto(Producto producto);
}
