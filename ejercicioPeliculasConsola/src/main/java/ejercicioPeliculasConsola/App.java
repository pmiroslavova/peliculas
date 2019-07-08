package ejercicioPeliculasConsola;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ejercicioPeliculasNegocio.GestorPeliculas;
import modelo.Director;
import modelo.Pelicula;

public class App {
	private static ApplicationContext context = new ClassPathXmlApplicationContext("pelicula.xml");
	public static void main (String[] args) {

		List<Pelicula> insertar = new ArrayList<Pelicula>();
		List<Pelicula> modificar = new ArrayList<Pelicula>();
		List<Pelicula> borrar = new ArrayList<Pelicula>();
		
		GestorPeliculas gestor = context.getBean(GestorPeliculas.class);
		
		Pelicula pelicula1 = context.getBean(Pelicula.class);
		pelicula1.setTitulo("p1");
		pelicula1.setDirector(new Director("Pepe"));
		pelicula1.setSinopsis("chaachiiii");
		
		Pelicula pelicula2 = context.getBean(Pelicula.class);
		pelicula2.setTitulo("p2");
		pelicula2.setDirector(new Director("Jorge"));
		pelicula2.setSinopsis("piruliiii");
		
		Pelicula pelicula3 = context.getBean( Pelicula.class);
		pelicula3.setTitulo("p3");
		pelicula3.setDirector(new Director("Stas"));
		pelicula3.setSinopsis("personiisss");
		
		Pelicula pelicula4 = context.getBean(Pelicula.class);
		pelicula4.setTitulo("p4");
		pelicula4.setDirector(new Director("Plam"));
		pelicula4.setSinopsis("guapiiissss");
		
		Pelicula pelicula5 = context.getBean(Pelicula.class);
		pelicula5.setTitulo("p5");
		pelicula5.setDirector(new Director("Cris"));
		pelicula5.setSinopsis("bebesiita");
		
		Pelicula pelicula6 = context.getBean(Pelicula.class);
		pelicula6.setTitulo("p6");
		pelicula6.setDirector(new Director("Belen"));
		pelicula6.setSinopsis("quiero");
		
		Pelicula pelicula7 = context.getBean(Pelicula.class);
		pelicula7.setTitulo("p7");
		pelicula7.setDirector(new Director("Evavi"));
		pelicula7.setSinopsis("moriiiiiirrr");
		
		Pelicula pelicula8 = context.getBean(Pelicula.class);
		pelicula8.setTitulo("p8");
		pelicula8.setDirector(new Director("Jessikitah"));
		pelicula8.setSinopsis("baaaiii");
		
		Pelicula pelicula9 = context.getBean(Pelicula.class);
		pelicula9.setTitulo("p9");
		pelicula9.setDirector(new Director("Alinn"));
		pelicula9.setSinopsis("baiiii");
		
		Pelicula pelicula10 = context.getBean(Pelicula.class);
		pelicula10.setTitulo("p10");
		pelicula10.setDirector(new Director("Pepe"));
		pelicula10.setSinopsis("pumm");

		
		insertar.add(pelicula1);
		insertar.add(pelicula2);
		insertar.add(pelicula3);
		insertar.add(pelicula4);
		borrar.add(pelicula4);
		insertar.add(pelicula5);
		borrar.add(pelicula5);
		insertar.add(pelicula6);
		insertar.add(pelicula7);
		insertar.add(pelicula8);
		insertar.add(pelicula9);
		insertar.add(pelicula10);

		
		
		gestor.altaPelicula(insertar);
		System.out.println(gestor.listaPeliculas());
		pelicula1.setTitulo("cambiado");
		pelicula2.setTitulo("cambiado2");
		modificar.add(pelicula1);
		modificar.add(pelicula2);
		gestor.updatePelicula(modificar);
		System.out.println(gestor.listaPeliculas());
		gestor.delete(borrar);
		System.out.println(gestor.listaPeliculas());
		
		
	}
}
