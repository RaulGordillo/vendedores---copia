package com.vendedores.vendedores.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vendedores.vendedores.entity.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Long> {

    @Query("FROM Producto p WHERE p.name like :title")
    List<Producto> findByTitleContaining(@Param("title") String title);    

    @Query("FROM Producto p ORDER BY name ASC")
    public List<Producto> findAllSortByName();


    
}
