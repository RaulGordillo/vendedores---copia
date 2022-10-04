package com.vendedores.vendedores.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vendedores.vendedores.entity.Vendedor;

public interface IVendedorRepository extends JpaRepository<Vendedor, Long> {

    @Query("FROM Vendedor v WHERE v.name LIKE :name")
    public List<Vendedor> findByNameContaining(@Param("name") String name);

    
}
