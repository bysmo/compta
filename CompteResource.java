/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softone.compta.ws;

/**
 *
 * @author BF0491
 */

import com.softone.compta.DAO.CompteDAO;
import com.softone.compta.Models.Compte;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/compte")
public class CompteResource {

	CompteDAO dao = new CompteDAO();
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Compte> findAll() {
		return dao.findAll();
	}
        
        @POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Compte add(Compte compte) {
		return dao.create(compte);
	}
        
        @POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Compte update(Long id, Compte compte) {
		return dao.update(compte);
	}

	@GET @Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Compte findById(@PathParam("id") String id) {
		return dao.findById(Integer.parseInt(id));
	}
	
	@GET @Path("{id}/reports")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Compte> findByManager(@PathParam("id") String managerId) {
		return dao.findByManager(Integer.parseInt(managerId));
	}
}

