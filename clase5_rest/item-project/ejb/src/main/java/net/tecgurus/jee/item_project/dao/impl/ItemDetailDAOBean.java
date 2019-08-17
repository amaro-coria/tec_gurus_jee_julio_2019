package net.tecgurus.jee.item_project.dao.impl;

import static net.tecgurus.jee.item_project.dao.QueryParameter.with;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import net.tecgurus.jee.item_project.dao.CrudService;
import net.tecgurus.jee.item_project.model.ItemDetail;

/**
 * Session Bean implementation class ItemDetailDAOBean
 */
@Stateless
@LocalBean
public class ItemDetailDAOBean {

	@EJB
	private CrudService<ItemDetail> itemService;
	
	public List<ItemDetail> findAll(){
		return itemService.findWithNamedQuery("ItemDetail.findAll");
	}
	
	public ItemDetail findByItemParentId(int itemParentId) {
		//ItemDetail.findByItemId
		List<ItemDetail> list =
				itemService.findWithNamedQuery("ItemDetail.findByItemId", 
						with("idItem", itemParentId).parameters());
		ItemDetail result = list.get(0);
		return result;
	}

}
