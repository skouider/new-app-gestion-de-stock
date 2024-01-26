package com.enova.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enova.beans.Commande;
import com.enova.service.facade.CommandeService;

@RestController
@RequestMapping("/api/commande")
public class CommandeProvidedApi {

	@Autowired
	private CommandeService commandeService;

	@PostMapping("/")
	public int save(@RequestBody Commande commande) {
		return commandeService.save(commande);
	}

	@GetMapping("/ref/{refCommande}")
	public Commande findByRefCommande(@PathVariable String refCommande) {
		return commandeService.findByRefCommande(refCommande);
	}

	
	@DeleteMapping("/ref/{refCommande}")
	public int deleteByRefCommande(String refCommande) {
		return commandeService.deleteByRefCommande(refCommande);
	}

	public List<Commande> findAll() {
		return commandeService.findAll();
	}

	public int calculQuantitéReceptionne(Commande commande) {
		return commandeService.calculQuantitéReceptionne(commande);
	}

	public int update(Commande commande) {
		return commandeService.update(commande);
	}
	
	
}
