package com.vendedores.vendedores.service;

import java.util.List;

import com.vendedores.vendedores.entity.Producto;
import com.vendedores.vendedores.repository.IProductoRepository;

public class ProductoService implements IProductoService {

    private IProductoRepository productoRepository;

    public ProductoService(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    
    @Override
    public List<Producto> getAllProducto() {
        return productoRepository.findAllSortByName();
    }

    @Override
    public List<Producto> getProductoByName(String name) {
        return productoRepository.findByTitleContaining(name);
    }

    @Override
    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto getProductoById(Long id) {
        return productoRepository.getReferenceById(id);

    }

    @Override
    public void deleteProductoById(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public Producto updateProducto(Producto producto) {
        return productoRepository.save(producto);
    }

}

