package net.tecgurus.ejemplo;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class HolaMundoLaRevancha
 */
@Stateless
public class HolaMundoLaRevancha implements HolaMundoLaRevanchaLocal {

    /**
     * Default constructor. 
     */
    public HolaMundoLaRevancha() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public String saluda() {
    	return "Hola mundo con interfaz local por aparte";
    }

}
