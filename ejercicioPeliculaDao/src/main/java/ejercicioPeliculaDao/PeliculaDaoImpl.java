package ejercicioPeliculaDao;

import java.util.Collection;
import java.util.Map;

import modelo.Pelicula;


public class PeliculaDaoImpl implements IPeliculasDao<Pelicula>{
	
	private Map<Integer,Pelicula> listaPeliculas;
	
	public PeliculaDaoImpl(Map<Integer, Pelicula> listaPeliculas) {
		super();
		this.listaPeliculas = listaPeliculas;
	}

	public Pelicula create(Pelicula pelicula) {
		if(!listaPeliculas.containsKey(pelicula.getId())) {
			listaPeliculas.putIfAbsent(pelicula.getId(), pelicula);
		}
		return pelicula;
	}

	public Collection<Pelicula> read() {
		return listaPeliculas.values();
	}

	public Pelicula update(Pelicula pelicula) {
		if(listaPeliculas.containsKey(pelicula.getId())) {
			listaPeliculas.put(pelicula.getId(), pelicula);
			return pelicula;
		}
		return null;
	}

	public Pelicula delete(Pelicula pelicula) {
		if(listaPeliculas.containsKey(pelicula.getId())) {
			listaPeliculas.remove(pelicula.getId());
			return pelicula;
		}
		return null;
	}

	public Pelicula readById(Integer id) {
		if(listaPeliculas.containsKey(id)) {
			return listaPeliculas.get(id);
		}
		return null;
	}

}