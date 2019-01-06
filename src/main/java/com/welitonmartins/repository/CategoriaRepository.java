package com.welitonmartins.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.welitonmartins.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
