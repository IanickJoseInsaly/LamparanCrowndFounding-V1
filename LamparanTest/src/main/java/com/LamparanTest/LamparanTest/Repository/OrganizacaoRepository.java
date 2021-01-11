package com.LamparanTest.LamparanTest.Repository;

import org.springframework.data.repository.CrudRepository;

import com.LamparanTest.LamparanTest.Entidade.Organizacao;


public interface OrganizacaoRepository  extends CrudRepository<Organizacao, String>{
	Organizacao findByCodigo(long codigo);
}
