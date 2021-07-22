package com.lkrx1.api;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@XmlRootElement
public class Medecin {
	private int id;
	private String nom;
	private float taux_journalier;
	
	public Medecin() {
		
	}
	public Medecin(int id) {
		super();
		this.id = id;
	}
	public Medecin(String nom, float taux_journalier) {
		super();
		this.nom = nom;
		this.taux_journalier = taux_journalier;
	}
	public Medecin(int id, String nom, float taux_journalier) {
		super();
		this.id = id;
		this.nom = nom;
		this.taux_journalier = taux_journalier;
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
	public float getTaux_journalier() {
		return taux_journalier;
	}
	public void setTaux_journalier(float taux_journalier) {
		this.taux_journalier = taux_journalier;
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
		Medecin other = (Medecin) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
    public String toString(){
        try {
            // takes advantage of toString() implementation to format {"a":"b"}
            return new JSONObject().put("id", getId()).put("nom", getNom()).put("taux_journalier", getTaux_journalier()).toString();
        } catch (JSONException e) {
            return null;
        }
    }
	
}
