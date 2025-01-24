package personajes;

import java.awt.Color;

import utilidades.StdDraw;

public class Puntos {
	/*
	 * atributos
	 * 
	 */

	private double x;
	private double y;
	private Color color;
	private double movX;
	private double movY;

//geter y setter movx
	public double getMovX() {
		return movX;
	}

	public void setMovX(double movX) {
		this.movX = movX;
	}

//getter y stter movy

	public double getMovY() {
		return movY;
	}

	public void setMovY(double movY) {
		this.movY = movY;
	}

	/* constructor de 3 parametros */
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

	/* geter y setter x */

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	/* geter y setter y */
	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	//getter color stter color
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	//METODO MOVER EN EJES X E Y
	public void mover() {
		/* va asigando a la x las nuevas x */
		this.x = x + movX;
		this.y = y + movY;

	}
//METODO CALCLA D ENTRE DOS  PUNTOS POR COORDENADAS
	public double distancia(Puntos otroPunto) {
		/* distancia entre los dos puntos */
		/*
		 * El Teorema de Pitagoras afirma que el valor de la hipotenusa o la distancia
		 * entre A y B ; d(A(x1,y1),b(x2,y2))=raiz(x2-x1)^2+(y2-y1)^2 es
		 */
		return Math.sqrt(Math.pow(this.x - otroPunto.x, 2) + Math.pow(this.y - otroPunto.y, 2));

	}

//metodo que devuelve UNA CLASE 
	//AQUI PUNTOSPUEDE SER DOUBLE...AQUI PUNTOS es valido 
	public Puntos puntoMedio(Puntos otroPunto) {
		Puntos m = new Puntos((this.x + otroPunto.x) / 2, (this.y + otroPunto.y) / 2);
		return m;

	}


}// todo dentro de la clase