package ejercicioPeliculasNegocio;

import java.util.Collection;
import java.util.List;

import ejercicioPeliculaDao.IPeliculasDao;
import ejercicioPeliculaFactoria.Factory;
import modelo.Pelicula;

public class GestorPeliculas {
	private IPeliculasDao<Pelicula> miDaoPelicula = Factory.getDaoDePelicula();
	
	
	
	public Pelicula altaPelicula(List<Pelicula> pelisAInsertar) {
		
		for (Pelicula peli: pelisAInsertar) {
			miDaoPelicula.create(peli);
		}
		
		return null;
		
	}
	public Collection<Pelicula> listaPeliculas(){
		return miDaoPelicula.read();
	}
	public void updatePelicula(List<Pelicula> pelisAModificar) {
		for(Pelicula peli: pelisAModificar) {
			miDaoPelicula.update(peli);
		}
	}
	public void delete(List<Pelicula> pelisABorrar) {
		for(Pelicula peli: pelisABorrar) {
			miDaoPelicula.delete(peli);
		}
	}
}
