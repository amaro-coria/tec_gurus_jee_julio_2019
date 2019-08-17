package net.tecgurus.jee.item_project.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import net.tecgurus.jee.item_project.dao.CrudService;

/**
 * Session Bean implementation class CrudServiceBean
 */
@Stateless
@Local(CrudService.class)
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class CrudServiceBean<T> implements CrudService<T> {
   
    @PersistenceContext
    EntityManager em;
    
    public  T create(T t) {
        this.em.persist(t);
        this.em.flush();
        this.em.refresh(t);
        return t;
    }

    @SuppressWarnings("unchecked")
    public  T find(Class type,Object id) {
       return (T) this.em.find(type, id);
    }

    public void delete(Class type,Object id) {
       Object ref = this.em.getReference(type, id);
       this.em.remove(ref);
    }

    public  T update(T t) {
        return (T)this.em.merge(t);
    }

    public List findWithNamedQuery(String namedQueryName){
        return this.em.createNamedQuery(namedQueryName).getResultList();
    }
    
    public List findWithNamedQuery(String namedQueryName, Map parameters){
        return findWithNamedQuery(namedQueryName, parameters, 0);
    }

    public List findWithNamedQuery(String queryName, int resultLimit) {
        return this.em.createNamedQuery(queryName).
                setMaxResults(resultLimit).
                getResultList();    
    }

    public List findByNativeQuery(String sql, Class type) {
        return this.em.createNativeQuery(sql, type).getResultList();
    }
    
   public List findWithNamedQuery(String namedQueryName, Map parameters, int resultLimit){
        Query query = this.em.createNamedQuery(namedQueryName);
        if(resultLimit > 0)
            query.setMaxResults(resultLimit);
        Set keys = parameters.keySet();
        for(Object o : keys) {
        	query.setParameter(o.toString(), parameters.get(o));
        }
        return query.getResultList();
    }
}
