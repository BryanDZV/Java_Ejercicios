package ejerciciosObjetos;

import utilidades.Entrada;

public class ObjetosString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("introduzca dos textos");
		System.out.println("primer texto");
		String texto1=Entrada.cadena();
		System.out.println("primer texto");
		String texto2=Entrada.cadena();
		
		if (comparacionString(texto1,texto2)) {
			System.out.println("son iguales en contenido");
			
		} else {
			System.out.println("no son iguales en contedio");

		}//fin resultado
		
		if (comparacionString(texto1,texto2)) {
			System.out.println("son objetos iguales flecha al mismo objeto");

			
		} else {
			System.out.println("no son objetos iguales flecha a diferente objeto");

		}//fin resultadoObjeto
		

	}
	
	//-----------------------------Metodo------------------------------------------------//

	public static boolean comparacionString(String texto1, String texto2) {
		// TODO Auto-generated method stub
		boolean resultado=false;
		boolean resultadoObjeto=false;
		if (texto1.toLowerCase().equals(texto2.toLowerCase())) {
			resultado=true;
			
		}//fin if igual contenido
		
		//-------------------------------------//
		if (texto1==texto2) {
			resultadoObjeto=true;
			
		}//fin if igual objeto
		
		return resultadoObjeto;
		
		
		
	}

}
