package ejemplos;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import objetos.Punto;

public class MeterPuntosEnUnaLista {

	public static void main(String[] args) {
		List<Punto> al=new ArrayList<Punto>();
		
		al.add(new Punto(0, 0, Color.RED));
		Punto p=new Punto(34, 12,Color.BLUE);
		al.add(p);
		al.add(new Punto(2,3));
		
		System.out.println(al);

	}

}
