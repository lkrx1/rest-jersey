package com.lkrx1.api;

import java.util.ArrayList;
import java.util.List;

public class MedecinDAO {
	private static MedecinDAO instance;
	private static List<Medecin> data = new ArrayList<Medecin>();
	
	static {
		data.add(new Medecin(1, "RAFALIMANANTSOA Heritiana Lucka Erickson", 35_000f));
		data.add(new Medecin(2, "RAJOELINA Andry Nirina", 22_000f));
		data.add(new Medecin(3, "RASOLOMAMPIONONA Marcelin", 17_000f));
		data.add(new Medecin(4, "RASOLO Joseph", 35_000f));
		data.add(new Medecin(5, "RAKOTOVAO Alphonse", 22_000f));
		data.add(new Medecin(6, "NOMENJANAHARY Desire", 17_000f));
		data.add(new Medecin(7, "RANDRIANARIJAONA Richard", 35_000f));
		data.add(new Medecin(8, "RKOTOAMBOA Medard", 22_000f));
		data.add(new Medecin(9, "RASOLOFOSON Jose", 17_000f));
	}
	
	private MedecinDAO() { }
	
	public static MedecinDAO getInstance() {
		if (instance==null) {
			instance = new MedecinDAO();
		}
		return instance;
	}
	
	public List<Medecin> listAll() {
		return new ArrayList<Medecin>(data);
	}
	
	public int add(Medecin medecin) {
		int newId = data.size()+1;
		medecin.setId(newId);
		data.add(medecin);
		
		return newId;
	}
	
	public Medecin get(int id) {
		Medecin medecinToFind = new Medecin(id);
		int index = data.indexOf(medecinToFind);
		if (index >= 0) {
			return data.get(index);
		}
		return null;
	}
	
	public ArrayList<Medecin> find(String nom) {
		ArrayList<Medecin> result = new ArrayList<Medecin>();
		for (Medecin _medecin : data) {
			if(_medecin.getNom().toLowerCase().contains(nom.toLowerCase())) {
				result.add(_medecin);
			}
		}
		System.out.println(result);
		return result;
	}
	
	public boolean update(Medecin medecin) {
		int index = data.indexOf(medecin);
		if (index >=0) {
			data.set(index, medecin);
			return true;
		}
		return false;
	}
	
	public boolean delete(int id) {
		Medecin medecinToFind = new Medecin(id);
		int index = data.indexOf(medecinToFind);
		if (index >= 0) {
			data.remove(index);
			return true;
		}
		return false;
	}
}
