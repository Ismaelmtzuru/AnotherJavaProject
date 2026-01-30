package Main;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import Dominio.Peliculas;
import Implementacion.LogicaMetodos;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner lectura = new Scanner(System.in);

		String nombre, genero;
		float precio;
		int stock, menuPrincipal, subMenu, indice;
		LocalDate fechaLanzamiento;

		Peliculas pelicula;

		LogicaMetodos logica = new LogicaMetodos();
		List<Peliculas> todasPeliculas = logica.mostrar();
		do {
			System.out.println("Menú Principal");
			System.out.println("1.Alta");
			System.out.println("2.Mostrar");
			System.out.println("3.Buscar");
			System.out.println("4.Editar");
			System.out.println("5.Eliminar");
			System.out.println("6.Buscar por nombre");
			System.out.println("7.Editar precio buscando por nombre de pelicula");
			System.out.println("8.Calcular total invertido");
			System.out.println("9.Eliminar buscando por genero");
			System.out.println("10.Salir");

			System.out.println("Elige opción deseada: ");
			menuPrincipal = lectura.nextInt();

			switch (menuPrincipal) {
			case 1:
				try {
					System.out.println("Ingresa el nombre");
					lectura = new Scanner(System.in);
					nombre = lectura.nextLine();

					System.out.println("Ingresa el genero");
					lectura = new Scanner(System.in);
					genero = lectura.nextLine();

					System.out.println("Ingresa el precio");
					lectura = new Scanner(System.in);
					precio = lectura.nextFloat();

					System.out.println("Ingresa el stock");
					lectura = new Scanner(System.in);
					stock = lectura.nextInt();

					System.out.println("Ingresa la fecha año-mes-dia: ");
					lectura = new Scanner(System.in);
					String fecha = lectura.nextLine();
					// Casteo de String a Fecha
					fechaLanzamiento = LocalDate.parse(fecha);

					pelicula = new Peliculas(nombre, genero, precio, stock, fechaLanzamiento);

					logica.guardar(pelicula);

				} catch (Exception e) {
					System.out.println("Error inesperado: " + e.getMessage());
				}
				break;
			case 2:
				if (logica.mostrar().size() > 0) {
					System.out.println(logica.mostrar());
				} else {
					System.out.println("No hay registros");
				}
				break;
			case 3:
				if (logica.mostrar().size() >= 0) {
					try {
						System.out.println("Ingresa el inidce dle registro a buscar: ");
						lectura = new Scanner(System.in);
						indice = lectura.nextInt();

						pelicula = logica.buscar(indice);
						System.out.println(pelicula);
					} catch (Exception e) {
						System.out.println("No existe el registro");
					}
				} else {
					System.out.println("No hay registros para buscar");
				}
				break;
			case 4:
				if (logica.mostrar().size() > 0) {
					try {
						System.out.println("ingresa el indice del registro a editar");
						lectura = new Scanner(System.in);
						indice = lectura.nextInt();

						pelicula = logica.buscar(indice);
						System.out.println("Se encontró la pelicula: " + pelicula.getNombre());

						System.out.println("Ingresa el nuevo genero");
						lectura = new Scanner(System.in);
						genero = lectura.nextLine();

						pelicula.setGenero(genero);

						logica.editar(indice, pelicula);
						System.out.println("Pelicula editada");
					} catch (Exception e) {
						System.out.println("No existe el registro");

					}
				} else {
					System.out.println("No hya registros para editar");
				}
				break;
			case 5:
				if (logica.mostrar().size() > 0) {
					try {
						System.out.println("ingresa el inidce dle registro a eliminar");
						lectura = new Scanner(System.in);
						indice = lectura.nextInt();

						logica.eliminar(indice);
						System.out.println("Registro eliminado");
					} catch (Exception e) {
						System.out.println("No existe registro para eliminar");
					}
				} else {
					System.out.println("No eixste registros en la lista");
				}
				break;
			case 6:

				System.out.println("Ingresa nombre de pelicula: ");
				lectura = new Scanner(System.in);
				nombre = lectura.nextLine().trim();

				pelicula = logica.buscarPorNombre(nombre);
				if (pelicula != null) {
					System.out.println(pelicula);
				} else {
					System.out.println("Pelicula no existe");
				}
				break;
			case 7:
				System.out.println("Ingresa nombre de pelicula: ");
				lectura = new Scanner(System.in);
				nombre = lectura.nextLine();

				String resultadoString = logica.editarPrecioBuscandoNombre(nombre);
				System.out.println(resultadoString);
				break;
			case 8:
				String totalInversion = logica.totalInversion();
				System.out.println(totalInversion);
				break;
			case 9:
				System.out.println("Introduce el género a eliminar");
				lectura = new Scanner(System.in);
				genero = lectura.nextLine().trim();

				logica.eliminarPeliculaGenero(genero);
				break;
			case 10:
				break;
			default:
				System.out.println("Opción inválida");
				break;
			}
		} while (menuPrincipal != 10);
		System.out.println("Programa finalizado");

	}

}
