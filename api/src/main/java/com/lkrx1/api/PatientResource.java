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

@Path("/patients")
public class PatientResource {
	private PatientDAO dao = PatientDAO.getInstance();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Patient> list() {
		return dao.listAll();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(Patient patient) throws URISyntaxException {
		int newPatientId = dao.add(patient);
		return Response.status(Response.Status.CREATED).entity(patient).build();
	}
	
	@GET
	@Path("{id}")
	public Response get(@PathParam("id") int id) {
		Patient patient = dao.get(id); 
		if(patient!=null) {
			return Response.ok(patient, MediaType.APPLICATION_JSON).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	@GET
	@Path("find")
	@Produces(MediaType.APPLICATION_JSON)
	public String find(@QueryParam("nom") String nom) {
		return "{\"patient\":"+(dao.find(nom)).toString()+"}";
	}
	
	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response put(@PathParam("id") int id, Patient patient) {
		patient.setId(id);
		if(dao.update(patient)) {
			return Response.ok().entity(patient).build();
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
