package com.lkrx1.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StatistiqueDAO {
	private static StatistiqueDAO instance;
	private MedecinDAO mdc_dao = MedecinDAO.getInstance();
	private TraitementDAO traitement_dao = TraitementDAO.getInstance();
	private static ArrayList<Patient> data = new ArrayList<Patient>();
	
	
	public static StatistiqueDAO getInstance() {
		if (instance==null) {
			instance = new StatistiqueDAO();
		}
		return instance;
	}
	
	public ArrayList<Statistique> list() {
		List<Medecin> mdc_list = mdc_dao.listAll();
		ArrayList<Statistique> stats = new ArrayList<Statistique>();
		int effectif_total = traitement_dao.listAll().size();
		for (Medecin medecin : mdc_list) {
			ArrayList<Traitement> mdc_traitements= traitement_dao.find(medecin.getId());
			int effectif=0;
			for (Traitement traitement : mdc_traitements) {
				effectif++;
			}
			stats.add(new Statistique(1, medecin, (effectif*100)/effectif_total, effectif));
		}
		return stats;
	}

}
