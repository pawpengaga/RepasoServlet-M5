package com.modulocinco.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.modulocinco.modelo.UserDAO;
import com.modulocinco.modelo.Usuario;

/**
 * Servlet implementation class DashboardServlet
 */
@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO dao = new UserDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if (session != null && session.getAttribute("usuario") != null) {

			List<Usuario> listado = dao.getUsuarios();
			request.setAttribute("users", listado);
			request.getRequestDispatcher("usuarios.jsp").forward(request, response);

			// response.setContentType("text/html");
			// response.getWriter().println("<h1>Dashboard</h1>");
			// response.getWriter().println("<br>");
			// response.getWriter().println("<h2>Bienvenid@: " + session.getAttribute("usuario") + "</h2>");
			// response.getWriter().println("<a href=\""+ request.getContextPath()+"/logout" +"\">Cerrar sesion</a>");
		} else {
			response.getWriter().println("<h1>ACCESO DENEGADO.</h1>");
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
