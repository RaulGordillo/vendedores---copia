package com.vendedores.vendedores.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vendedores.vendedores.entity.Producto;
import com.vendedores.vendedores.entity.Vendedor;
import com.vendedores.vendedores.repository.IProductoRepository;
import com.vendedores.vendedores.service.VendedorService;

@Controller
public class UserController {

    @Autowired
    private VendedorService vendedorService;
    @Autowired
    private IProductoRepository productoRepository;

    private List<Producto> productoList = new ArrayList<>();

    public UserController(VendedorService vendedorService, IProductoRepository productoRepository) {
        this.vendedorService= vendedorService;
        this.productoRepository= productoRepository;

        this.productoList = this.productoRepository.findAllSortByName();
    }

    @RequestMapping ("/principal")
    public String principal() {
        return "principal";
    }

    @RequestMapping ("/catalogo")
    public String catalogo() {
        return "catalogo";
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("vendedor", vendedorService.getAllVendedor());
        return "vendedor";
    }

    @GetMapping("/vendedor")
    public String listVendedor(Model model) {
        model.addAttribute("vendedor", vendedorService.getAllVendedor());
        return "vendedor";
    }

    @GetMapping("/vendedor/new")
    public String createVendedorForm(Model model) {

        Vendedor vendedor = new Vendedor();

        model.addAttribute("vendedor", vendedor);
        model.addAttribute("productoList", productoList);
        return "create_user";
    }

    @PostMapping("/vendedor")
    public String saveVendedor(@ModelAttribute("vendedor") Vendedor vendedor) {
        vendedorService.saveVendedor(vendedor);
        return "redirect:/vendedor";
    }

    @GetMapping("/vendedor/edit/{id}")
    public String editVendedorForm(@PathVariable Long id, Model model) {
        Vendedor st = vendedorService.getVendedorById(id);

        model.addAttribute("vendedor", st);
        model.addAttribute("productoList", productoList);

        return "edit_compra";
    }

    @PostMapping("/vendedor/{id}")
    public String updateVendedor(@PathVariable Long id,
            @ModelAttribute("vendedor") Vendedor vendedor,
            Model model) {

        Vendedor existentVendedor = vendedorService.getVendedorById(id);
        existentVendedor.setId(id);

        existentVendedor.setName(vendedor.getName());
        existentVendedor.setPrecio(vendedor.getPrecio());
        existentVendedor.setEmail(vendedor.getEmail());
        existentVendedor.setUso(vendedor.getUso());
        existentVendedor.setComents(vendedor.getComents());
        existentVendedor.setProducto(vendedor.getProducto());
        
        vendedorService.updateVendedor(existentVendedor);

        return "redirect:/vendedor";
    }

    @GetMapping("/vendedor/{id}")
    public String deleteVendedor(@PathVariable Long id) {
        vendedorService.deleteVendedorById(id);
        return "redirect:/vendedor";
    }

}
