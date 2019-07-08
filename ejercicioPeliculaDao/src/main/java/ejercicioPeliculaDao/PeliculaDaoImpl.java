package ejercicioPeliculaDao;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import modelo.Pelicula;

@Repository
@Qualifier("dao")
public class PeliculaDaoImpl implements IPeliculasDao<Pelicula>{
	@Autowired
	@Qualifier("mapa")
	private Map<Integer,Pelicula> listaPeliculas;
	
	public Map<Integer, Pelicula> getListaPeliculas() {
		return listaPeliculas;
	}

	public void setListaPeliculas(Map<Integer, Pelicula> listaPeliculas) {
		this.listaPeliculas = listaPeliculas;
	}


	public Pelicula create(Pelicula pelicula) {
		if(!listaPeliculas.containsKey(pelicula.hashCode())) {
			listaPeliculas.putIfAbsent(pelicula.hashCode(), pelicula);
		}
		return pelicula;
	}

	public Collection<Pelicula> read() {
		return listaPeliculas.values();
	}

	public Pelicula update(Pelicula pelicula) {
		listaPeliculas.replace(pelicula.hashCode(), pelicula);
		return pelicula;

	}

	public Pelicula delete(Pelicula pelicula) {
		if(listaPeliculas.containsKey(pelicula.hashCode())) {
			listaPeliculas.remove(pelicula.hashCode());
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
