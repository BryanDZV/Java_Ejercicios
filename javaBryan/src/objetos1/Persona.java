package objetos1;

public class Persona {

	// contiene atributos
	String nombre = "lucas";// incializacion por defecto
	int edad;
	boolean llevaGafas;

	// CONSTRUCTOR !!NO DEVUELVE NADA FUCNION=DAR VALORES A ATRIBUTOS DE LA CLASE

	public Persona(String n, int e, boolean gafas) {
		nombre = n;
		edad = e;
		llevaGafas = gafas;
	}

	
	//CONSTRUCTOR 2 SOLO 1 ATRIBUTO 
	

	public Persona(String n) {
		// solo con 1 atributo
		
		nombre=n;
		edad=89;
		
	}
	
	
	
	
	
	
	

};
