package com.LamparanTest.LamparanTest.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String Index() {
		System.out.println("CHEGOU O PEDIDO");
		return "index";
		
	}
	
	

}
