package com.lkrx1.api;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@XmlRootElement
public class Patient {
	private int id;
	private String nom;
	private String adresse;
	
	public Patient() { }
	
	public Patient(int id) {
		super();
		this.id = id;
	}
	
	public Patient(String nom, String adresse) {
		super();
		this.nom = nom;
		this.adresse = adresse;
	}

	public Patient(int id, String nom, String adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
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
		Patient other = (Patient) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
    public String toString(){
        try {
            // takes advantage of toString() implementation to format {"a":"b"}
            return new JSONObject().put("id", getId()).put("nom", getNom()).put("adresse", getAdresse()).toString();
        } catch (JSONException e) {
            return null;
        }
    }
}
