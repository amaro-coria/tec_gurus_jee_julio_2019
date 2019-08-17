package net.tecgurus.jee.item_project.ws.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.tecgurus.jee.common.dto.ItemDetailDTO;
import net.tecgurus.jee.item_project.business.ItemDetailService;

@Stateless
@LocalBean
@Path("/itemrs")
public class ItemRest {
	
	@EJB
	private ItemDetailService service;
	
	@GET
	@Path("/findAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ItemDetailDTO> findAllDetails(){
		return service.findAll();
	}

}
