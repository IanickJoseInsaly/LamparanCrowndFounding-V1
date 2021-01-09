package com.LamparanTest.LamparanTest.Entidade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	
	private String rua;
	private String codigoPostal;
	private String bairro;
	private String cidade;
	private String regiao;

	public Endereco(String rua, String codigoPostal, String bairro, String cidade, String regiao) {

		this.rua = rua;
		this.codigoPostal = codigoPostal;
		this.bairro = bairro;
		this.cidade = cidade;
		this.regiao = regiao;

	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public long getId() {
		return Id;
	}


	@Override
	public String toString() {
		return "Endereco [rua=" + rua + ", codigoPostal=" + codigoPostal + ", bairro=" + bairro + ", cidade=" + cidade
				+ ", regiao=" + regiao + "]";
	}

}
