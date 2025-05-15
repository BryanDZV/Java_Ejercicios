package ej2;

import utilidades.StdDraw;

public class Punto {
	private double x;
	private double y;
	private double movX; //Variación de la coordenada X que produce el método mover();
	private double movY; //Variación de la coordenada Y que produce el método mover();
	
	public Punto(double cx, double cy) {
		setX(cx);
		y = cy;
	}
	
	public void mover() {
		setX(getX()+getMovX());
		setY(getY()+getMovY());
	}

	@Override
	public String toString() {
		return "Punto [x=" + x + ", y=" + y + "]";
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		if (x<-1000 || x>1000)
			throw new IllegalArgumentException("La coordenada x debe estar entre -1000 y 1000");
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void dibujar() {
		dibujar(0.005);
	}

	public void dibujar(double grosor) {
		StdDraw.setPenRadius(grosor);
		StdDraw.point(x, y);
	}

	public void rotar(double grados) {
		//Si lo grados son positivos se gira en el sentido contrario a las agujas del reloj
		//Si lo grados son negativos se gira en el sentido de las agujas del reloj
		double rad=Math.toRadians(grados);
		double nuevaX=x*Math.cos(rad)-y*Math.sin(rad);
		double nuevaY=x*Math.sin(rad)+y*Math.cos(rad);
		x=nuevaX;
		y=nuevaY;
	}
	
	
	public double distancia(double cx, double cy) {
		return distancia(cx,cy,x,y);
	}
	

	public double distancia(Punto p) {
		return distancia(p.x,p.y,x,y);
		
	}
	
	public static double distancia(Punto p1, Punto p2) {
		return distancia(p1.x,p1.y,p2.x,p2.y);
	}
	
	public static double distancia(double cx1, double cy1, double cx2, double cy2) {
		return Math.sqrt(Math.pow(cx1-cx2,2)+Math.pow(cy1-cy2,2));
	}

	public double getMovX() {
		return movX;
	}

	public void setMovX(double movX) {
		this.movX = movX;
	}

	public double getMovY() {
		return movY;
	}

	public void setMovY(double movY) {
		this.movY = movY;
	}

}
