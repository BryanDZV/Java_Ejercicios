package objetos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Persona implements Comparable<Persona> {
	// Atributos
	private String nombre;
	private int edad;
	private boolean llevaGafas;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean isLlevaGafas() {
		return llevaGafas;// en la normativa beans los bolean tiene geter y setter con isatributo
	}

	public void setLlevaGafas(boolean llevaGafas) {
		this.llevaGafas = llevaGafas;
	}

	public String toString() {
		return "Persona (nombre=" + nombre + ", edad=" + edad + ", llevaGafas=" + llevaGafas + ")";
	}

	/* metodos */
	public Persona(String n, int e, boolean gafas) {
		nombre = n;
		edad = e;
		llevaGafas = gafas;
	}

	public Persona(String n) {
		nombre = n;
		edad = 18;
		llevaGafas = false;
	}

	public Persona() {
		nombre = "Alicia";
		edad = 20;
		llevaGafas = true;
	}

	/* metood main para pruebas en esta clase */
	/*
	 * dos referencias son iguales si y solo si apuntan al mismo objeto
	 * 
	 * equal sino haces predifines evalua las referencias
	 */
	public static void main(String[] args) {
		List<Persona> l = new ArrayList<Persona>();

		Persona p = new Persona("Johnny", 29, true);
		l.add(p);
		l.add(new Persona("Ana", 54, false));
		l.add(new Persona("Filipo", 17, true));
		l.add(new Persona("Ana", 19, false));
		l.add(new Persona("Julia", 17, true));
		l.add(new Persona("Filipo", 34, false));

		System.out.println(l);

		System.out.println("-------------------------------------------------------------------------");
		l.sort(null);// Se mueven los elementos según orden definido en compareTo;obliga a tener compare to
		System.out.println(l);
	}

	@Override
	public int hashCode() {
		return Objects.hash(edad, llevaGafas, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return edad == other.edad;
	}

//	public int compareTo(Persona o) {
//		//this ------  o
//		if (this.getEdad()==o.getEdad())
//			return 0; //this es igual a o en la ordenacion
//		else {
//			if (this.getEdad()<o.getEdad()) //this es anterior a o en la ordenacion
//				return -1;
//			else
//				return 1;//this es posterior a o en la ordenacion
//		}
//	}

	public int compareTo(Persona o) {
		// this ------ o
		// return (this.getEdad()-o.getEdad());//ordenar otra forma asc y desc todo
		// dentor de -(aqui)

		// return o.getNombre().compareTo(this.getNombre());//forma invertida
		
		int ordenacion=this.getNombre().compareTo(o.getNombre());
		
		if (ordenacion==0) {
			return -(this.getEdad()-o.getEdad());
		} 
		
		
		
		return ordenacion;// forma invertida con menos
	}

}
