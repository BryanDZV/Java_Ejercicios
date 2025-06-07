package examenOrdinaria;

public class DepartamentoTotalVenta {
	private String departamento;
	private int totalVenta;
	
	
	
	@Override
	public String toString() {
		return  departamento +  totalVenta ;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public int getTotalVenta() {
		return totalVenta;
	}
	public void setTotalVenta(int totalVenta) {
		this.totalVenta = totalVenta;
	}
	public DepartamentoTotalVenta(String departamento, int totalVenta) {
		super();
		this.departamento = departamento;
		this.totalVenta = totalVenta;
	}
	

}
