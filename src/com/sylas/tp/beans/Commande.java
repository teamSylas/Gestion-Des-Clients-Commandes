package com.sylas.tp.beans;


public class Commande {

	
	private Client client;
	private String date;
	private Double montantCommande;
	private String modePaiementCommande;
	private String statutPaiementCommande;
	private String modeLivraisonCommande;
	private String statutLivraisonCommande;
	
	
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Double getMontantCommande() {
		return montantCommande;
	}
	public void setMontantCommande(Double montantCommande) {
		this.montantCommande = montantCommande;
	}
	public String getModePaiementCommande() {
		return modePaiementCommande;
	}
	public void setModePaiementCommande(String modePaiementCommande) {
		this.modePaiementCommande = modePaiementCommande;
	}
	public String getStatutPaiementCommande() {
		return statutPaiementCommande;
	}
	public void setStatutPaiementCommande(String statutPaiementCommande) {
		this.statutPaiementCommande = statutPaiementCommande;
	}
	public String getModeLivraisonCommande() {
		return modeLivraisonCommande;
	}
	public void setModeLivraisonCommande(String modeLivraisonCommande) {
		this.modeLivraisonCommande = modeLivraisonCommande;
	}
	public String getStatutLivraisonCommande() {
		return statutLivraisonCommande;
	}
	public void setStatutLivraisonCommande(String statutLivraisonCommande) {
		this.statutLivraisonCommande = statutLivraisonCommande;
	}
	
	
}
