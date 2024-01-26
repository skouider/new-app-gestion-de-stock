package com.enova.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/stock-api/commande")
@CrossOrigin("*")
public class CommandeProvided {

	@Autowired
	private CommandeService commandeService;

	@PostMapping("/")
	public int save(@RequestBody Commande commande) {
		return commandeService.save(commande);
	}

	@GetMapping("/ref/{ref}")
	public Commande findByRef(@PathVariable String ref) {
		return commandeService.findByRef(ref);
	}

	@DeleteMapping("/ref/{ref}")
	public int deleteByRef(@PathVariable String ref) {
		return commandeService.deleteByRef(ref);
	}

	@GetMapping("/")
	public List<Commande> findAll() {
		return commandeService.findAll();
	}
	
	
}
