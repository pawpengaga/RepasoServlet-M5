package com.modulocinco.listeners;

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
        // Usaremos context
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    }
	
}
