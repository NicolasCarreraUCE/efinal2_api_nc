package com.example.efinal2_api_nc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.efinal2_api_nc.model.Producto;
import com.example.efinal2_api_nc.service.IProductoService;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/productos")
public class ProductoRestFul {

    @Autowired
    private IProductoService productoService;

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void ingresarProducto(@RequestBody Producto producto) {
        this.productoService.ingresarProducto(producto);
    }

    @GetMapping(path = "/{codigoBarras}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Producto> buscarProductoPorCodigoBarras(@PathVariable("codigoBarras") String codigoBarras, @RequestParam Integer cantidad) {
        return ResponseEntity.ok(this.productoService.buscarProductoPorCodigoBarras(codigoBarras, cantidad));
    }

}
