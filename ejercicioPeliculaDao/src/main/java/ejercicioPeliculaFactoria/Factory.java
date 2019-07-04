package ejercicioPeliculaFactoria;

import java.util.HashMap;

import ejercicioPeliculaDao.IPeliculasDao;
import ejercicioPeliculaDao.PeliculaDaoImpl;
import modelo.Pelicula;


public class Factory {
	
	private static IPeliculasDao<Pelicula> miDaoPelicula;
	
	public static IPeliculasDao<Pelicula> getDaoDePelicula(){
		if(miDaoPelicula == null) {
			miDaoPelicula = new PeliculaDaoImpl(new HashMap<Integer,Pelicula>());
		}
		return miDaoPelicula;
	}
	
	
}
