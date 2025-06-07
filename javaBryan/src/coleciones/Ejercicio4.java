package coleciones;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import conjuntos.TipoVehiculo;
import conjuntos.Vehiculo;

public class Ejercicio4 implements Comparable<Ejercicio4> {
	private TipoVehiculo tipo;
	private int cilindrada;
	private String color;
	private String fabricante;
	private String modelo;

	@Override
	public String toString() {
		return "Ejercicio4 [fabricante=" + fabricante + ", modelo=" + modelo + ", tipo=" + tipo + ", cilindrada="
				+ cilindrada + ", color=" + color + "]";
	}

	public Ejercicio4(String fabricante, String modelo, TipoVehiculo tipo, int cilindrada, String color) {
		super();
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.tipo = tipo;
		this.cilindrada = cilindrada;
		this.color = color;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fabricante, modelo, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ejercicio4 other = (Ejercicio4) obj;
		return Objects.equals(fabricante, other.fabricante) && Objects.equals(modelo, other.modelo)
				&& tipo == other.tipo;
	}

	public static void main(String[] args) {
		Set<Ejercicio4> set1 = new HashSet<Ejercicio4>();
		Ejercicio4 v1 = new Ejercicio4("Seat", "Ibiza", TipoVehiculo.COCHE, 1200, "Rojo");
		Ejercicio4 v2 = new Ejercicio4("Seat", "Ibiza", TipoVehiculo.COCHE, 1400, "Azul");
		Ejercicio4 v3 = new Ejercicio4("Seat", "Ibiza", TipoVehiculo.COCHE, 1600, "Verde");
		Ejercicio4 v4 = new Ejercicio4("Renault", "Clio", TipoVehiculo.COCHE, 1100, "Blanco");
		Ejercicio4 v5 = new Ejercicio4("Honda", "CBR", TipoVehiculo.MOTO, 600, "Negro");
		System.out.println("****EN CONJUNTO HASH");
		// EN LISTA HASHSET
		set1.add(v1);
		set1.add(v2);
		set1.add(v3);
		set1.add(v4);
		set1.add(v5);
		// NUMERO DE ELEMENTOS EN CONJUNTO HASH
		System.out.println(set1.size());
		System.out.println("****EN LISTA");
		// EN LISTA
		List<Ejercicio4> l = new ArrayList<Ejercicio4>();
		l.add(v1);
		l.add(v2);
		l.add(v3);
		l.add(v4);
		l.add(v5);
		System.out.println(l.size());
		System.out.println("****EN CONJUNTO TREESET");
		Set<Ejercicio4> set2 = new TreeSet<Ejercicio4>();
		set2.add(v1);
		set2.add(v2);
		set2.add(v3);
		set2.add(v4);
		set2.add(v5);
		// NUMERO DE ELEMENTOS EN CONJUNTO HASH
		System.out.println(set2.size());
		for (Ejercicio4 elemento : set2) {
			System.out.println(elemento);
		}

	}// main

	@Override
	public int compareTo(Ejercicio4 o) {
		int orden = Integer.compare(this.cilindrada, o.cilindrada);
		
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
		return orden;
	}

}// clase
