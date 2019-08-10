package net.tecgurus.ejemplo.persistencia;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import net.tecgurus.ejemplo.model.Catalogo_General;

/**
 * Session Bean implementation class CatalogoGeneralDAO
 */
@Stateless
@LocalBean
public class CatalogoGeneralDAO {
	
	
	@PersistenceContext(name = "primary")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public CatalogoGeneralDAO() {
        // TODO Auto-generated constructor stub
    }
    
    public Catalogo_General save(Catalogo_General cat) {
    	em.persist(cat);
    	return cat;
    }
    
    
    public List<Catalogo_General> findAllNamed(){
    	String namedQuery = "Catalogo_General.findAll";
    	Query query = em.createNamedQuery(namedQuery);
    	List<Catalogo_General> lista = query.getResultList();
    	return lista;
    }
    
    public List<Catalogo_General> findAllNamedGenerics(){
    	String namedQuery = "Catalogo_General.findAll";
    	TypedQuery<Catalogo_General> query = em.createNamedQuery(namedQuery, Catalogo_General.class);
    	List<Catalogo_General> lista = query.getResultList();
    	return lista;
    }
    
    public List<Catalogo_General> findAll(){
    	//String jpql = "FROM Catalogo_General"; //select * from catalogo_General
    	String jpql = "SELECT c FROM Catalogo_General c";
    	Query query = em.createQuery(jpql);
    	List<Catalogo_General> lista = query.getResultList();
    	return lista;
    }
    
    public List<Catalogo_General> findAllGenerics(){
    	//String jpql = "FROM Catalogo_General"; //select * from catalogo_General
    	String jpql = "SELECT c FROM Catalogo_General c";
    	TypedQuery<Catalogo_General> query = em.createQuery(jpql,Catalogo_General.class);
    	List<Catalogo_General> lista = query.getResultList();
    	return lista;
    }

}
