package com.LamparanTest.LamparanTest.Entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;





@Entity
@Table(name = "Organizacao")
@Access(value=AccessType.FIELD)
public class Organizacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long codigo;
	
	private String nome;
	//private Endereco endereco;
	private String nIF;
	private String telefone;
	private String Telemovel;
	//private Date dataCriacao;

	public Organizacao(String nome,  String nIF, String telefone, String telemovel) {

		this.nome = nome;
		System.out.println(nome + " Nome da Organizacao");
	//	this.endereco = endereco;
		this.nIF = nIF;
		this.telefone = telefone;
		Telemovel = telemovel;
//		this.dataCriacao = dataCriacao;
		
	}

	public String getNome() {
		return nome;
	}

/*	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}*/

	public String getNIF() {
		return nIF;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelemovel() {
		return Telemovel;
	}

	public void setTelemovel(String telemovel) {
		Telemovel = telemovel;
	}

	/*public Date getDataCriancao() {
		return dataCriacao;
	}*/

	public long getCodigo() {
		return codigo;
	}
	@OneToMany
	private List<Responsavel> responsaveis;
	
	
@Override
	public String toString() {
		return "Organizacao [Id=" + codigo + ", nome=" + nome + ", endereco=" + ", nIF=" + nIF + ", telefone="
				+ telefone + ", Telemovel=" + Telemovel + ", dataCriancao=" + "]";
	}
	
}
