package net.tecgurus.jee.item_project.business;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import net.tecgurus.jee.common.dto.ItemDetailDTO;
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

	public List<ItemDetailDTO> findAll() {
		List<ItemDetail> entity = itemDao.findAll();
		List<ItemDetailDTO> listDto = new ArrayList<ItemDetailDTO>();
		for (ItemDetail d : entity) {
			listDto.add(new ItemDetailDTO(d.getIdItemDetail(), d.getCurrentStock(), d.getEmailAlert(),
					d.getMinimumStock(), d.getItem().getIdItem()));
		}
		return listDto;
	}

	public BigDecimal findCurrentStockByItemParent(Integer idParent) {
		ItemDetail itemDetail = itemDao.findByItemParentId(idParent);
		return itemDetail.getCurrentStock();
	}

}
