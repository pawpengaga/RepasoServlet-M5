package com.modulocinco.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.modulocinco.modelo.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// List<Usuario> usuarios = new ArrayList<>();
       
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
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Por fin usamos el doPost para los registros

		// Todo lo mandado a POST se mandara a GET
		// doGet(request, response);

		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");

		// Obtener la lista desde el contexto
		List<Usuario> usuarios = (List<Usuario>) getServletContext().getAttribute("usuarios");

		// Autenticador
		boolean autenticado = usuarios.stream().anyMatch(user -> user.getNombre().equals(usuario) && user.getClave().equals(clave));
		Usuario user = usuarios.stream().filter(usr -> usr.getUsuario().equals(usuario)).findFirst().orElse(null);


		if (autenticado) {
			// Si las credenciales corresponden, se crea la session
			HttpSession session = request.getSession();
			session.setAttribute("usuario", user.getNombre());

			// Con la session creada, redirigir a un dashboard
			response.sendRedirect(request.getContextPath()+"/dashboard");
		} else {
			// Si la clave no es correcta se muestra un mensaje
			request.setAttribute("error", "Crendenciales invalidas");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

}
