package net.tecgurus.jee.item_project.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tecgurus.jee.item_project.business.ItemDetailService;

/**
 * Servlet implementation class PruebaServlet
 */
public class PruebaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ItemDetailService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PruebaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(service.findCurrentStockByItemParent(1).toPlainString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
