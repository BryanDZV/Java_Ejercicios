package arrayList;

import java.util.ArrayList;
import java.util.List;

import utilidades.Entrada;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * solicitar numeros al usuario
		 * crear array
		 * recorrerlo en dos sentidos hasta -1
		 * 
		 * */
		
		int num;
		do {
			System.out.println("introduzca numeros para el array");
			 num=Entrada.entero();

			mostrarArrayList(num);
		} while (num!=-1);
		
	System.out.println(mostrarArrayList(num));

	}

	public static List<Integer> mostrarArrayList(int num) {
		// TODO Auto-generated method stub
		
		//crear array list
		
		List<Integer> list=new ArrayList<Integer>();
		
		//añadir
	
		if (num!=-1) {
			
			list.add(num);
		}else {
			return list;
		}
		
		
		//recorrerlo al inverso
		
		for (int i = list.size()-1; i <0; i--) {
System.out.println(list.get(i)+"");			
		}
		
		//ordernar
		
		
		
		
		return list;
	}

}
