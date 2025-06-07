package objetos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import utilidades.StdDraw;

public class Carta implements Comparable<Carta> {
	private Palo palo;
	private int numero;// 1..7, 10..12

	public Palo getPalo() {
		return palo;
	}

	public void setPalo(Palo palo) {
		if (palo == null)
			throw new RuntimeException("Debe indicar un palo");
		this.palo = palo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		if (numero < 1 || numero > 12 || numero == 8 || numero == 9)
			throw new RuntimeException("El número deber ser 1..7 ó 10..12");
		this.numero = numero;
	}

	@Override
	public String toString() {
		// return "Carta [palo=" + palo + ", numero=" + numero + "]";
		return "["+palo+"-"+numero+"]";// modificacion yo eligo
	}

	public Carta(Palo palo, int numero) {
		setPalo(palo);
		setNumero(numero);
	}
	
	/*para pruebas*/

	public static void main(String[] args) {
		List<Carta> baraja=Carta.crearBarajaEspaniola();
		
		List<Carta> mano=Carta.extraerMano(baraja, 20);
		System.out.println(mano);
		mano.sort(null);/*LLAMA AL COMPARETO IMPLICITAMENTE */
		System.out.println(mano);
		
		

		
		
	}
//con este metodo creo la barajo
	public static List<Carta> crearBarajaEspaniola() {
		
		List<Carta> baraja=new ArrayList<Carta>();
		
		for(Palo p:Palo.values()) {
			for(int n=1;n<=12;n++) {
				if (n!=8 && n!=9)
					baraja.add(new Carta(p, n));
			}
		}
		
		return baraja;
	
	}

	public static List<Carta> extraerMano(List<Carta> baraja, int numCartas) {
		// validacion por throw
		if (numCartas > baraja.size())
			throw new RuntimeException(
					"Baraja con: " + baraja.size() + " cartas, no hay para extraer mano de: " + numCartas);
		List<Carta> mano = new ArrayList<Carta>();// aqui lo guardo
		Random r = new Random();// para hacer indice aleatorio
		for (int i = 0; i < numCartas; i++) {
			int azar = r.nextInt(baraja.size()); // Elige índice al azar del array list baraja
			mano.add(baraja.get(azar));
			baraja.remove(azar); // Borra la carta extraida de la baraja.
		}
		return mano;
	}// fin extraer
	
//	@Override
//	public int compareTo(Carta o) {
//		return this.getNumero() - o.getNumero();
//		
//	}
	
//	public int compareTo(Carta o) {
//		return this.getPalo().compareTo(o.getPalo());
//		
//	}

	
	/*metodo para ordenar de poner implements comparable en class */
	@Override
	public int compareTo(Carta o) {
		/*
		 *Si el valor devuelto es negativo, el primer objeto es menor.
		 *Si el valor devuelto es 0, ambos objetos son iguales.
		 *Si el valor devuelto es positivo, el primer objeto es mayor.
		 * */
/*ordenado por palo*/
		int ordenacion = this.getPalo().compareTo(o.getPalo());
/*si palo es igual por numero*/
		if (ordenacion == 0) {
			
			ordenacion=(this.getNumero() - o.getNumero());

		}

		return ordenacion;
	}

	public void dibujar(double xCentro,double yCentro,double ancho, double alto) {
		String rutaImagen="imagenesBaraja/";
		String letraPalo="";
		switch (getPalo()) {
		case OROS:
			letraPalo="o";
			break;
		case COPAS:
			letraPalo="c";
			break;
		case ESPADAS:
			letraPalo="e";
			break;
		case BASTOS:
			letraPalo="b";
			break;
		}
		int num=0;
		num=this.getNumero();
		if (num>7)
			num=num-2; //12-->10  11-->9  10-->8
		rutaImagen="imagenesBaraja/"+letraPalo+num+".png";
		
		StdDraw.picture(xCentro, yCentro, rutaImagen, ancho, alto);
			
		
	}

} 