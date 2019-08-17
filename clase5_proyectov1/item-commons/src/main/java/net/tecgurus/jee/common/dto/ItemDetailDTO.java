package net.tecgurus.jee.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ItemDetailDTO implements Serializable{

	private int idItemDetail;
	private BigDecimal currentStock;
	private String emailAlert;
	private BigDecimal minimumStock;
	private Integer itemParentId;
	
	
	public int getIdItemDetail() {
		return idItemDetail;
	}
	public void setIdItemDetail(int idItemDetail) {
		this.idItemDetail = idItemDetail;
	}
	public BigDecimal getCurrentStock() {
		return currentStock;
	}
	public void setCurrentStock(BigDecimal currentStock) {
		this.currentStock = currentStock;
	}
	public String getEmailAlert() {
		return emailAlert;
	}
	public void setEmailAlert(String emailAlert) {
		this.emailAlert = emailAlert;
	}
	public BigDecimal getMinimumStock() {
		return minimumStock;
	}
	public void setMinimumStock(BigDecimal minimumStock) {
		this.minimumStock = minimumStock;
	}
	public Integer getItemParentId() {
		return itemParentId;
	}
	public void setItemParentId(Integer itemParentId) {
		this.itemParentId = itemParentId;
	}
	
}
