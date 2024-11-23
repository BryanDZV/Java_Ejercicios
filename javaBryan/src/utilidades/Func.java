package utilidades;

public class Func {
	
	public static boolean esBisiesto(int anio) {
		if (anio<=0)
			throw new RuntimeException("El año debe ser positivo: "+ anio);
		
			
		return (anio%4==0 && anio%100!=0) || anio%400==0;
	}
	
	public static double areaTriangulo(double b, double a) {
		if (b<=0)
			throw new RuntimeException("La base de triángulo del triángulo debe ser mayor que 0: "+ b);
		if (a<=0)
			throw new RuntimeException("La altura de triángulo del triángulo debe ser mayor que 0: "+ a);
			
		return b*a/2;
	}

	public static String mayusculas(String texto) {
		if (texto==null)
			throw new RuntimeException("El texto a convertir no puede ser null");
		
		String t=texto.toUpperCase();
		
		return t;
	}

	public static double volumenEsfera(double radio) {
		if (radio<=0)
			throw new RuntimeException("El radio de la esfera debe ser mayor que 0: "+ radio);
		
		return 4*Math.PI*Math.pow(radio, 3)/3;
	}

	public static boolean esPar(int n) {
		
		return n%2==0;
	}

	public static boolean esPrimo(int n) {
		if (n<=1)
			throw new RuntimeException("Sólo se admiten números mayores que 1");
		
		
		int divisor=2;
		while ( divisor<= n-1) {
			if (n%divisor==0) {
				//El número no es primo
				return false;
			}
			divisor++;
		}
		
		return true;
	}

	public static double [] ecuacionSegundoGrado(double a, double b, double c) {
		if (a==0)
			throw new RuntimeException("El coeficiente a no puede ser 0");
		
		double [] sol;
		double disc=b*b-4*a*c;
		if (disc<0)//No hay solucion
			sol= new double[0];
		else {
			if (disc==0){//1 solución
				sol= new double[1];
				sol[0]=-b/(2*a);
			}
			else{//2 soluciones
				sol= new double[2];
				sol[0]=(-b+Math.sqrt(disc))/(2*a);
				sol[1]=(-b-Math.sqrt(disc))/(2*a);
			}
		}
		
		return sol;
	}

	public static double [] multiplicarArrays(double [] a1, double [] a2) {
		if (a1.length!=a2.length)
			throw new RuntimeException("Los arrays deben tener la misma longitud");
		
		//Creo array resultado con la misma longitud
		double [] mult=new double[a1.length];
		
		for (int i = 0; i < mult.length; i++) {
			mult[i] = a1[i]*a2[i];
		}
		
		return mult;
	}

	public static void mostrarArray(double[] a) {
		System.out.print("{");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
			if (i!=a.length-1) //No escribo la , tras el último elemento
			   System.out.print(", ");
		}
		System.out.println("}");
	}
	
	
	
	
	
	
	
	
	
	
	
	
}













