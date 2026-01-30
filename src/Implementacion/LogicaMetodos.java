package Implementacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Dominio.Peliculas;
import Interface.Metodos;
import Interface.Metodos2;

public class LogicaMetodos implements Metodos, Metodos2 {

	private List<Peliculas> lista = new ArrayList<Peliculas>();
	Scanner lecturaScanner = null;

	@Override
	public void guardar(Peliculas pelicula) {
		boolean bandera = false;
		for (Peliculas p : lista) {
			if (p.getNombre().equalsIgnoreCase(pelicula.getNombre())) {
				System.out.println("Pelicula ya existe");
				bandera = true;
				break;
			}
		}
		if (!bandera) {
			lista.add(pelicula);
			System.out.println("Pelicula guardada...");

		}

	}

	@Override
	public List<Peliculas> mostrar() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Peliculas buscar(int indice) {
		System.out.println("Pelicula Encontrada: ");
		// TODO Auto-generated method stub
		return lista.get(indice);
	}

	@Override
	public void editar(int indice, Peliculas pelicula) {
		// TODO Auto-generated method stub
		lista.set(indice, pelicula);
		Peliculas peliculaEditada = lista.get(indice);
		System.out.println("Se edito la pelicula: " + peliculaEditada.getNombre());

	}

	@Override
	public void eliminar(int indice) {
		// TODO Auto-generated method stub
		Peliculas peliculaEliminada = lista.get(indice);
		lista.remove(indice);
		System.out.println("Pelicula eliminada " + peliculaEliminada);
	}

	@Override
	public Peliculas buscarPorNombre(String nombre) {

		boolean bandera = false;
		for (Peliculas peliculas : lista) {
			if (peliculas.getNombre().trim().equalsIgnoreCase(nombre)) {
				bandera = true;
				return peliculas;
			}

		}

		return null;

	}

	@Override
	public String editarPrecioBuscandoNombre(String nombre) {
		boolean bandera = false;
		for (int i = 0; i < lista.size(); i++) {
			Peliculas p = lista.get(i);
			if (p.getNombre().equalsIgnoreCase(nombre)) {
				System.out.println("Pelicula encontrada");
				System.out.println(p.getNombre());
				System.out.println("Ingresa el nuevo precio");
				lecturaScanner = new Scanner(System.in);
				float nuevoPrecio = lecturaScanner.nextFloat();
				p.setPrecio(nuevoPrecio);
				editar(i, p);
				bandera = true;
				return "Pelicula se ha editado con éxito: " + p.getNombre();
			}
		}

		return "No se encontró la pelicula";
	}

	@Override
	public String totalInversion() {
		double totalInversion = 0.0;
		try {
			if (lista == null || lista.isEmpty()) {
				return "No existen registros para el cálculo";
			}

			for (Peliculas peliculas : lista) {
				totalInversion += (peliculas.getPrecio() * peliculas.getStock());

			}
			return "Total inversión de: " + totalInversion;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "Error al calcular inversión: " + e.getMessage();
		}
	}

	@Override
	public void eliminarPeliculaGenero(String genero) {
		// TODO Auto-generated method stub
		boolean generoEncontrado = false;

		for (int i = lista.size()-1; i >=0; i--) {
			Peliculas p = lista.get(i);
			if (p.getGenero().trim().equalsIgnoreCase(genero)) {
				generoEncontrado = true;
				lista.remove(p);
			}

		}

		if (!generoEncontrado) {
			System.out.println("Género no encontrado");
		}
		System.out.println("Peliculas eliminadas con genero: " + genero);
	}

}
