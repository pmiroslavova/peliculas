package com.sopra.web.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ejercicioPeliculaDao.PeliculaDaoImpl;
import ejercicioPeliculasNegocio.GestorPeliculas;
import modelo.Director;
import modelo.Pelicula;

/**
 * Servlet implementation class MiControlador
 */
@WebServlet({"/saludo","/misHuevos"})
public class MiControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApplicationContext context;
    

	@Override
	public void init() throws ServletException {
		this.context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// http://localhost:8080/ejemplo05web/saludo?titulo=ToyStory&sinopsis=divertido&directorNombre=garcia
		GestorPeliculas gestor = context.getBean(GestorPeliculas.class);
		Pelicula pelicula = context.getBean(Pelicula.class);
		
		String titulo = request.getParameter("titulo");
		Director director = new Director(request.getParameter("directorNombre"));
		String sinopsis = request.getParameter("sinopsis");

		pelicula.setDirector(director);
		pelicula.setSinopsis(sinopsis);
		pelicula.setTitulo(titulo);
		List<Pelicula> peliculas = new ArrayList();
		peliculas.add(pelicula);
		gestor.altaPelicula(peliculas);
		
		HttpSession session = request.getSession();
		request.setAttribute("Pelicula", titulo +" " + sinopsis + " " + director);
		getServletContext()
			.getRequestDispatcher("/WEB-INF/jsps/saludar.jsp")
			.forward(request, response);
	}

}
