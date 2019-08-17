package net.tecgurus.jee.item_project.business;

import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import net.tecgurus.jee.item_project.dao.impl.ItemDetailDAOBean;
import net.tecgurus.jee.item_project.model.ItemDetail;

/**
 * Session Bean implementation class ItemDetailService
 */
@Stateless
@LocalBean
public class ItemDetailService {

	@EJB
	private ItemDetailDAOBean itemDao;
	
    public BigDecimal findCurrentStockByItemParent(Integer idParent) {
    	ItemDetail itemDetail = itemDao.findByItemParentId(idParent);
    	return itemDetail.getCurrentStock();
    }

}
