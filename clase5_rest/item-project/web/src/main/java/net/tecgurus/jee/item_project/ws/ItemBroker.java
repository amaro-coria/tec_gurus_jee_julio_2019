package net.tecgurus.jee.item_project.ws;

import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

import net.tecgurus.jee.item_project.business.ItemDetailService;

@WebService
public class ItemBroker {

	@EJB
	private ItemDetailService service;
	
	@WebMethod
	public BigDecimal findStockByParentId(Integer idParent) {
		return service.findCurrentStockByItemParent(idParent);
	}
	
}
