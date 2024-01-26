package com.enova.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enova.beans.Categorie;
import com.enova.beans.Produit;
import com.enova.beans.Stock;
import com.enova.repo.ProduitRepository;
import com.enova.service.facade.CategorieService;
import com.enova.service.facade.IProduitService;
import com.enova.service.facade.StockService;

@Service
public class ProduitService implements IProduitService {

	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private CategorieService categorieService;
	@Autowired
	private StockService stockService;

//	@Override
//	public int save(Produit produit) {
//		if (findByRef(produit.getRef()) != null) {
//			return -1;
//		} else {
//            Categorie categorie = null;
//            if(produit.getCategorie() != null) {
//            	categorie = categorieService.findByNom(produit.getCategorie().getNomCategorie());
//            }
//            produit.setCategorie(categorie);
//			prepare(produit);
//			produitRepository.save(produit);
//			stockService.save(produit, produit.getStocks());
//			return 1;
//		}
//	}

	
	public int save(Categorie categorie, List<Produit> produits) {

		categorie = categorieService.findByNom(categorie.getNomCategorie());

		for (Produit produit : produits) {
			if (findByRef(produit.getRef()) == null) {
				
				produit.setCategorie(categorie);
				System.out.println("produit coté produit categorie: "+produit.getLibelle());
//				prepare(produit);
				
				Stock stock = null;
				if(produit.getStock() != null) {
					
					stock = stockService.findByProduitId(produit.getIdProduit());
				}
               
				produit.setStock(stock);
				
					stock.setQuantite(stock.getQuantite() + produit.getQuantite());
				
				stockService.save(stock);
				produitRepository.save(produit);
			} else {
				System.out.println("le produit existe deja*******");
			}
		}

		return 1;
	}

	@Override
	public int saveToStock(Produit produit) {
		if(findByRef(produit.getRef()) != null) {
			return -1;
		}else {
			Categorie categorie = null;
			if(produit.getCategorie() != null) {
				categorie = categorieService.findByNom(produit.getCategorie().getNomCategorie());
			}
			produit.setCategorie(categorie);

			Stock stock = null;
			if(produit.getStock() != null) {
				
				stock = stockService.findByProduitId(produit.getIdProduit());
				System.out.println("stock id: "+stock.getIdStock());
			}
           
			produit.setStock(stock);
			stock.setQuantite(stock.getQuantite() + produit.getQuantite());
			stockService.save(stock);
			System.out.println("stock id: "+stock.getIdStock());
			produitRepository.save(produit);
			
			
		}
		return 1;
	}

//	private void prepare(Produit produit) {
//         System.out.println("produit dans la fonction prepare! "+produit.getLibelle());
//		List<Stock> stocks = stockService.findByProduitId(produit.getIdProduit());
//		 System.out.println("stocks dans la fonction prepare! "+stocks);
//		for (Stock stock : stocks) {
//			stock.setQuantite(stock.getQuantite() + produit.getQuantite());
//			stocks.add(stock);
//			stock.setProduit(produit);
//			
//		}
//		
//		produit.setStocks(stocks);
//		System.out.println("stocks dans la fonction****** aprés "+stocks);
//	}

	public Produit findByRef(String ref) {
		return produitRepository.findByRef(ref);
	}

	@Transactional
	public int deleteByRef(String ref) {
		return produitRepository.deleteByRef(ref);
	}

	public List<Produit> findAll() {

		return produitRepository.findAll();
	}

	@Override
	public Produit findById(Long id) {

		return produitRepository.findByIdProduit(id);
	}

	@Override
	public void updateProduit(Produit produit) {
		produitRepository.save(produit);

	}

	@Override
	public List<Produit> findByCategorieId(Long id) {

		return produitRepository.findByCategorieId(id);
	}

	


	
}
