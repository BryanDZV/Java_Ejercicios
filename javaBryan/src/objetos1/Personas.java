package objetos1;

public class Personas {
	

	String nombre;
	String apellido;
	String sexo;
	int numero;
	boolean vivo;
	
	//constructor
	//para darle valores parametricos(moldes de objetos de la clase Personas)
	
	public Personas(String a, String b, String c, int d, boolean t) {

		//a los atributos le asigo parametros que vienen de la creacion de objetos
		nombre=a;
		apellido=b;
		sexo=c;
		numero=d;
		vivo=t;
		
	}

	//para variable
	public String toString() {
		return "Personas [nombre=" + nombre + ", apellido=" + apellido + ", sexo=" + sexo + ", numero=" + numero
				+ ", vivo=" + vivo + "]";
	}
	
	//para array
	
	
	
	
	
	

}
