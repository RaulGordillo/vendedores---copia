package com.vendedores.vendedores.service;

import java.util.List;

import com.vendedores.vendedores.entity.Vendedor;

public interface IVendedorService {

    List<Vendedor> getAllVendedor();

    List<Vendedor> getVendedorByName(String name);

    Vendedor saveVendedor(Vendedor vendedor);

    Vendedor getVendedorById(Long id);

    Vendedor updateVendedor(Vendedor vendedor);

    void deleteVendedorById(Long id);

}

        

