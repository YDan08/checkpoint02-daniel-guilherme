package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.jpa.dao.impl.AcessorioDAOImpl;
import br.com.fiap.jpa.entity.Acessorio;
import br.com.fiap.jpa.service.GenericService;

public class AcessorioServiceImpl extends GenericService<Acessorio, Long> {

	private static AcessorioServiceImpl instance = null;
	
	private AcessorioDAOImpl acessorioDAO;

	
	private AcessorioServiceImpl() {
		acessorioDAO = AcessorioDAOImpl.getInstance();

	}
	
	public static AcessorioServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new AcessorioServiceImpl();
		}
		
		return instance;
	}
	
	@Override
	public void cadastrar(Acessorio acessorio) {
		try {
			acessorioDAO.salvar(acessorio, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}
	
	
	
	
	@Override
	public void atualizar(Acessorio acessorio) {
		try {
			acessorioDAO.atualizar(acessorio, getEntityManager());
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		
	}

	@Override
	public void remover(Long id) {
		try {
			acessorioDAO.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		
	}

	@Override
	public Acessorio obter(Long id) {
		Acessorio acessorio = null;
		
		try {
			acessorio = acessorioDAO.obterPorId(id, getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return acessorio;
	}

	@Override
	public List<Acessorio> listar() {
		 List<Acessorio> acessorios = null;
		
		try {
			acessorios = acessorioDAO.listar(getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return acessorios;
	}
}
