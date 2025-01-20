package objetos;

public class Persona {
	//Atributos
	String nombre;
	int edad;
	boolean llevaGafas;
	
	
	
	public String toString() {
		return "Persona (nombre=" + nombre + ", edad=" + edad + ", llevaGafas=" + llevaGafas + ")";
	}

	public Persona(String n, int e, boolean gafas) {
		nombre=n;
		edad=e;
		llevaGafas=gafas;
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
	
	
	
	

}
