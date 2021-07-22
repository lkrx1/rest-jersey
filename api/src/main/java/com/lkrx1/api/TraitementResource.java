package com.lkrx1.api;

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

@Path("/traitements")
public class TraitementResource {
	private TraitementDAO dao = TraitementDAO.getInstance();
	private MedecinDAO mdc_dao = MedecinDAO.getInstance();
	private PatientDAO patient_dao = PatientDAO.getInstance();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Traitement> list() {
		List<Traitement> all = dao.listAll();
		return all;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(TraitementInput traitement_input) throws URISyntaxException {
		System.out.println(traitement_input);
		Traitement traitement = new Traitement(mdc_dao.get(traitement_input.getId_medecin()), patient_dao.get(traitement_input.getId_patient()), traitement_input.getNbJour());
		int newTraitementId = dao.add(traitement);
		return Response.status(Response.Status.CREATED).entity(traitement).build();
	}
	
	@GET
	@Path("{id}")
	public Response get(@PathParam("id") int id) {
		Traitement traitement = dao.get(id); 
		if(traitement!=null) {
			return Response.ok(traitement, MediaType.APPLICATION_JSON).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	@GET
	@Path("medecin/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String find(@PathParam("id") int id_mdc) {
		return "{\"traitement\":"+(dao.find(id_mdc)).toString()+"}";
	}
	
	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response put(@PathParam("id") int id, TraitementInput traitement_input) {
		Traitement traitement = new Traitement(id, mdc_dao.get(traitement_input.getId_medecin()), patient_dao.get(traitement_input.getId_patient()), traitement_input.getNbJour());
		if(dao.update(traitement)) {
			return Response.ok().entity(traitement).build();
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
