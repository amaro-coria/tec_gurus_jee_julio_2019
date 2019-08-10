package net.tecgurus.ejemplo.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.tecgurus.ejemplo.model.Catalogo_General;
import net.tecgurus.ejemplo.persistencia.CatalogoGeneralDAO;

@ManagedBean
@ViewScoped
public class CatalogoManagedBean extends GenericMB{
	
	private List<Catalogo_General> list;
	private Catalogo_General elemento;
	
	private String codigo;
	private String descripcion;
	private Date fechaCreacion;
	
	@EJB
	private CatalogoGeneralDAO dao;
	
	@PostConstruct
	private void init() {
		initListCatalogo();
	}
	
	private void initListCatalogo() {
		try{
			list = dao.findAll();
		}catch(Exception e) {
			super.addErrorMessage("mensaje_general_error_cargar_elementos");
		}
	}
	
	public String onSave() {
		Catalogo_General nuevo = new Catalogo_General();
		nuevo.setDscCorCat(codigo);
		nuevo.setDscComCat(descripcion);
		nuevo.setFchCre(fechaCreacion);
		nuevo.setIdEstCat(1);
		try {
			dao.save(nuevo);
			initListCatalogo();
		}catch(Exception e) {
			super.addErrorMessage("mensaje_general_error_guardado");
		}
		super.addInfoMessage("mensaje_general_exito_guardado");
		return "";
	}
	
	public String onEdit() {
		try{
			dao.save(elemento);
			initListCatalogo();
		}catch(Exception e) {
			super.addErrorMessage("mensaje_general_error_actualizar");
		}
		super.addInfoMessage("mensaje_general_exito_actualizado");
		return "";
	}
	
	public String onDelete() {
		super.addInfoMessage("mensaje_general_exito_borrado");
		return "";
	}
	
	public String onCancel() {
		super.addInfoMessage("mensaje_general_accion_cancelada");
		return "";
	}
	
	//GETTERS AND SETTERS

	public List<Catalogo_General> getList() {
		return list;
	}

	public void setList(List<Catalogo_General> list) {
		this.list = list;
	}

	public Catalogo_General getElemento() {
		return elemento;
	}

	public void setElemento(Catalogo_General elemento) {
		this.elemento = elemento;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	
	
	

}
