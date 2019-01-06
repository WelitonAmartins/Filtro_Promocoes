package com.welitonmartins.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.welitonmartins.model.Categoria;
import com.welitonmartins.repository.CategoriaRepository;

@Controller
@RequestMapping("/promocao")
public class PromocaoController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@ModelAttribute("categorias")
	public List<Categoria> getCategoria() {
		
		return categoriaRepository.findAll();
	}
	
	@GetMapping("/add")
	public String AbrirCadastro() {
		return "promo-add";
	}

}
