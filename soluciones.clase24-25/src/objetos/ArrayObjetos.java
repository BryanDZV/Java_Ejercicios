package objetos;

public class ArrayObjetos {

	public static void main(String[] args) {
		//int [] num= {10,-9,22};
		//int [] num2= new int [3];
		System.out.println("-- Array pueblo1 --");
		Persona [] pueblo1= {new Persona("Julian"),new Persona("Ana"),new Persona()};
		for (int i = 0; i < pueblo1.length; i++) {
			System.out.println(pueblo1[i]);
		}
		pueblo1[0]=null;//Eliminamos el objeto asociado a la referencia pueblo1[0]
		for (int i = 0; i < pueblo1.length; i++) {
			System.out.println(pueblo1[i]);
		}
		
		System.out.println("-- Array pueblo2 --");
		Persona [] pueblo2=new Persona[4];
		//Creamos un objeto eb cada iteración
		for (int i = 0; i < pueblo2.length; i++) {
			pueblo2[i]=new Persona("Habitante"+i,i+25,true);
		}
		for (int i = 0; i < pueblo2.length; i++) {
			System.out.println(pueblo2[i]);
		}
		
		
		
		
		
		
	}

}
