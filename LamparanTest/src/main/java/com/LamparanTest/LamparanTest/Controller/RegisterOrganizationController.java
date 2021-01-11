package com.LamparanTest.LamparanTest.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.LamparanTest.LamparanTest.Entidade.Organizacao;
import com.LamparanTest.LamparanTest.Entidade.Responsavel;
import com.LamparanTest.LamparanTest.Repository.OrganizacaoRepository;
import com.LamparanTest.LamparanTest.Repository.ResponsavelRepository;

@Controller
public class RegisterOrganizationController {

	@Autowired
	private OrganizacaoRepository or;

	@RequestMapping(value = "/RegisterOrganization", method = RequestMethod.GET)
	public String From() {
		System.out.println("chegou segundo1 pedido");

		return "organizacao/FromOrganization";

	}

	@RequestMapping(value = "/RegisterOrganization", method = RequestMethod.POST)
	public String form(@Valid Organizacao organizacao, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/RegisterOrganization";

		}
		or.save(organizacao);
		attributes.addFlashAttribute("mensagem", "organizacao registado com sucesso!");
		return "redirect:/RegisterOrganization";
	}

	@Autowired
	private ResponsavelRepository rr;

	@RequestMapping("/organizacao")
	public ModelAndView listaEventos() {
		ModelAndView mv = new ModelAndView("listaOrganizacao");
		Iterable<Organizacao> organizacoes = or.findAll();
		mv.addObject("organizacoes", organizacoes);
		return mv;
	}

	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
	public ModelAndView detalhesEvento(@PathVariable("codigo") long codigo) {
		Organizacao organizacao = or.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("organizacao/detalhesOrganizacao");
		mv.addObject("organizacao", organizacao);

		Iterable<Responsavel> responsaveis = rr.findByOrganizacao(organizacao);
		mv.addObject("responsaveis", responsaveis);

		return mv;
	}

	@RequestMapping("/apagarOranizacao")
	public String apagarOranizacao(long codigo) {
		Organizacao organizacao = or.findByCodigo(codigo);
		or.delete(organizacao);
		return "redirect:/organizacao";
	}

	@RequestMapping(value = "/{codigo}", method = RequestMethod.POST)
	public String detalhesOraganizacaoPost(@PathVariable("codigo") long codigo, @Valid Responsavel responsavel,
			BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/{codigo}";
		}
		Organizacao organizacao = or.findByCodigo(codigo);
		responsavel.setOrganizacao(organizacao);
		rr.save(responsavel);
		attributes.addFlashAttribute("mensagem", "Responsavel adicionado com sucesso!");
		return "redirect:/{codigo}";
	}

	@RequestMapping("/apagarResponsavel")
	public String deletarConvidado(String rg) {
		Responsavel responsavel = rr.findByRg(rg);
		rr.delete(responsavel);

		Organizacao organizacao = responsavel.getOrganizacao();
		long codigoLong = organizacao.getCodigo();
		String codigo = "" + codigoLong;
		return "redirect:/" + codigo;
	}

}