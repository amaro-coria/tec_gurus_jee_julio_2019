package net.tecgurus.ejemplo.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tecgurus.ejemplo.HolaMundo;
import net.tecgurus.ejemplo.HolaMundoLaRevanchaLocal;
import net.tecgurus.ejemplo.persistencia.CatalogoGeneralDAO;

/**
 * Servlet implementation class HolaMundoServlet
 */
public class HolaMundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private HolaMundo hola1;
	@EJB//@Inject
	private HolaMundoLaRevanchaLocal holaRevancha;
	@EJB
	private CatalogoGeneralDAO dao;

    /**
     * Default constructor. 
     */
    public HolaMundoServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ")
		.append(request.getContextPath())
		.append(hola1.saluda())
		.append(" - ")
		.append(holaRevancha.saluda())
		.append(dao.findAll().toString())
		;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
