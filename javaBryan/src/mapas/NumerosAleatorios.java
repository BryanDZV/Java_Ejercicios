package mapas;

public class NumerosAleatorios {
	private int clave;
	private int valor;
	public int getClave() {
		return clave;
	}
	public void setClave(int clave) {
		this.clave = clave;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public NumerosAleatorios(int clave, int valor) {
		super();
		this.clave = clave;
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "NumerosAleatorios [clave=" + clave + ", valor=" + valor + "]";
	}
	

}
