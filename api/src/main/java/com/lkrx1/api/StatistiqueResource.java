package com.lkrx1.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/statistiques")
public class StatistiqueResource {
	private StatistiqueDAO dao = StatistiqueDAO.getInstance();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String list() {
		return "{\"statistique\":"+(dao.list()).toString()+"}";
	}
}
