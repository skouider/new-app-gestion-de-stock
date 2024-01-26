package com.enova.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneCommande {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private double prixUnitaire;
	private int quantite;
	
	@ManyToOne
	@JoinColumn(name = "produit_id")
	private Produit produit;
	@ManyToOne
	@JoinColumn(name = "commande_id")
	private Commande commande;
 
	public LigneCommande() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	@Override
	public String toString() {
		return "Produits_Commande [id=" + id + ", prixUnitaire=" + prixUnitaire + ", quantite=" + quantite
				+ ", produit=" + produit + ", commande=" + commande + "]";
	}

}
