package Interface;

import Dominio.Peliculas;

public interface Metodos2 {
	public Peliculas buscarPorNombre(String nombre);
	
	public String editarPrecioBuscandoNombre(String nombre);
	
	public String totalInversion();
	
	public void eliminarPeliculaGenero(String genero);
}
