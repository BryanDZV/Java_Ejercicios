package ej2;

public class PoblacionImporte implements Comparable<PoblacionImporte>{
	@Override
	public String toString() {
		return "(" + poblacion + ", " + importe + ")";
	}

	private String poblacion;
	private int importe;
	
	public String getPoblacion() {
		return poblacion;
	}

	public int getImporte() {
		return importe;
	}

	public PoblacionImporte(String poblacion, int importe) {
		super();
		this.poblacion = poblacion;
		this.importe = importe;
	}

	@Override
	public int compareTo(PoblacionImporte o) {
		//Ordenamos de mayor a menor importe
		return -(this.importe-o.importe);
	}

}
