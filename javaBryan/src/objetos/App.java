package objetos;

public class App {

	public static void main(String[] args) {
		Persona p;
		p=new Persona("Ana",22,true); //Crear objeto (instanciar)
		System.out.println(p.nombre);
		System.out.println(p.edad);
		System.out.println(p.llevaGafas);
		System.out.println("----------");
		Persona p2=new Persona("Pepe");
		System.out.println(p2.nombre);
		System.out.println(p2.edad);
		System.out.println(p2.llevaGafas);
		System.out.println("----------");
		Persona p3=new Persona();
		System.out.println(p3.nombre);
		System.out.println(p3.edad);
		System.out.println(p3.llevaGafas);
		

	}

}
