package com.vendedores.vendedores.service;

import java.util.List;

import com.vendedores.vendedores.entity.Producto;

public interface IProductoService {

    List<Producto> getAllProducto();

    List<Producto> getProductoByName(String name);    

    Producto saveProducto(Producto producto);

    Producto getProductoById(Long id);

    Producto updateProducto(Producto producto);

    void deleteProductoById(Long id);

}
    

