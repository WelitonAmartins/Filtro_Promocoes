package com.welitonmartins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.welitonmartins.model.SocialMetaTag;
import com.welitonmartins.service.SocialMetaTagService;

@SpringBootApplication
public class FiltroPromocoesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FiltroPromocoesApplication.class, args);
	}
	
	@Autowired
	SocialMetaTagService service;
	
	@Override
	public void run(String... args) throws Exception {
		
//		SocialMetaTag tag = service.getSocialMetaTagByUrl("https://www.pichau.com.br/processador-amd-ryzen-5-2400g-quatro-nucleos-cache-6mb-3-6ghz-am4-yd2400c5fbbox");
//		System.out.println(tag.toString());
//		
	
	}
	
	

}

