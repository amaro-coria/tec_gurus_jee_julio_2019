package net.tecgurus.ejemplo.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import net.tecgurus.ejemplo.model.Catalogo_General;
import net.tecgurus.ejemplo.persistencia.CatalogoGeneralDAO;

@ManagedBean
public class CatalogoControlle {

	private String nombreCatalogo;
	private String descripcionCatalogo;
	@EJB
	private CatalogoGeneralDAO dao;
	
	private List<Catalogo_General> listItems;
	private Catalogo_General currentItem;
	
	@PostConstruct
	private void init() {
		initList();
	}
	
	private void initList() {
		try {
			listItems = dao.findAll();
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conexion con BD", ""));
		}
	}
	
	public String altaCat() {
		if(nombreCatalogo.toLowerCase().contains("huawei")) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No se puede almacenar el elemento", "Huawei esta prohibido por culpa de Trump"));
		    return "";
		}
		Catalogo_General cat = new Catalogo_General();
		cat.setIdEstCat(1);
		cat.setFchCre(new Date());
		cat.setDscComCat(nombreCatalogo);
		cat.setDscCorCat(descripcionCatalogo);
		try{
			dao.save(cat);
			listItems = dao.findAll();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha guardado el objeto en BD", "todo ok"));
			return "cattabla";
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se ha guardado el objeto en BD", "nada ok"));
		}
		return "";
	}
	
	//Getters & Setters
	
	public String getDescripcionCatalogo() {
		return descripcionCatalogo;
	}


	public void setDescripcionCatalogo(String descripcionCatalogo) {
		this.descripcionCatalogo = descripcionCatalogo;
	}

	public String getNombreCatalogo() {
		return nombreCatalogo;
	}

	public void setNombreCatalogo(String nombreCatalogo) {
		this.nombreCatalogo = nombreCatalogo;
	}

	public List<Catalogo_General> getListItems() {
		return listItems;
	}

	public void setListItems(List<Catalogo_General> listItems) {
		this.listItems = listItems;
	}

	public Catalogo_General getCurrentItem() {
		return currentItem;
	}

	public void setCurrentItem(Catalogo_General currentItem) {
		this.currentItem = currentItem;
	}

}
