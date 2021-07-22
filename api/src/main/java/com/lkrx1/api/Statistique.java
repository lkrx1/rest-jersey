package com.lkrx1.api;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@XmlRootElement
public class Statistique {
	private int id;
	private Medecin medecin;
	private double percent;
	private int effectif;
	
	public Statistique() { }

	public Statistique(Medecin medecin, double percent, int effectif) {
		super();
		this.medecin = medecin;
		this.percent = percent;
		this.effectif = effectif;
	}

	public Statistique(int id, Medecin medecin, double percent, int effectif) {
		super();
		this.id = id;
		this.medecin = medecin;
		this.percent = percent;
		this.effectif = effectif;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}

	public int getEffectif() {
		return effectif;
	}

	public void setEffectif(int effectif) {
		this.effectif = effectif;
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
		Statistique other = (Statistique) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
    public String toString(){
        try {
            // takes advantage of toString() implementation to format {"a":"b"}
        	JSONObject statistique = new JSONObject().put("id", getId()).put("effectif", getEffectif()).put("percent", getPercent());
        	JSONObject medecin = new JSONObject().put("id", getMedecin().getId()).put("nom", getMedecin().getNom()).put("taux_journalier", getMedecin().getTaux_journalier());
        	
        	statistique.put("medecin", medecin);
        	
            return statistique.toString();
        } catch (JSONException e) {
            return null;
        }
    }
	
}
