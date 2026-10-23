package com.example.exercicios_sb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {


	@GetMapping(path = {"/ola"})
	public String ola() {

		return "Olá Spring Boot!";
	}
	
	@GetMapping(path = {"/saudacao"})
	
	public String saudacao() {

		return "Saudação Spring Boot!";
	}

}
