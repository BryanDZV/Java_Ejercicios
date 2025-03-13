package listas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Carta implements Comparable<Carta> {
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

	public Carta(Palo palo, Tipo carta) {
		super();
		this.palo = palo;
		this.carta = carta;
	}

	///
	public static void main(String[] args) {
		/**
		 * Palo.value()=array con los constantes de enum //[]=[aqui peudo elegir caul
		 * quiero coger poniendo un indice]
		 */
		List<Carta> listaBaraja = new ArrayList<>();
		Random rand = new Random();

		// Creamos las cartas y las agregamos solo si no existen ya 10 por cada palo

		for (Palo elementoPalo : Palo.values()) {// Generar 40 cartas (10 por cada palo)
			for (Tipo elementoTipo : Tipo.values()) {
				Carta carta = new Carta(elementoPalo, elementoTipo);
				if (!listaBaraja.contains(carta)) {// sin has y equal esta comparando por referencias
					listaBaraja.add(carta);

				}

			}

		}

		// Creamos las cartas aleatorias
		List<Carta> listaAzar = new ArrayList<Carta>();
		for (int i = 0; i < listaBaraja.size(); i++) {
			Carta carta = listaBaraja.get(rand.nextInt(listaBaraja.size()));

			// Comprobamos si la carta ya está en la lista antes de agregarla
			if (!listaAzar.contains(carta) && listaAzar.size()<=7) {
				listaAzar.add(carta);
			}
		}

		// Ordenamos la baraja
		System.out.println("************BARAJA****************");
		listaBaraja.sort(null);
		System.out.println(listaBaraja);
		System.out.println("************MANO AZAR****************");
		System.out.println(listaAzar);
		
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
		Carta other = (Carta) obj;
		return carta == other.carta && palo == other.palo;
	}

	@Override
	public String toString() {
		return "\n" + carta + " de " + palo;
	}

	@Override
	public int compareTo(Carta o) {
		int orden = this.getCarta().compareTo(o.getCarta());
		if (orden == 0) { // Si son iguales, comparamos por palo
			return this.getPalo().compareTo(o.getPalo());
		}
		return orden;
	}
}
