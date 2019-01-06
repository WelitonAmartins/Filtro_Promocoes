package com.welitonmartins.web.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysql.fabric.Response;
import com.welitonmartins.model.Categoria;
import com.welitonmartins.model.Promocao;
import com.welitonmartins.repository.CategoriaRepository;
import com.welitonmartins.repository.PromocaoRepository;

@Controller
@RequestMapping("/promocao")
public class PromocaoController {
	
	private static Logger log = LoggerFactory.getLogger(PromocaoController.class);
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private PromocaoRepository promocaoRepository;
	
	@PostMapping("/save")
	public ResponseEntity<Promocao> salvarPromocao(Promocao promocao){
		log.info("Promocao {}", promocao.toString());
		promocao.setDtCadastro(LocalDateTime.now());
		promocaoRepository.save(promocao);
		return ResponseEntity.ok().build();
		
	}
	
	@ModelAttribute("categorias")
	public List<Categoria> getCategoria() {
		
		return categoriaRepository.findAll();
	}
	
	@GetMapping("/add")
	public String AbrirCadastro() {
		return "promo-add";
	}

}
