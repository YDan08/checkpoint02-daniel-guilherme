package br.com.fiap.jpa.dao.impl;

import br.com.fiap.jpa.entity.Modelo;

public class ModeloDAOImpl extends HibernateGenericDAO<Modelo, Long> {

	private static ModeloDAOImpl instance = null;
	
	public static ModeloDAOImpl getInstance() {
		if (instance == null) {
			instance = new ModeloDAOImpl();
		}
		
		return instance;
	}
	
	private ModeloDAOImpl() {
		super(Modelo.class);
	}
	
}
