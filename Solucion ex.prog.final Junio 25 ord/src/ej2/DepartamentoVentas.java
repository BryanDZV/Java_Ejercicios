package ej2;

public class DepartamentoVentas implements Comparable<DepartamentoVentas>{
	private String dep;
	private int totalVentas;
	
	
	
	public String getDep() {
		return dep;
	}

	public int getTotalVentas() {
		return totalVentas;
	}

	public DepartamentoVentas(String dep, int totalVentas) {
		super();
		this.dep = dep;
		this.totalVentas = totalVentas;
	}

	@Override
	public int compareTo(DepartamentoVentas o) {
		//ordenamos de mayor a menor total
		return -(this.totalVentas-o.totalVentas);
	}

	@Override
	public String toString() {
		return "DepartamentoVentas [dep=" + dep + ", totalVentas=" + totalVentas + "]";
	}
	

}
