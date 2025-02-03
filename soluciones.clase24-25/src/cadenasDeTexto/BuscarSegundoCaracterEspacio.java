package cadenasDeTexto;

import utilidades.Entrada;

public class BuscarSegundoCaracterEspacio {

	public static void main(String[] args) {
		System.out.print("Introduzca un texto: ");
		String t=Entrada.cadena();
		int cnt=0; //Número de espacios en blanco encontrados
		int pos=0; //Posisición a partir de la que se busca
		int encontrado=0;
		do {
			pos=t.indexOf(" ",pos);
			System.out.println(pos);
			if (pos!=-1) { //Espacio encontrado{			
				cnt++;
				encontrado=pos;
				pos=pos+1; //La siguiente búsqueda se realizará a partir donde hemos encontradp el espacio 
		    }
			
		} while (cnt!=2 && pos!=-1); //
		if (cnt==2)
			System.out.println("El segundo espacio se encuentra en el índice "+encontrado);
		else
			System.out.println("No hay segundo espacio");
	}

}
