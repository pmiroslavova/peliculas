package com.sopra.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ejercicioPeliculasNegocio.GestorPeliculas;
import modelo.Director;
import modelo.Pelicula;

@Controller
@Scope("request")
public class ControladorDePeliculas {

	@Autowired
	private GestorPeliculas gestor;
	
	@RequestMapping("home")
	public ModelAndView verFormulario() {
		return new ModelAndView("formularioSpringMVC");
	}
	@RequestMapping("muestramelon")
	public @ResponseBody ModelAndView muestramelon(@RequestParam String titulo,@RequestParam String sinopsis,@RequestParam Director director ) {
		
		Pelicula pelicula = new Pelicula();
		pelicula.setTitulo(titulo);
		pelicula.setSinopsis(sinopsis);
		pelicula.setDirector(director);
		
		List<Pelicula> peliculas = new ArrayList<>();
		peliculas.add(pelicula);
		
		this.gestor.altaPelicula(peliculas);
		
		ModelAndView modelAndView = new ModelAndView("muestraDroga");
		modelAndView.addObject("pelicula",pelicula);
		
		return modelAndView;
	}
}
