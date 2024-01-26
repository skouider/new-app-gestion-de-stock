package com.enova.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enova.beans.Produit;
import com.enova.beans.Stock;
import com.enova.service.facade.StockService;

@RestController
@RequestMapping("/api/stock")
@CrossOrigin("*")
public class StockApiProvided {

	@Autowired
	private StockService stockService;

	@PostMapping("/")
	public int save(@RequestBody Stock stock) {
		return stockService.save(stock);
	}

	@GetMapping("/idProduit/{id}")
	public Stock findByProduitId(@PathVariable Long id) {
		return stockService.findByProduitId(id);
	}

	@GetMapping("/idStock/{idStock}")
	public Stock findById(@PathVariable Long idStock) {
		return stockService.findById(idStock);
	}

	@DeleteMapping("/idStock/{idStock}")
	public int deleteById(@PathVariable Long idStock) {
		return stockService.deleteById(idStock);
	}

	@GetMapping
	public List<Stock> findAll() {
		return stockService.findAll();
	}

	@PutMapping("/edit")
	public int update(@RequestBody Stock stock) {
		return stockService.update(stock);
	}
	
	
}
