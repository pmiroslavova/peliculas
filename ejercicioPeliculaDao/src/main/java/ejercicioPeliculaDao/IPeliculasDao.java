package ejercicioPeliculaDao;

import java.util.Collection;
import java.util.Map;

import modelo.Pelicula;

public interface IPeliculasDao<Pelicula> {
	Pelicula create(Pelicula pelicula);
	Collection<Pelicula> read ();
	Pelicula update (Pelicula pelicula);
	Pelicula delete (Pelicula pelicula);
	Pelicula readById(Integer id);
}
