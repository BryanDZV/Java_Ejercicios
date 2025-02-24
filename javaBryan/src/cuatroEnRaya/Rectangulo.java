package cuatroEnRaya;

import java.awt.Color;
import utilidades.StdDraw;

/**
 *Consideramos rectángulos horizontales.
 *Definimos un rectángulo mediante el vértice superior izquierdo y el inferior derecho.
 *
 */
public class Rectangulo {
	private Punto supIzq; //El color de este punto indica el color del rectángulo
	private Punto infDer;
	
	
	public Rectangulo(Punto supIzq, Punto infDer) {
		if (infDer==null)
			throw new RuntimeException("Esquina inferior derecha no puede ser null");
		this.infDer=infDer;
		setSupIzq(supIzq);
		setInfDer(infDer);
	}

	
	public Rectangulo(double xSupIzq,double ySupIzq,double xInfDer,double yInfDer) {
		this(new Punto(xSupIzq,ySupIzq),new Punto(xInfDer,yInfDer));
	}
	
	public Punto getSupIzq() {
		return supIzq;
	}

	public Punto getInfDer() {
		return infDer;
	}

	public String toString() {
		return "Rectangulo [supIzq=" + supIzq + ", infDer=" + infDer + "]";
	}


	public void setInfDer(Punto p) {
		if (p==null)
			throw new RuntimeException("Esquina inferior derecha no puede ser null");
		if (supIzq.getX()>=p.getX() || supIzq.getY()<=p.getY())
			throw new RuntimeException("Esquina inferior derecha erronea "+p);
		this.infDer = p;
	}


	public void setSupIzq(Punto p) {
		if (p==null)
			throw new RuntimeException("Esquina superior izquierda no puede ser null");
		if (p.getX()>=infDer.getX() || p.getY()<=infDer.getY())
			throw new RuntimeException("Esquina Superior izquierda erronea "+p);
		this.supIzq = p;
	}
	
	
	public void color(Color c) {
		supIzq.setColor(c);
	}

	
	//El color del rectángulo es el color del punto supIzp
	public void dibujar() {
		dibujar(true);
	}

	public void dibujar(boolean relleno) {
		StdDraw.setPenColor(supIzq.getColor());
		if (relleno)
			StdDraw.filledRectangle(centro().getX(), centro().getY(), base()/2, altura()/2);
		else {
			StdDraw.setPenRadius(0.005);
			StdDraw.rectangle(centro().getX(), centro().getY(), base()/2, altura()/2);
		}
	}


	public double altura() {
		return supIzq.getY()-infDer.getY();
	}


	public double base() {
		return infDer.getX()-supIzq.getX();
	}

	public double area() {
		return base()*altura();
	}


	public Punto centro() { //Devuelve punto en el centro del rectangulo
		return new Punto((supIzq.getX()+infDer.getX())/2, (supIzq.getY()+infDer.getY())/2);
	}


	public Punto centroDer() { //Devuelve punto en el centro del lado derecho
		return new Punto(infDer.getX(), infDer.getY()+altura()/2);
	}


	public Punto centroInf() { //Devuelve punto en el centro del lado inferior
		return new Punto(infDer.getX()-base()/2, infDer.getY());
	}


	public Punto centroIzq() { //Devuelve punto en el centro del lado izquierdo
		return new Punto(supIzq.getX(), supIzq.getY()-altura()/2);
	}


	public Punto centroSup() { //Devuelve punto en el centro del lado superior
		return new Punto(supIzq.getX()+base()/2, supIzq.getY());
	}


	public Punto infIzq() { //Devuelve punto vertice inferior izquierdo
		return new Punto(supIzq.getX(),infDer.getY());
	}


	public Punto supDer() { //Devuelve punto vertice superior derecho
		return new Punto(infDer.getX(),supIzq.getY());
	}


	public void movimiento(double movX, double movY) {
		supIzq.setMovX(movX);
		supIzq.setMovY(movY);
		infDer.setMovX(movX);
		infDer.setMovY(movY);
	}


	public void mover() {
		supIzq.mover();
		infDer.mover();
	}
	
} 


