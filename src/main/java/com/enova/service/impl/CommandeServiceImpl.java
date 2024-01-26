package com.enova.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enova.beans.Commande;
import com.enova.beans.Fournisseur;
import com.enova.beans.LigneCommande;
import com.enova.repo.CommandeRepository;
import com.enova.service.facade.CommandeService;
import com.enova.service.facade.FournisseurService;


@Service
public class CommandeServiceImpl implements CommandeService {

	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private LigneCommandeService ligneCommandeService;
	@Autowired
	private FournisseurService fournisseurService;
	
	@Override
	public int save(Commande commande) {


		if (findByRef(commande.getRefCommande()) != null) {
			return -1;
		}
		Fournisseur fournisseur = null;
		
		if(commande.getFournisseur() != null) {
			fournisseur = fournisseurService.findByIdFournisseur(commande.getFournisseur().getIdFournisseur()); 
		} 
		commande.setFournisseur(fournisseur);
		
		
		
		if(fournisseur == null) {
			return -2;
		}
		else {
			
			prepare(commande);
			commande.setDateCommande(new Date());			
			commande.setStatut(commande.getStatut());
			commandeRepository.save(commande);
			ligneCommandeService.save(commande, commande.getLigneCommandes());
			return 1;
		}


	}

	@Override
	public int update(Commande commande) {

		if (findByRef(commande.getRefCommande()) == null) {
			return -1;
		} else {
			
			commandeRepository.save(commande);
			ligneCommandeService.save(commande, commande.getLigneCommandes());
			return 1;
		}

	}
	
	@Override
	@Transactional
	public int deleteByRef(String ref) {
		
//         List<Reception> listReceptions = receptionService.findByCommandeRef(ref);
//         for (Reception reception : listReceptions) {
//			receptionService.deleteReception(reception.getRef());
//			receptionItemService.deleteReception(reception.getRef());
//		}
//		
//		int deleteByCommandeRef = ligneCommandeService.deleteByCommandeRef(ref);
//		int deleteByRef = commandeRepository.deleteByRef(ref);
//		return deleteByCommandeRef + deleteByRef;
		commandeRepository.deleteByRefCommande(ref);
		return 1;
	}

	private void prepare(Commande commande) {

		double total = 0;
		for (LigneCommande item : commande.getLigneCommandes()) {
			
			total = total + item.getPrixUnitaire() * item.getQuantite();
		}
		
		commande.setTotalCommande(total);
	}

	@Override
	public Commande findByRef(String ref) {
		return commandeRepository.findByRefCommande(ref);
	}

	@Override
	public List<Commande> findAll() {
		return commandeRepository.findAll();
	}

	@Override
	public int calculQuantitéReceptionne(Commande commande) {
		int qte = 0;
//		for(Reception reception:commande.getReceptions()) {
//			qte += reception.getQuantite();
//		}	  
		return qte;
	}
}
