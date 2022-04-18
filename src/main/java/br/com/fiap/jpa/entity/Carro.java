package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_carro")
@SequenceGenerator(name = "carro", sequenceName = "SQ_TB_CARRO", allocationSize = 1)
public class Carro implements Serializable {
	
	private static final long serialVersionUID = -8166900613574015892L;
	
	public Carro() {		
	}
	
	public Carro(String placa, String cor, String chassi, Modelo modelo) {
		this();
		this.placa = placa;
		this.cor = cor;
		this.chassi = chassi;
		this.modelo = modelo;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carro")
	private Long id;
	
	@Column(name = "ds_placa", nullable = false, unique = true)
	private String placa;
	
	@Column(name = "ds_cor", nullable = false)
	private String cor;
	
	@Column(name = "ds_chassi", length = 17, nullable = false)
	private String chassi;
	
	@ManyToMany
	@JoinTable(
		name = "tb_carro_acessorio",
		joinColumns = @JoinColumn(name = "carro_id"),
		inverseJoinColumns = @JoinColumn(name = "acessorio_id")
	)
	private List<Acessorio> acessorios;
	
	@ManyToOne
	@JoinColumn(name = "modelo_id")
	private Modelo modelo;
	
 

	public void setAcessorios(List<Acessorio> acessorios) {
	this.acessorios = acessorios;
	}
	
	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	@Override
	public String toString() {
		
		return "\nPlaca: " + this.getPlaca() 
			+ "\nCor: " + this.getCor()
			+ "\nChassi: " + this.getChassi()
			+ this.getModelo();
	}

}

