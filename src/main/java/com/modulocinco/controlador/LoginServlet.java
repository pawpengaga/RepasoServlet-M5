package com.modulocinco.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");

		if ("admin".equals(usuario) && "1234".equals(clave)) {
			// Si las credenciales corresponden, se crea la session
			HttpSession session = request.getSession();
			session.setAttribute("usuario", "Rhea");

			// Con la session creada, redirigir a un dashboard
			response.sendRedirect(request.getContextPath()+"/dashboard");
		} else {
			// Si la clave no es correcta se muestra un mensaje
			response.setContentType("text/html");
			response.getWriter().println("<h1>Fallo login</h1>");
			response.getWriter().println("<a href=\"login.jsp\">Intentar de nuevo...</a>");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
