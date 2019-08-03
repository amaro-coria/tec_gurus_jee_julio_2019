package net.tecgurus.ejemplo.controller;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class CatalogoControlle {

	private String nombreCatalogo;
	
	
	public String altaCat() {
		System.out.println(nombreCatalogo);
		return "";
	}
	

	public String getNombreCatalogo() {
		return nombreCatalogo;
	}

	public void setNombreCatalogo(String nombreCatalogo) {
		this.nombreCatalogo = nombreCatalogo;
	}

}
