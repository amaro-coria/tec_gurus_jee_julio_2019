package net.tecgurus.jee.item_project.ws;

import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.jws.WebService;

import net.tecgurus.itemservice._1.FindStockByIdRequest;
import net.tecgurus.itemservice._1.FindStockByIdResponse;
import net.tecgurus.itemservice._1.ItemServicePortType;
import net.tecgurus.itemservice._1.StockNumber;
import net.tecgurus.jee.item_project.business.ItemDetailService;


//Anotaciones para WS
@WebService(
		serviceName = "itemService", 
		endpointInterface = "net.tecgurus.itemservice._1.ItemServicePortType", 
		targetNamespace = "http://www.tecgurus.net/itemService/1.0")
public class ItemServicePortTypeImpl implements ItemServicePortType{
	
	@EJB
	private ItemDetailService service;

	@Override
	public FindStockByIdResponse operacionStock(FindStockByIdRequest operacion1Request) {
		//TODO llamar al EJB
		FindStockByIdResponse response = new FindStockByIdResponse();
		  StockNumber sn = new StockNumber();
		  sn.setStock(service.findCurrentStockByItemParent(operacion1Request.getRequest().getId()));
		response.setResponse(sn);
		return response;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
