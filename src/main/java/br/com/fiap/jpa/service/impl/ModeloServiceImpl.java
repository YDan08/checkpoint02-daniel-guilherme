package br.com.fiap.jpa.service.impl;

import java.util.List;


import br.com.fiap.jpa.dao.impl.ModeloDAOImpl;

import br.com.fiap.jpa.entity.Modelo;
import br.com.fiap.jpa.service.GenericService;

public class ModeloServiceImpl extends GenericService<Modelo, Long> {

	private static ModeloServiceImpl instance = null;
	
	private ModeloDAOImpl modeloDAO;

	
	private ModeloServiceImpl() {
		modeloDAO = ModeloDAOImpl.getInstance();

	}
	
	public static ModeloServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new ModeloServiceImpl();
		}
		
		return instance;
	}
	
	@Override
	public void cadastrar(Modelo modelo) {
		try {
			modeloDAO.salvar(modelo, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}
	
	@Override
	public void atualizar(Modelo modelo) {
		try {
			modeloDAO.atualizar(modelo, getEntityManager());
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		
	}

	@Override
	public void remover(Long id) {
		try {
			modeloDAO.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		
	}

	@Override
	public Modelo obter(Long id) {
		Modelo modelo = null;
		
		try {
			modelo = modeloDAO.obterPorId(id, getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return modelo;
	}

	@Override
	public List<Modelo> listar() {
		List<Modelo> modelos = null;
		
		try {
			modelos = modeloDAO.listar(getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return modelos;
	}
}
