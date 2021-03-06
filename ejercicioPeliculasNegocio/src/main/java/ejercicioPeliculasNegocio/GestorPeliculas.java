package ejercicioPeliculasNegocio;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import ejercicioPeliculaDao.IPeliculasDao;
import modelo.Pelicula;

@Service
@Qualifier("gestor")
public class GestorPeliculas {
	@Autowired
	@Qualifier("dao")
	private IPeliculasDao<Pelicula> miDaoPelicula;
	
	
	public IPeliculasDao<Pelicula> getMiDaoPelicula() {
		return miDaoPelicula;
	}
	public void setMiDaoPelicula(IPeliculasDao<Pelicula> miDaoPelicula) {
		this.miDaoPelicula = miDaoPelicula;
	}
	public Pelicula altaPelicula(List<Pelicula> pelisAInsertar) {
		
		for (Pelicula peli: pelisAInsertar) {
			miDaoPelicula.create(peli);
			//System.out.println(peli);
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
