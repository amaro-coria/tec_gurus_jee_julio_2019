package net.tecgurus.jee.item_project.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ITEM_DETAIL database table.
 * 
 */
@Entity
@Table(name="ITEM_DETAIL")
@NamedQueries({
	@NamedQuery(name="ItemDetail.findAll", query="SELECT i FROM ItemDetail i"),
	@NamedQuery(name = "ItemDetail.findByItemId", query = "SELECT i FROM ItemDetail i WHERE i.item.idItem = :idItem")
})

public class ItemDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_item_detail")
	private int idItemDetail;

	@Column(name="current_stock")
	private BigDecimal currentStock;

	@Column(name="email_alert")
	private String emailAlert;

	@Column(name="minimum_stock")
	private BigDecimal minimumStock;

	//bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name="id_item")
	private Item item;

	public ItemDetail() {
	}

	public int getIdItemDetail() {
		return this.idItemDetail;
	}

	public void setIdItemDetail(int idItemDetail) {
		this.idItemDetail = idItemDetail;
	}

	public BigDecimal getCurrentStock() {
		return this.currentStock;
	}

	public void setCurrentStock(BigDecimal currentStock) {
		this.currentStock = currentStock;
	}

	public String getEmailAlert() {
		return this.emailAlert;
	}

	public void setEmailAlert(String emailAlert) {
		this.emailAlert = emailAlert;
	}

	public BigDecimal getMinimumStock() {
		return this.minimumStock;
	}

	public void setMinimumStock(BigDecimal minimumStock) {
		this.minimumStock = minimumStock;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}