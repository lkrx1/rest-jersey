package com.lkrx1.api;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.codehaus.jettison.json.JSONArray;

@Path("/medecins")
public class MedecinResource {
	private MedecinDAO dao = MedecinDAO.getInstance();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String list() {
		return "{\"medecin\":"+dao.listAll().toString()+"}";
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(Medecin medecin) throws URISyntaxException {
		int newMedecinId = dao.add(medecin);
		return Response.status(Response.Status.CREATED).entity(medecin).build();
	}
	
	@GET
	@Path("{id}")
	public Response get(@PathParam("id") int id) {
		Medecin medecin = dao.get(id); 
		if(medecin!=null) {
			return Response.ok(medecin, MediaType.APPLICATION_JSON).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	} 
	
	@GET
	@Path("find")
	@Produces(MediaType.APPLICATION_JSON)
	public String find(@QueryParam("nom") String nom) {
		return "{\"medecin\":"+(dao.find(nom)).toString()+"}";
	}
	
	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response put(@PathParam("id") int id, Medecin medecin) {
		medecin.setId(id);
		if(dao.update(medecin)) {
			return Response.ok().entity(medecin).build();
		} else {
			return Response.notModified().build();
		}
	}
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") int id) {
		if(dao.delete(id)) {
			return Response.ok().build();
		} else {
			return Response.notModified().build();
		}
	}
}
