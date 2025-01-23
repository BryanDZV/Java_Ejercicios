package objetos;

import java.awt.Color;

import utilidades.StdDraw;

public class Puntos {
	/*
	 * atributos
	 * 
	 */

	private double x;
	private double y;
	private double movX;

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

	private double movY;
	private Color color;

	/* constructor de parametros */
	public Puntos(int x, int y, Color color) {

		this.x = x;
		this.y = y;
		this.color = color;
	}

	/* constructor de 0 parametros */
	public Puntos() {
		this.x = x;
		this.y = y;

	}

//consturdcto 2 parametros
	public Puntos(double x, double y) {
		this.x = x;
		this.y = y;
		this.color = Color.black;

	}

	/* main de puntos PARA IR COMPROBANDO AQUI */
	public static void main(String[] args) {

		// sin parametros tiene constructor predeterinado
		Puntos p1 = new Puntos(1, 2);

		// con parametros necesito otro constructor
		Puntos p = new Puntos(3, 1, Color.BLUE);

	}

	/* METODO */

	// para dibujarlo desde donde quiera

	public void dibujar() {
		// Configurar el estilo del punto
		StdDraw.setPenRadius(0.08);// Tamaño del punto
		StdDraw.setPenColor(color);// Color del punto
		// Dibujar un punto en (x, y)
		StdDraw.point(x, y);
	}

	/* ver el hascode de objetos con source to string */
	@Override
	public String toString() {
		return "Puntos [x=" + x + ", y=" + y + ", color=" + color + "]";
	}

	/* geter y setter */
	/* geter y setter */
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void mover() {
		/* va asigando a la x las nuevas x */
		this.x = x + movX;
		this.y = y + movY;

	}

	public double distancia(Puntos otroPunto) {
		/* distancia entre los dos puntos */
		/*
		 * El Teorema de Pitagoras afirma que
		 *  el valor de la hipotenusa o la distancia
		 * entre A y B ;
		 * d(A(x1,y1),b(x2,y2))=raiz(x2-x1)^2+(y2-y1)^2 es
		 */
		return Math.sqrt(Math.pow(this.x-otroPunto.x,2)+ Math.pow(this.y-otroPunto.y,2));
		
		

	}
//metodo que devuelve UNA CLASE AQUI PUNTOSPUEDE SER DOUBLE...AQUI PUNTOS es valido 
	public Puntos puntoMedio(Puntos otroPunto) {
		Puntos m = new Puntos((this.x + otroPunto.x) / 2, (this.y + otroPunto.y) / 2);
		return m;

	}

	/* geter y setter */
	/* geter y setter */
}// todo dentro de la clase