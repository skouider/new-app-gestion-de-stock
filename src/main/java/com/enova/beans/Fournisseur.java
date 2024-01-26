package com.enova.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Fournisseur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFournisseur;
	private String nomFournisseur;
	private String prenomFournisseur;
	private String telFournisseur;
	private String emailFournisseur;
	@OneToMany(mappedBy = "fournisseur")
	private List<Commande> commandes;
	
	public Fournisseur() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdFournisseur() {
		return idFournisseur;
	}

	public void setIdFournisseur(Long idFournisseur) {
		this.idFournisseur = idFournisseur;
	}

	public String getNomFournisseur() {
		return nomFournisseur;
	}

	public void setNomFournisseur(String nomFournisseur) {
		this.nomFournisseur = nomFournisseur;
	}

	public String getPrenomFournisseur() {
		return prenomFournisseur;
	}

	public void setPrenomFournisseur(String prenomFournisseur) {
		this.prenomFournisseur = prenomFournisseur;
	}

	public String getTelFournisseur() {
		return telFournisseur;
	}

	public void setTelFournisseur(String telFournisseur) {
		this.telFournisseur = telFournisseur;
	}

	public String getEmailFournisseur() {
		return emailFournisseur;
	}

	public void setEmailFournisseur(String emailFournisseur) {
		this.emailFournisseur = emailFournisseur;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

}
