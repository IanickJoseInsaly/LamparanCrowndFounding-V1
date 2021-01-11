package com.LamparanTest.LamparanTest.Repository;

import org.springframework.data.repository.CrudRepository;

import com.LamparanTest.LamparanTest.Entidade.Organizacao;
import com.LamparanTest.LamparanTest.Entidade.Responsavel;

public interface ResponsavelRepository extends CrudRepository<Responsavel, String> {
	Iterable<Responsavel> findByOrganizacao(Organizacao organizacao);

	Responsavel findByRg(String rg);
}
