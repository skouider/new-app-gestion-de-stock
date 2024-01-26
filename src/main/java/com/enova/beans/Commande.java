package com.enova.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.enova.enumeration.Statut;

@Entity
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCommande;
	private String refCommande;
	private Date dateCommande;
	private Double totalCommande;
	@Enumerated(EnumType.STRING)
	private Statut statut; 
	@ManyToOne
	@JoinColumn(name = "id_fournisseur")
	private Fournisseur fournisseur;
	@OneToMany(mappedBy = "commande")
	private List<LigneCommande> ligneCommandes;
	
	public Commande() {
		// TODO Auto-generated constructor stub
	}


	public Long getIdCommande() {
		return idCommande;
	}


	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}


	public String getRefCommande() {
		return refCommande;
	}


	public void setRefCommande(String refCommande) {
		this.refCommande = refCommande;
	}


	public Date getDateCommande() {
		return dateCommande;
	}


	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}


	public Statut getStatut() {
		return statut;
	}


	public void setStatut(Statut statut) {
		this.statut = statut;
	}


	public Fournisseur getFournisseur() {
		return fournisseur;
	}


	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}


	public List<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}


	public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}


	public Double getTotalCommande() {
		return totalCommande;
	}


	public void setTotalCommande(Double totalCommande) {
		this.totalCommande = totalCommande;
	}



}
