package objetos;

import utilidades.Entrada;

public class IgualdaEntreObjetos {

	public static void main(String[] args) {
		//Un String es un objeto
		System.out.print("Texto1? ");
		String t1=Entrada.cadena();
		System.out.print("Texto2? ");
		String t2=Entrada.cadena();
		
		if (t1.equals(t2))
			System.out.println("Los objetos contienen el MISMO texto");
		else
			System.out.println("Los objetos contienen DIFERENTE texto");
		
		if (t1==t2)
			System.out.println("t1 y t2 tienen el mismo objeto");
		else
			System.out.println("t1 y t2 tienen asociado diferente objeto");
		
		t1=t2;
		if (t1==t2)
			System.out.println("t1 y t2 tienen asociado el mismo objeto");
		else
			System.out.println("t1 y t2 tienen asociado diferente objeto");
		if (t1.equals(t2))
			System.out.println("Los objetos contienen el MISMO texto");
		else
			System.out.println("Los objetos contienen DIFERENTE texto");
		
		t2=null;
		t1=null;
		if (t1==t2)
			System.out.println("t1 y t2 tienen asociado el mismo objeto");
		else
			System.out.println("t1 y t2 tienen asociado diferente objeto");
		if (t2.equals(t1))
			System.out.println("Los objetos contienen el MISMO texto");
		else
			System.out.println("Los objetos contienen DIFERENTE texto");

	}

}
