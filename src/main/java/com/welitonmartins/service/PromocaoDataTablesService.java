package com.welitonmartins.service;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.welitonmartins.model.Promocao;
import com.welitonmartins.repository.PromocaoRepository;
// aula 57, 58

@Service
public class PromocaoDataTablesService {
	
	private String[] cols = {
		"id", "titulo", "site", "linkPromocao", "descricao", 
		"linkImagem", "preco", "likes", "dtCadastro", "categoria"
	};
	
	public Map<String, Object> execute(PromocaoRepository repo, HttpServletRequest request){
																	//HttpServeletRequest para recuperar as informaçoes pelo cliente para lado servidor
		
		int start = Integer.parseInt(request.getParameter("start"));// pegando atraves start do jquery, que retorna o numero da pagina 
		int length = Integer.parseInt(request.getParameter("length"));// length pegando com jquery o quantidade de itens
		int draw = Integer.parseInt(request.getParameter("draw")); //draw pegando com jquery, incrementa a cada requição para paginação para pag, 2, 3 ..
		
		int current = currentPage(start, length);
		
		String column = columName(request);
		
		Sort.Direction direction = orderBy(request);
		
		Pageable pageable = PageRequest.of(current, length, direction, column);
		
		Page<Promocao> page = queryBy(repo, pageable);
		
		Map<String, Object> json = new LinkedHashMap<>();
		json.put("draw", draw);
		json.put("recordsTotal", page.getTotalElements());
		json.put("recordsFiltered",page.getTotalElements());
		json.put("data",  page.getContent());
		
		
		return json;
	}
	
	

	private Page<Promocao> queryBy(PromocaoRepository repo, Pageable pageable) {
		return repo.findAll(pageable);
	}

	/**
	 * metado de ordenação
	 * @param request
	 * @return
	 */
	private Direction orderBy(HttpServletRequest request) {
		String order = request.getParameter("order[0][dir]");
		Sort.Direction sort = Sort.Direction.ASC;
		if(order.equalsIgnoreCase("desc")) {
			sort = Sort.Direction.DESC;
		}
		return sort;
	}

	private String columName(HttpServletRequest request) {
		int iCol = Integer.parseInt(request.getParameter("order[0]column")); // sabendo o numero da posição da coluna a qual está ordernando os dados na tabela
		return cols[iCol];
	}

	private int currentPage(int start, int length) {
		//0    |   1    |   2
		//0- 9 |  10-19 | 20-29
		
		return start/ length;
	}
 
}
