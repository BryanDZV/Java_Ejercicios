package examenOrdinaria;

public class Tramos {

	private Integer punto1=1234;
	private Integer punto2=12345;
	@Override
	public String toString() {
		return "Tramos [punto1=" + punto1 + ", punto2=" + punto2 + "]";
	}
	public Tramos(Integer punto1, Integer punto2) {
		super();
		this.punto1 = punto1;
		this.punto2 = punto2;
	}
	
	public Integer getPunto1() {
		return punto1;
	}
	public void setPunto1(Integer punto1) {
		this.punto1 = punto1;
	}
	public Integer getPunto2() {
		return punto2;
	}
	public void setPunto2(Integer punto2) {
		this.punto2 = punto2;
	}

}
