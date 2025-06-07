package algoritmos;

import funciones.Funciones;
import utilidades.Entrada;

public class llamarFunciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//al estar en otro ambito tienes que declarar b y a que son parametros variables
		//solo las intrucciones de funcion se lleva de ambito a otro
		
//		//LLAMAR FUNCION AREA
//		System.out.println("calcula area de triangulo ");
//		System.out.println("introduce base");
//		double a = Entrada.real();
//		System.out.println("introduce altura");
//		double b=Entrada.real();
//		System.out.println("Area triangulo es:" + Funciones.areaTriangulo(a,b));
//		
//		
//		//LAMAR CON BUCLES con n cualqiera FUNCION AREA
//		System.out.println("----------EMPIEZA BUCLE-----------");
//		for (int n = 1; n <=10; n++) {
//			System.out.println(Funciones.areaTriangulo(n,n));
//			
//			
//		}
//		
//		//llamar funcion Mayusculas
//		String may=Funciones.mayusculas("hola");
//		System.out.println(may);
//		
//		
//		//lamar funcion volumen
//		System.out.println("introducir radio");
//		double radio=Entrada.real();
//		double volumen=Funciones.volumenCirculo(radio);
//		System.out.println(volumen);
		
		//llamer funcion numero par
//		System.out.println("introduce un numero apra saber si es par o no");
//		
//		int n=Entrada.entero();
//	
//		if (true) {
//			System.out.println(n+" es Par");
//			
//		} else {
//			System.out.println(n+"es Impar");
//
//		}
		
		
		//LAMAR FUNCION MULTIPLICAR
		
		//definO valor para los parametros de la funcion
		
		double [] a= {2.3,3.3,0,8};
		double [] b= {2,2.0,2,2};
		
		
		double [] resultado= Funciones.multiplicarArrays(a, b);//llamo funcion
		
		
		//METODOS DE IMPRESION
			//METODO 1
		System.out.println("SOLUCION 1");
		System.out.println("{"+resultado[0]+","+resultado[1]+","+resultado[2]+","+resultado[3]+"}");
		
			//METODO 2
		System.out.println("SOLUCION 2");
		System.out.print("{");
		System.out.print(resultado[0]+",");
		System.out.print(resultado[1]+",");
		System.out.print(resultado[2]+",");
		System.out.print(resultado[3]);
		System.out.println("}");
		
			//METODO 3 CON FUNCION VOID
		System.out.println("SOLUCION 3---");
	Funciones.mostrarArray(resultado);
		
		
		//METODO
	
	double d, e, f;
	System.out.println("----ax2 + bx + c = 0 ------");
	System.out.println("coeficiente d ?");
	d=Entrada.real();
	System.out.println("coeficiente e ?");
	e=Entrada.real();
	System.out.println("coeficiente f ?");
	f=Entrada.real();
		
	
	//System.out.println("Ecuación a resolver: );
		
		
		
		
			
		
		
		

	}
	
	

}
