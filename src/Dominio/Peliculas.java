package Dominio;

import java.time.LocalDate;

public class Peliculas {
	private String nombre;
	private String genero;
	private float precio;
	private int stock;
	private LocalDate fechaLanzamiento;
	
	public Peliculas(String nombre, String genero, float precio,int stock, LocalDate fechaLanzamiento) {
		super();
		this.nombre = nombre;
		this.genero = genero;
		this.precio = precio;
		this.stock = stock;
		this.fechaLanzamiento = fechaLanzamiento;
	}

	@Override
	public String toString() {
		return "Peliculas [nombre=" + nombre + ", genero=" + genero + ", precio=" + precio + ", stock=" + stock
				+ ", fechaLanzamiento=" + fechaLanzamiento + "]\n";
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public LocalDate getFechaLanzamiento() {
		return fechaLanzamiento;
	}
	public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
}
