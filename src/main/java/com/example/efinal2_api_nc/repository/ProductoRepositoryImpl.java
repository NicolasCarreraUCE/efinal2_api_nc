package com.example.efinal2_api_nc.repository;

import org.springframework.stereotype.Repository;

import com.example.efinal2_api_nc.model.Producto;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository {

    @PersistenceContext
	private EntityManager entityManager;

    @Override
    public Producto buscarProductoPorCodigoBarras(String codigoBarras) {
        TypedQuery<Producto> mQuery = this.entityManager.createQuery("SELECT p FROM Producto p WHERE p.codigoBarras = :codigoBarras", Producto.class);
        mQuery.setParameter("codigoBarras", codigoBarras);
        return mQuery.getSingleResult();
    }

    @Override
    public void ingresarProducto(Producto producto) {
        this.entityManager.persist(producto);
    }
    
}
