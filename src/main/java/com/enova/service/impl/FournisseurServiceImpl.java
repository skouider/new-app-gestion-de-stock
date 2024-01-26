package com.enova.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enova.beans.Fournisseur;
import com.enova.repo.FournisseurRepository;
import com.enova.service.facade.FournisseurService;


@Service
public class FournisseurServiceImpl implements FournisseurService{

	@Autowired
	private FournisseurRepository fournisseurRepository;

	@Override
	public int save(Fournisseur fournisseur) {
		if(findByIdFournisseur(fournisseur.getIdFournisseur()) != null) {
			return -1;
		}else {
			fournisseurRepository.save(fournisseur);
			return 1;
		}
	}

	@Override
	public Fournisseur findByIdFournisseur(Long idFournisseur) {


		return fournisseurRepository.findByIdFournisseur(idFournisseur);
	}

	@Override
	@Transactional
	public int deleteByIdFournisseur(Long idFournisseur) {
		
		return fournisseurRepository.deleteByIdFournisseur(idFournisseur);
	}

	@Override
	public List<Fournisseur> findAll() {
		
		return fournisseurRepository.findAll();
	}
	
	
}
