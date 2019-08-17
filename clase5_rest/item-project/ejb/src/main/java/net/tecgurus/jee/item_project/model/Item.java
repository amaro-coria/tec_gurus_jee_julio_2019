package net.tecgurus.jee.item_project.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ITEM database table.
 * 
 */
@Entity
@Table(name="ITEM")
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_item")
	private int idItem;

	private String description;

	private String notes;

	@Temporal(TemporalType.DATE)
	private Date since;

	//bi-directional many-to-one association to ItemDetail
	@OneToMany(mappedBy="item")
	private List<ItemDetail> itemDetails;

	public Item() {
	}

	public int getIdItem() {
		return this.idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getSince() {
		return this.since;
	}

	public void setSince(Date since) {
		this.since = since;
	}

	public List<ItemDetail> getItemDetails() {
		return this.itemDetails;
	}

	public void setItemDetails(List<ItemDetail> itemDetails) {
		this.itemDetails = itemDetails;
	}

	public ItemDetail addItemDetail(ItemDetail itemDetail) {
		getItemDetails().add(itemDetail);
		itemDetail.setItem(this);

		return itemDetail;
	}

	public ItemDetail removeItemDetail(ItemDetail itemDetail) {
		getItemDetails().remove(itemDetail);
		itemDetail.setItem(null);

		return itemDetail;
	}

}