package com.LamparanTest.LamparanTest.Entidade;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name = "Responsavel")
public class Responsavel {




	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String rg;
	
	
	private String nomeResponsavel;
	
	
	private Organizacao organizacao;
	
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getNomeResponsavel() {
		return nomeResponsavel;
	}
	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}
	public Organizacao getOrganizacao() {
		return organizacao;
	}
	public void setOrganizacao(Organizacao organizacao) {
		this.organizacao = organizacao;
	}
	
	
	
	
	
}
