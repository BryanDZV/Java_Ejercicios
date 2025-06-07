package objetos;

public class ReferenciasEnArray {

	public static void main(String[] args) {
		Persona [] a=new Persona[3];
		Persona p=new Persona("Isabel");
		
		for (int i = 0; i < a.length; i++) {
			a[i]=p;
		}
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
		
		
		
		
		
	}

}
