package com.lkrx1.api;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TraitementInput {
	private int id;
	private int id_medecin;
	private int id_patient;
	private int nbJour;
	
	public TraitementInput() { }

	public TraitementInput(int id_medecin, int id_patient, int nbJour) {
		super();
		this.id_medecin = id_medecin;
		this.id_patient = id_patient;
		this.nbJour = nbJour;
	}

	public TraitementInput(int id, int id_medecin, int id_patient, int nbJour) {
		super();
		this.id = id;
		this.id_medecin = id_medecin;
		this.id_patient = id_patient;
		this.nbJour = nbJour;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_medecin() {
		return id_medecin;
	}

	public void setId_medecin(int id_medecin) {
		this.id_medecin = id_medecin;
	}

	public int getId_patient() {
		return id_patient;
	}

	public void setId_patient(int id_patient) {
		this.id_patient = id_patient;
	}

	public int getNbJour() {
		return nbJour;
	}

	public void setNbJour(int nbJour) {
		this.nbJour = nbJour;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TraitementInput other = (TraitementInput) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
