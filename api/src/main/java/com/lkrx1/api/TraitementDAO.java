package com.lkrx1.api;

import java.util.ArrayList;
import java.util.List;

public class TraitementDAO {
	private static TraitementDAO instance;
	private static List<Traitement> data = new ArrayList<>();
	
	static {
		data.add(new Traitement(1, MedecinDAO.getInstance().get(1), PatientDAO.getInstance().get(1), 15));
		data.add(new Traitement(2, MedecinDAO.getInstance().get(2), PatientDAO.getInstance().get(3), 15));
		data.add(new Traitement(3, MedecinDAO.getInstance().get(3), PatientDAO.getInstance().get(2), 15));
	}
	
	private TraitementDAO() { }
	
	public static TraitementDAO getInstance() {
		if (instance==null) {
			instance = new TraitementDAO();
		}
		return instance;
	}
	
	public List<Traitement> listAll() {
		return new ArrayList<Traitement>(data);
	}
	
	public int add(Traitement traitement) {
		int newId = data.size()+1;
		traitement.setId(newId);
		data.add(traitement);
		
		return newId;
	}
	
	public Traitement get(int id) {
		Traitement traitementToFind = new Traitement(id);
		int index = data.indexOf(traitementToFind);
		if (index >= 0) {
			return data.get(index);
		}
		return null;
	}
	
	public ArrayList<Traitement> find(int id_medecin) {
		ArrayList<Traitement> result = new ArrayList<Traitement>();
		for (Traitement _traitement : data) {
			if((_traitement.getMedecin()).getId()==id_medecin) {
				result.add(_traitement);
			}
		}
		return result;
	}
	
	public boolean update(Traitement traitement) {
		int index = data.indexOf(traitement);
		if (index >=0) {
			data.set(index, traitement);
			return true;
		}
		return false;
	}
	
	public boolean delete(int id) {
		Traitement traitementToFind = new Traitement(id);
		int index = data.indexOf(traitementToFind);
		if (index >= 0) {
			data.remove(index);
			return true;
		}
		return false;
	}
}
