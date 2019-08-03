package net.tecgurus.ejemplo;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class HolaMundo
 */
@Stateless
@LocalBean
public class HolaMundo {

    /**
     * Default constructor. 
     */
    public HolaMundo() {
        // TODO Auto-generated constructor stub
    }
    
    public String saluda() {
    	return "Hola mundo desde EJB Stateless";
    }

}
