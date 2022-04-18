package br.com.fiap.jpa;
import br.com.fiap.jpa.entity.Acessorio;

import br.com.fiap.jpa.entity.Carro;

import br.com.fiap.jpa.entity.Modelo;
import br.com.fiap.jpa.service.impl.AcessorioServiceImpl;

import br.com.fiap.jpa.service.impl.CarroServiceImpl;
import br.com.fiap.jpa.service.impl.ModeloServiceImpl;

public class Main {

	public static void main(String[] args) {

		CarroServiceImpl carroService = CarroServiceImpl.getInstance();
		AcessorioServiceImpl acessorioService = AcessorioServiceImpl.getInstance();
		ModeloServiceImpl modeloService = ModeloServiceImpl.getInstance();

		Modelo modelo1 = new Modelo("sedã");
		Acessorio acessorio1 = new Acessorio("Pneu");
		Acessorio acessorio2 = new Acessorio("Multimídia");
		Carro carro1 = new Carro("ABC18C9", "azul", "9bwhe21jx24060831", modelo1);

		modeloService.cadastrar(modelo1);
		acessorioService.cadastrar(acessorio1);
		acessorioService.cadastrar(acessorio2);

		carroService.cadastrar(carro1);
		
		carroService.Juntar(carro1.getId(), acessorio1.getId());
		carroService.Juntar(carro1.getId(), acessorio2.getId());

		modeloService.listar().forEach(System.out::println);

		acessorioService.listar().forEach(System.out::println);

		carroService.listar().forEach(System.out::println);

	}
}
