package com.lkrx1.api;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@XmlRootElement
public class Traitement {
	private int id;
	private Medecin medecin;
	private Patient patient;
	private int nbjour;
	
	public Traitement() { }
	
	public Traitement(int id) {
		super();
		this.id = id;
	}
	
	public Traitement(Medecin medecin, Patient patient, int nbjour) {
		super();
		this.medecin = medecin;
		this.patient = patient;
		this.nbjour = nbjour;
	}

	public Traitement(int id, Medecin medecin, Patient patient, int nbjour) {
		super();
		this.id = id;
		this.medecin = medecin;
		this.patient = patient;
		this.nbjour = nbjour;
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

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public int getNbjour() {
		return nbjour;
	}

	public void setNbjour(int nbjour) {
		this.nbjour = nbjour;
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
		Traitement other = (Traitement) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
    public String toString(){
        try {
            // takes advantage of toString() implementation to format {"a":"b"}
        	JSONObject traitement = new JSONObject().put("id", getId()).put("nb_jour", getNbjour());
        	JSONObject medecin = new JSONObject().put("id", getMedecin().getId()).put("nom", getMedecin().getNom()).put("taux_journalier", getMedecin().getTaux_journalier());
        	JSONObject patient = new JSONObject().put("id", getPatient().getId()).put("nom", getPatient().getNom()).put("adresse", getPatient().getAdresse());
        	
        	traitement.put("medecin", medecin);
        	traitement.put("patient", patient);
        	
            return traitement.toString();
        } catch (JSONException e) {
            return null;
        }
    }
}
