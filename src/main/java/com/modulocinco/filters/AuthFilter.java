package com.modulocinco.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet Filter implementation class AuthFilter
 */
// Aqui especificamos las rutas que queremos que sean protegidas
// Esto es un arreglo
@WebFilter(urlPatterns = {"/hello", "/dashboard"})
public class AuthFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public AuthFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here

		// Los filters se encargan de la seguridad mientras los servlet se encargan de la linea de negocio

		// Se hace una conversion de la request y la response
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		// Obtenemos la session
		HttpSession session = httpRequest.getSession(false);

		// Se verifica que hay una session activa
		if(session == null || session.getAttribute("usuario") == null){
			// Aqui se hace una redireccion al "login"
			httpResponse.sendRedirect("login.html");
			System.out.println("Validacion no pasada!");
			// httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
		} else {
			// Continua a donde fue llamado
			chain.doFilter(httpRequest, httpResponse);
		}

		// pass the request along the filter chain
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
