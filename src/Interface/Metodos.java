package Interface;

import java.util.List;

import Dominio.Peliculas;

public interface Metodos {

	void guardar(Peliculas pelicula);
	
	List<Peliculas> mostrar();
	
	Peliculas buscar(int indice);
	
	void editar(int indice, Peliculas pelicula);
	
	void eliminar(int indice);
}
