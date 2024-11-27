package com.modulocinco.listeners;

import java.util.ArrayList;
import java.util.List;

import com.modulocinco.modelo.Usuario;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class AppInitializer
 *
 */
@WebListener
public class AppInitializer implements ServletContextListener {

    /**
     * El inicializador va a guardar un lista global de usuarios para validaciones y CRUD desde todos lados
     */

    /**
     * Default constructor. 
     */
    public AppInitializer() {
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
        
        // Usaremos context, hacemos la lista
        List<Usuario> usuarios = new ArrayList<>();

        // Creamos desde el inicio un superadministrador
        usuarios.add(new Usuario("Administrador", "admin", "1234"));
        
        // Compartimos la lista, guardandola en el contexto de la app
        sce.getServletContext().setAttribute("usuarios", usuarios);

    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    }
	
}
