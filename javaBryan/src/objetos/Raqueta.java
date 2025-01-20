package objetos;

import utilidades.StdDraw;

public class Raqueta {
	private Punto extIzq;
	private double largo;
	private double velocidad; //Variación de x al llamar a los métodos mover
	
	

	public Raqueta(double x, double y,double largo) {
		extIzq=new Punto(x, y);
		setLargo(largo);
		velocidad=5;
	}

	public Punto getExtIzq() {
		return extIzq;
	}

	public void setExtIzq(Punto extIzq) {
		this.extIzq = extIzq;
	}

	public double getLargo() {
		return largo;
	}

	public void setLargo(double largo) {
		if (largo<10)
			throw new RuntimeException("No se admiten raquetas de longitud menor a 10");
		this.largo = largo;
	}
	
	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	public String toString() {
		return "Raqueta [extIzq=" + extIzq + ", largo=" + largo + ", velocidad=" + velocidad + "]";
	}
	
	public static void main(String[] args) {
		Raqueta r=new Raqueta(-98,0,10);
		System.out.println(r);
	}

	public void dibujar() {
		StdDraw.setPenColor(extIzq.getColor());
		StdDraw.setPenRadius(0.01);
		StdDraw.line(extIzq.getX(),extIzq.getY(),extIzq.getX()+largo,extIzq.getY());
		
	}

	public void moverDerecha() {
		extIzq.setX(extIzq.getX()+velocidad);
		
	}

	public void moverIzquierda() {
		extIzq.setX(extIzq.getX()-velocidad);
		
	}
	
}
