package listas;

import java.util.ArrayList;
import java.util.Iterator;

public class Ejercicio1ArrayListRellenar {

	/**
	 * Ejercicio 1 Crea un ArrayList con los nombres de 6 compañeros de clase. A
	 * continuación, muestra esos nombres por pantalla. Utiliza para ello un bucle
	 * for que recorra todo el ArrayList sin usar ningún índice.
	 */
	
	private String nombre;
	private String apellido;
	private int edad;
	
	public Ejercicio1ArrayListRellenar(String nombre, String apellido, int edad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public static void main(String[] args) {
		/*creado array list*/
		ArrayList<Ejercicio1ArrayListRellenar> lista=new ArrayList<Ejercicio1ArrayListRellenar>();
		/* instanciando un objeto de tipo Ejercicio1*/
		Ejercicio1ArrayListRellenar p1=new Ejercicio1ArrayListRellenar("bryan","zavala",30);
		/*añadiendo elementos a un arrayList*/
		lista.add(p1);
		lista.add(new Ejercicio1ArrayListRellenar("david","veletanga",31));
		lista.add(new Ejercicio1ArrayListRellenar("david","telo",31));
		lista.add(new Ejercicio1ArrayListRellenar("lucas","telo",22));
		lista.add(new Ejercicio1ArrayListRellenar("rene","picas",19));
		lista.add(new Ejercicio1ArrayListRellenar("david","veletanga",31));
		lista.add(new Ejercicio1ArrayListRellenar("pedro","piedras",45));
		
		System.out.println("LISTA ORIGINAL*****************************************************************");

		/*ver elemetos*/
		
		for (int i = 0; i < lista.size(); i++) {
			System.out.println("posicion objetos::"+ i);
			
		}
		for (Ejercicio1ArrayListRellenar elemento : lista) {
			System.out.println("lista original:."+ elemento);
		}
		System.out.println("LISTA BORRANDO 2 ELEMENTOS*****************************************************************");
		
		/*borrando elementos del array list*/
		lista.remove(6);
		lista.remove(p1);
		
		for (int i = 0; i < lista.size(); i++) {
			System.out.println("lista despues de borrar"+ i);
			
		}
		System.out.println("LISTA MODIFICANDO ELEMENTOS*************************************************************");
		
		/*modificando una lista*/
		lista.set(4,new Ejercicio1ArrayListRellenar("modificado","ahora",11));
		
		for (Ejercicio1ArrayListRellenar elemento : lista) {
			System.out.println("lista modificada:"+ elemento);
		}
		

	}

	@Override
	public String toString() {
		return "(" + "nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ")";
	}

}
