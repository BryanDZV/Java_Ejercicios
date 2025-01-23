package tiempo;

public class Milisegundos {
	public static void main(String[] args) throws InterruptedException {
		//Mirar el reloj antes
		long tiempo1=System.currentTimeMillis();
		System.out.println(tiempo1);
		//Medimos lo que tarde el for
		for (int i = 0; i < 2000000000; i++) {
			long m=2*i;
		}
		//Mirar el reloj después
		long tiempo2=System.currentTimeMillis();
		System.out.println(tiempo2);
		System.out.println("El bucle ha tardado "+(tiempo2-tiempo1)+" milisegundos");
		
		

	} 
	
	
}
