package objetos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Persona implements Comparable<Persona>{
	//Atributos
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
		return llevaGafas;
	}

	public void setLlevaGafas(boolean llevaGafas) {
		this.llevaGafas = llevaGafas;
	}

	public String toString() {
		return "Persona (nombre=" + nombre + ", edad=" + edad + ", llevaGafas=" + llevaGafas + ")";
	}

	public Persona(String nombre, int edad, boolean llevaGafas) {
		this.nombre=nombre;
		this.edad=edad;
		this.llevaGafas=llevaGafas;
	}

	public Persona(String n) {
		nombre=n;
		edad=18;
		llevaGafas=false;
	}

	public Persona() {
		nombre="Alicia";
		edad=20;
		llevaGafas=true;
	}
	
	public static void main(String[] args) {
		List<Persona> l=new ArrayList<Persona>();
		
		Persona p=new Persona("Johnny",29,true);
		l.add(p);
		l.add(new Persona("Ana",54,false));
		l.add(new Persona("Filipo",17,true));
		l.add(new Persona("Ana",19,false));
		l.add(new Persona("Julia",17,true));
		l.add(new Persona("Filipo",34,false));
		
		System.out.println(l);
		l.sort(null);//Se mueven los elementos según orden definido en compareTo
		for(Persona per:l)
			System.out.println(per);
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
		return edad == other.edad ;
	}

	public int compareTo(Persona o) {
		if (this.getNombre().compareTo(o.getNombre())==0) {//Igual nombre
			return -(this.getEdad()-o.getEdad());
		}
		else
			return this.getNombre().compareTo(o.getNombre());
	}

//	public int compareTo(Persona o) {
//		//this ------  o
//		return this.getEdad()-o.getEdad();
//	}
	
//	public int compareTo(Persona o) {
//		//this ------  o
//		return this.getNombre().compareTo(o.getNombre());
//	}


}
