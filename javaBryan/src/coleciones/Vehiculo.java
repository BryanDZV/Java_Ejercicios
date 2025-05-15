package coleciones;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import conjuntos.TipoVehiculo;

public class Vehiculo implements Comparable<Vehiculo> {
	private String fabricante;
	private String modelo;
	private TipoVehiculo tipo;
	private int cilindrada;
	private String color;

	@Override
	public String toString() {
		return "\nfabricante=" + fabricante + ", modelo=" + modelo + ", tipo=" + tipo + ", cilindrada=" + cilindrada
				+ ", color=" + color;
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
		Vehiculo other = (Vehiculo) obj;
		return tipo == other.tipo;
	}

	public Vehiculo(String fabricante, String modelo, TipoVehiculo tipo, int cilindrada, String color) {
		super();
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.tipo = tipo;
		this.cilindrada = cilindrada;
		this.color = color;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public TipoVehiculo getTipo() {
		return tipo;
	}

	public void setTipo(TipoVehiculo tipo) {
		this.tipo = tipo;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	// Implementación de compareTo para TreeSet
	@Override
	public int compareTo(Vehiculo o) {
		int comparacionCilindrada = this.cilindrada - o.getCilindrada();
		return comparacionCilindrada;
	}
	// concepto de duplicidad o igualdad pero en hasset//

	public static void main(String[] args) {
		List<Vehiculo> lista = new ArrayList<>();
		Vehiculo v1 = new Vehiculo("Seat", "Ibiza", TipoVehiculo.COCHE, 1200, "Rojo");
		Vehiculo v2 = new Vehiculo("Seat", "Ibiza", TipoVehiculo.COCHE, 1400, "Azul");
		Vehiculo v3 = new Vehiculo("Seat", "Ibiza", TipoVehiculo.COCHE, 1600, "Verde");
		Vehiculo v4 = new Vehiculo("Renault", "Clio", TipoVehiculo.COCHE, 1100, "Blanco");
		Vehiculo v5 = new Vehiculo("Honda", "CBR", TipoVehiculo.MOTO, 600, "Negro");

		lista.add(v1);
		lista.add(v2);
		lista.add(v3);
		lista.add(v4);
		lista.add(v5);

		System.out.println("Número de elementos en la lista: " + lista.size());
		System.out.println("Lista de vehículos: " + lista);

		Set<Vehiculo> listahashSet = new HashSet<Vehiculo>();
		listahashSet.add(v1);
		listahashSet.add(v2);
		listahashSet.add(v3);
		listahashSet.add(v4);
		listahashSet.add(v5);
		
		

		System.out.println("\nHashSet de vehículos: " + listahashSet);
		System.out.println("Número de elementos en el HashSet: " + listahashSet.size());

		
		
		
		
		TreeSet<Vehiculo> listaTreeSet = new TreeSet<Vehiculo>();
		listaTreeSet.add(v1);
		listaTreeSet.add(v2);
		listaTreeSet.add(v3);
		listaTreeSet.add(v4);
		listaTreeSet.add(v5);

		
		
		System.out.println("\nTreeSet de vehículos: " + listaTreeSet);
		System.out.println("Número de elementos en el TreeSet: " + listaTreeSet.size());
		
		TreeSet<Vehiculo> listaTreeSetComparator=new TreeSet<Vehiculo>(new ComparadorPorCilindrada());
		
		listaTreeSetComparator.add(v1);
		listaTreeSetComparator.add(v2);
		listaTreeSetComparator.add(v3);
		listaTreeSetComparator.add(v4);
		listaTreeSetComparator.add(v5);
		
		System.out.println("\nTreeSetComparator de vehículos: " + listaTreeSetComparator);
		System.out.println("Número de elementos en el TreeSet: " + listaTreeSetComparator.size());
		
		
		/*usamos el iterator par solucionar el problema de borra por indice en conjuntos que no se puede*/
		Iterator<Vehiculo> it=lista.iterator();
		while (it.hasNext()) {
			Vehiculo vehiculo = (Vehiculo) it.next();
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
