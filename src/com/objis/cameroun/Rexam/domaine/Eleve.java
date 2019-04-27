package com.objis.cameroun.Rexam.domaine;


/**
 * @author youssouf
 *Classe qui contient les informations relative à l'élève
 */
public class Eleve {
	//les propriétés de la classe Eleve
	
	private String matricule;
	private String nomprenom;
	private String datenaissance;
	private String lieunaissance;
	private String serie;
	private String decisionjuge;

	//Constructeurs
	
	public Eleve() {
		super();
	}
	
	public Eleve(String matricule) {
		this.matricule=matricule;
	}

	public Eleve(String matricule, String nomprenom, String datenaissance, String lieunaissance, String serie,
			String decisionjuge) {
		super();
		this.matricule = matricule;
		this.nomprenom = nomprenom;
		this.datenaissance = datenaissance;
		this.lieunaissance = lieunaissance;
		this.serie = serie;
		this.decisionjuge = decisionjuge;
	}

	//Accesseurs Getters et Setters
	
	public String getMatricule() {
	return matricule;
	}
	
	public void setMatricule(String matricule) {
		this.matricule=matricule;
	}
	
	public String getNomprenom() {
		return nomprenom;
	}
	
	public void setNomprenom(String nomprenom) {
		this.nomprenom=nomprenom;
	}
	
	public String getDatenaissance() {
		return datenaissance;
	}
	
	public void setDatenaissance(String datenaissance) {
		this.datenaissance=datenaissance;
	}
	
	public String getLieunaissance() {
		return lieunaissance;
	}
	
	public void setLieunaissance(String lieunaissance) {
		this.lieunaissance=lieunaissance;
	}
	
	public String getSerie() {
		return serie;
	}
	
	public void setSerie(String serie) {
		this.serie=serie;
	}
	
	public String getDecisionjuge() {
		return decisionjuge;
	}
	
	public void setDecisionjuge(String decisionjuge) {
		this.decisionjuge=decisionjuge;
	}
	
	//Methode toString()

	@Override
	public String toString() {
		return "Eleve [matricule=" + matricule + ", nomprenom=" + nomprenom + ", datenaissance=" + datenaissance
				+ ", lieunaissance=" + lieunaissance + ", serie=" + serie + ", decisionjuge=" + decisionjuge + "]";
	}
	
			
	}
	


