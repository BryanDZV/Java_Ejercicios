package listas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Ejercicio6Carta implements Comparable<Ejercicio6Carta> {
	private Palo palo;
	private Tipo carta;

	public Palo getPalo() {
		return palo;
	}

	public void setPalo(Palo palo) {
		this.palo = palo;
	}

	public Tipo getCarta() {
		return carta;
	}

	public void setCarta(Tipo carta) {
		this.carta = carta;
	}

	public Ejercicio6Carta(Palo palo, Tipo carta) {
		super();
		this.palo = palo;
		this.carta = carta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(carta, palo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ejercicio6Carta other = (Ejercicio6Carta) obj;
		return carta == other.carta && palo == other.palo;
	}

	@Override
	public String toString() {
		return "\n" + carta + " de " + palo;
	}

	@Override
	public int compareTo(Ejercicio6Carta o) {
		int orden = this.getCarta().compareTo(o.getCarta());
		if (orden == 0) { // Si son iguales, comparamos por palo
			return this.getPalo().compareTo(o.getPalo());
		}
		return orden;
	}

	///
	public static void main(String[] args) {

		/**
		 * Ejercicio 6 Realiza un programa que escoja al azar 8 cartas de la baraja
		 * española (8 objetos de la clase Carta, cada objeto contiene palo y tipo de
		 * carta). La baraja española se compones de 40 cartas con 4 palos: oros, copas,
		 * espadas y bastos, y 10 tipos de carta por cada palo. Cada tipo de carta tiene
		 * un número que puede ser: 1(as), 2(dos), 3(tres), 4(cuatro), 5(cinco),
		 * 6(seis), 7(siete), 10(sota), 11(caballo) y 12(rey). Un total de 40 cartas. La
		 * forma de representar un objeto Carta como una cadena de caracteres (toString)
		 * será similar a la siguiente: sota de espadas, cuatro de bastos, as de oros,
		 * etc. Emplea una lista para almacenar toda la baraja y otra lista para
		 * almacenar la mano extraída al azar. En la mano extraída no puede haber cartas
		 * duplicadas.
		 */

		/**
		 * Palo.value()=array con los constantes de enum //[]=[aqui peudo elegir caul
		 * quiero coger poniendo un indice]
		 */
		List<Ejercicio6Carta> listaBaraja = new ArrayList<>();
		Random rand = new Random();

		// Creamos las cartas y las agregamos solo si no existen ya 10 por cada palo

		for (Palo elementoPalo : Palo.values()) {// Generar 40 cartas (10 por cada palo)
			for (Tipo elementoTipo : Tipo.values()) {
				Ejercicio6Carta carta = new Ejercicio6Carta(elementoPalo, elementoTipo);
				if (!listaBaraja.contains(carta)) {// sin has y equal esta comparando por referencias
					listaBaraja.add(carta);

				}

			}

		}

		// Creamos las cartas aleatorias
		List<Ejercicio6Carta> listaAzar = new ArrayList<Ejercicio6Carta>();
		for (int i = 0; i < listaBaraja.size(); i++) {
			Ejercicio6Carta carta = listaBaraja.get(rand.nextInt(listaBaraja.size()));

			// Comprobamos si la carta ya está en la lista antes de agregarla
			if (!listaAzar.contains(carta) && listaAzar.size() <= 7) {
				listaAzar.add(carta);
			}
		}

		// Ordenamos la baraja
		System.out.println("************BARAJA****************");
		listaBaraja.sort(null);
		System.out.println(listaBaraja);
//		for (Ejercicio6Carta elementoBaraja : listaBaraja) {
//			System.out.print(elementoBaraja);
//		}
		System.out.println("************MANO AZAR****************");
		System.out.println(listaAzar);
		System.out.println("************CRITERIO PERSONALIZADO****************");
		listaBaraja.sort(new OrdenamientoPorPaloyCarta());
		System.out.println(listaBaraja);
		

	}

}
