package ejercicioPeliculasConsola;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ejercicioPeliculasNegocio.GestorPeliculas;
import modelo.Categorias;
import modelo.Director;
import modelo.Pelicula;

public class App {
	public static void main (String[] args) {
		GestorPeliculas gestor = new GestorPeliculas();
		
		List<Pelicula> insertar = new ArrayList<Pelicula>();
		
		Pelicula p1 = new Pelicula("hh", new Director("hola"),"bb");
		Pelicula p2 = new Pelicula("aa", new Director("hola"),"dd");
		Pelicula p3 = new Pelicula("ww", new Director("hey"),"gg");
		Pelicula p4 = new Pelicula("qq", new Director("siii"),"ee");
		Pelicula p5 = new Pelicula("q", new Director("we"),"i");
		Pelicula p6 = new Pelicula("e", new Director("res"),"r");
		Pelicula p7 = new Pelicula("d", new Director("qqqqeee"),"m");
		Pelicula p8 = new Pelicula("n", new Director("weee"),"o");
		Pelicula p9 = new Pelicula("s", new Director("stas"),"t");
		Pelicula p10 = new Pelicula("eeee", new Director("plam"),"pppp");
		
		insertar.add(p1);
		insertar.add(p2);
		insertar.add(p3);
		insertar.add(p4);
		insertar.add(p5);
		insertar.add(p6);
		insertar.add(p7);
		insertar.add(p8);
		insertar.add(p9);
		insertar.add(p10);
		
		gestor.altaPelicula(insertar);
		System.out.println(gestor.listaPeliculas());
		
		
	}
}
