package com.lkrx1.api;

import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
	private static PatientDAO instance;
	private static ArrayList<Patient> data = new ArrayList<Patient>();
	
	static {
		data.add(new Patient(1, "RASENDRASOA Marie Angele", "Soatsihadino, Fianarantsoa"));
		data.add(new Patient(2, "RABENJAMANANA Stephan", "Andalatery, Fianarantsoa"));
		data.add(new Patient(3, "MORAMORA Benjamin", "Beravina, Fianarantsoa"));
	}
	
	private PatientDAO() { }
	
	public static PatientDAO getInstance() {
		if (instance==null) {
			instance = new PatientDAO();
		}
		return instance;
	}
	
	public List<Patient> listAll() {
		return new ArrayList<Patient>(data);
	}
	
	public int add(Patient patient) {
		int newId = data.size()+1;
		patient.setId(newId);
		data.add(patient);
		
		return newId;
	}
	
	public Patient get(int id) {
		Patient patientToFind = new Patient(id);
		int index = data.indexOf(patientToFind);
		if (index >= 0) {
			return data.get(index);
		}
		return null;
	}
	
	public ArrayList<Patient> find(String nom) {
		ArrayList<Patient> result = new ArrayList<Patient>();
		for (Patient _patient : data) {
			if(_patient.getNom().toLowerCase().contains(nom.toLowerCase())) {
				result.add(_patient);
			}
		}
		return result;
	}
	
	public boolean update(Patient patient) {
		int index = data.indexOf(patient);
		if (index >=0) {
			data.set(index, patient);
			return true;
		}
		return false;
	}
	
	public boolean delete(int id) {
		Patient patientToFind = new Patient(id);
		int index = data.indexOf(patientToFind);
		if (index >= 0) {
			data.remove(index);
			return true;
		}
		return false;
	}
}
