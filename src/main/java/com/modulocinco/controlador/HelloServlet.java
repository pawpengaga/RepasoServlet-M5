package com.modulocinco.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class HelloServlet
 * 
 * Todo servlet extiende de HttpServlet
 * Con el decorador WebSevlet ponemos la informacion del mismo
 */
@WebServlet(name ="HelloServl", urlPatterns = {"/hello"} )
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
    }

	// Cada metodo del servlet tiene una request y una response, lo que le llega al Servlet y lo que este envia

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Estamos obteniendo la session previamente creada en SessionServlet
		// Si entramos aqui antes que en SessionServlet, esta pagina va a dar error
		// Esto es una demostracion de que las session son universales a las aplicaciones

		HttpSession session = request.getSession(false); // Usamos false para obtener la session existente
		// No crea una session nueva, solo la almacena en una variable

		response.setContentType("text/html");

		if(session != null && session.getAttribute("usuario") !=  null){
			response.getWriter().println("<h1>Hola tilines</h1>");
			response.getWriter().println("<p> "+ session.getAttribute("usuario") + " </p>");
		} else {
			response.getWriter().println("<p> "+ "TU ERE INVITADO" + " </p>");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
