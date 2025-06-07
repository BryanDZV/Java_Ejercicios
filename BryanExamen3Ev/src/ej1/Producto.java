package ej1;

//Clase que representa un producto en el supermercado
public class Producto implements Comparable<Producto> {
 // Atributos privados para que sólo esta clase los maneje directamente
 private String nombre;
 private String marca;
 private String categoria;
 private double precio;

 // Constructor público para inicializar un Producto
 public Producto(String nombre, String marca, String categoria, double precio) {
     this.nombre = nombre;       // Guardamos el nombre
     this.marca = marca;         // Guardamos la marca
     this.categoria = categoria; // Guardamos la categoría
     this.precio = precio;       // Guardamos el precio
 }

 // Métodos "get" (accesores) para que otras clases lean los valores
 public String getNombre() {
     return nombre; // Devuelve el nombre
 }

 public String getMarca() {
     return marca; // Devuelve la marca
 }

 public String getCategoria() {
     return categoria; // Devuelve la categoría
 }

 public double getPrecio() {
     return precio; // Devuelve el precio
 }

 // Método toString para imprimir el producto de forma legible
 @Override
 public String toString() {
     return nombre + " (" + marca + ", " + categoria + "): " + precio + "€";
 }

@Override
public int compareTo(Producto o) {
	int orden=this.nombre.compareTo(o.nombre);
	return orden;
}
}
