package com.enova.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enova.beans.Produit;
import com.enova.beans.Stock;
import com.enova.repo.StockRepository;
import com.enova.service.facade.StockService;

@Service
public class StockServiceImpl implements StockService{

	@Autowired
	private StockRepository stockRepository;
	@Autowired
    private ProduitService produitService;
	
	
	@Override
	public int deleteById(Long idStock) {
		stockRepository.deleteByIdStock(idStock);
		return 1;
	}

	@Override
	public List<Stock> findAll() {
		
		return stockRepository.findAll();
	}

	@Override
	public int update(Stock stock) {
		
			stockRepository.save(stock);
			return 1;			
		
	}

	@Override
	public int save(Stock stock) {
		
		if(findById(stock.getIdStock()) != null) {
			return -1;
		}
		
		Produit produit = null;
		if(stock.getProduit() != null) {
			produit = produitService.findById(stock.getProduit().getIdProduit());
		}
		
		stock.setProduit(produit);
		stock.setQuantite(stock.getQuantite() + produit.getQuantite());
		stockRepository.save(stock);

		
		return 1;
	}

	@Override
	public Stock findByProduitId(Long id) {
	
		return stockRepository.findByProduitIdProduit(id);
	}

	@Override
	public Stock findById(Long id) {
		
		return stockRepository.findById(id).orElseThrow();
	}

//	@Override
//	public int save(Stock stock) {
//		if(findById(stock.getIdStock()) != null) {
//			return -1;
//		}
//		
//		Produit produit = null;
//
//			produit = produitService.findById(stock.getProduit().getIdProduit());
//		
//		stock.setProduit(produit);
//		
//		stockRepository.save(stock);
//		return 1;
//	}

	@Override
	public Stock findByProduitRef(String ref) {
		return stockRepository.findByProduitRef(ref);
	}

	
	
}
