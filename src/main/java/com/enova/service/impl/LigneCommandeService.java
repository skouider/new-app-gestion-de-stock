package com.enova.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enova.beans.Commande;
import com.enova.beans.LigneCommande;
import com.enova.beans.Produit;
import com.enova.beans.Stock;
import com.enova.repo.LigneCommandeRepo;
import com.enova.service.facade.CommandeService;
import com.enova.service.facade.IProduitService;
import com.enova.service.facade.StockService;


@Service
public class LigneCommandeService {

	@Autowired
	private LigneCommandeRepo ligneCommandeRepo;
	@Autowired
	private IProduitService produitService;
	@Autowired
	private CommandeService commandeService;
	@Autowired
	private StockService stockService;
	
	public int save(Commande commande, List<LigneCommande> ligneCommandes) {
		
	// ******** Premiere Methode ****************	
		
//		commandeItems.stream().forEach(item->{
//		item.setPrix(item.getPrixUnitaire().multiply(item.getQuantite()));
//		item.setCommande(commande);
//		if(item.getProduit() != null && item.getProduit().getRef() != null) {
//			item.setProduit(produitService.findByRef(item.getProduit().getRef()));
//		}
//		itemRepository.save(item);
//		});
		
		// *********** Secconde Methode***************
		
		System.out.println("ligne commande : "+ligneCommandes);
		
		for (LigneCommande ligneCommande : ligneCommandes) {
			ligneCommande.setCommande(commande);
             System.out.println("commande! "+commande.getRefCommande());
			Produit produit = null;
			if(ligneCommande.getProduit().getIdProduit() != null) {
				produit = produitService.findById(ligneCommande.getProduit().getIdProduit());
				
			}
			ligneCommande.setProduit(produit);
			System.out.println("produit id = "+produit.getIdProduit());
			
//			Stock stock = stockService.findByProduitId(produit.getIdProduit());				
//			stock.setQuantite(stock.getQuantite() + ligneCommande.getQuantite());
//			stockService.save(stock);
			ligneCommandeRepo.save(ligneCommande);
		}
		return 1;
	}
    
	
	public List<LigneCommande> findByCommandeId(Long id) {
		return ligneCommandeRepo.findByCommandeIdCommande(id);
	}

	public int deleteByCommandeRef(String ref) {		
		return ligneCommandeRepo.deleteByCommandeRefCommande(ref);
	}

}
