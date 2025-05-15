package aleatorios;

public class PruebasAleatorios {
	
	public static void main(String[] args) {
//		double al; EJEMPLO FUNCIONAAMIENTO
//		for (int i = 0; i < 10; i++) {
//			al=Math.random();
//			System.out.println(al);
//		}
		//llamo a la funcion
		//String res=tirarMoneda();
		//System.out.println(res);
		
		//llamo a la funcion con bucle
		System.out.println("Empieza bucle");
		for (int i = 0; i < 20; i++) {
			
			
			String res=tirarMoneda();
			System.out.println(res);
		}
		
		
		
	}

	
	//funcion aleatorios
	private static String tirarMoneda() {
		double al=Math.random();//entre 0 y 1 siempre este random
		
		if (al>=0.5) {
			return "cruz";
			
		}else {
			return "cara";
		}
		

	} 

}
