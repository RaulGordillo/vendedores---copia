package com.vendedores.vendedores.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vendedores.vendedores.entity.Vendedor;
import com.vendedores.vendedores.repository.IVendedorRepository;

@Service
public class VendedorService implements IVendedorService {

    private IVendedorRepository vendedorRepository;

    public VendedorService(IVendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    @Override
    public List<Vendedor> getAllVendedor() {
        return vendedorRepository.findAll();
    }

    @Override
    public Vendedor saveVendedor(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    @Override
    public Vendedor getVendedorById(Long id) {
        return vendedorRepository.findById(id).get();
    }

    @Override
    public Vendedor updateVendedor(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    @Override
    public void deleteVendedorById(Long id) {
        vendedorRepository.deleteById(id);
    }

    @Override
    public List<Vendedor> getVendedorByName(String name) {
        return vendedorRepository.findByNameContaining(name);
    }

}
    

