package ej2;

public class Tramos {
	private int punto1;
	private int punto2;
	public int getPunto1() {
		return punto1;
	}
	public void setPunto1(int punto1) {
		this.punto1 = punto1;
	}
	public int getPunto2() {
		return punto2;
	}
	public void setPunto2(int punto2) {
		this.punto2 = punto2;
	}
	@Override
	public String toString() {
		return "Tramos [punto1=" + punto1 + ", punto2=" + punto2 + "]";
	}
	public Tramos(int punto1, int punto2) {
		super();
		this.punto1 = punto1;
		this.punto2 = punto2;
	}
	

}
