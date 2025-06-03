package ej3;

public class FilaLetras implements Comparable<FilaLetras> {
	int fila;
	int consonantes;
	int vocales;

	public FilaLetras(int fila, int consonantes, int vocales) {
		this.fila = fila;
		this.consonantes = consonantes;
		this.vocales = vocales;
	}

	@Override
	public int compareTo(FilaLetras o) {
		if (this.consonantes != o.consonantes)
			return Integer.compare(o.consonantes, this.consonantes); // más consonantes primero
		return Integer.compare(o.vocales, this.vocales); // si empate, más vocales primero
	}
}
