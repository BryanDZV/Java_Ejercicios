package objetos;

public class App {

	public static void main(String[] args) {
		Persona p;//Persona p=es la referecia de la clase que usare=Persona
		//valores
		
	// instanciar= crear objetos de la clase persona
		p=new Persona("Ana",34,true);//posicionales
		//parametrizar PARAMETROS DENTRO DE PERSONA RELACIONADO CON CONSTRUCTOR
		
		
		
		//constructor=Persona();
//		p.nombre="pepe";
//		p.edad=9;
//		p.llevaGafas=true;
		
		System.out.println(p.nombre);
		System.out.println(p.edad);
		System.out.println(p.llevaGafas);
		System.out.println("\n--------------------");
		Persona p2;
		p2=new Persona("juan");//constructor 2
		System.out.println(p2.edad);
		System.out.println(p2.nombre);
		System.out.println(p2.llevaGafas);
		
	
		

	}

}
