package colecionesTipoExamenOrdinaria;

import java.util.List;

public class Escuela implements Comparable<Escuela> {
	private String nombre;
	private List<Integer> notas;

	@Override
	public String toString() {
		return nombre + "\t" + notas;
	}

	public String getNombre() {
		return nombre;
	}

	public Escuela(String nombre, List<Integer> notas) {
		super();
		this.nombre = nombre;
		this.notas = notas;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Integer> getNotas() {
		return notas;
	}

	public void setNotas(List<Integer> notas) {
		this.notas = notas;
	}

	public int getMax() {
		int max = notas.get(0);

		for (int i = 0; i < notas.size(); i++) {
			if (notas.get(i) > max) {
				max = notas.get(i);
			}
		}
		return max;
	}

	public void getMaxMin() {
		int min = 0;
		int max = 0;

		for (int i = 0; i < notas.size(); i++) {
			int v = notas.get(i);
			if (v < min) {
				min = v;

			}
			if (v > max) {
				max = v;
			}
		}

	};

	@Override
	public int compareTo(Escuela o) {
		int orden = this.getMax() - o.getMax();
		return orden;
	}

}
