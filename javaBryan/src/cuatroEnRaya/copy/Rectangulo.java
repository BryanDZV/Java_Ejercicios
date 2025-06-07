package cuatroEnRaya.copy;

import java.awt.Color;
import utilidades.StdDraw;

/**
 * Representa un rectángulo definido por dos puntos: - El vértice superior
 * izquierdo (`supIzq`). - El vértice inferior derecho (`infDer`).
 */
public class Rectangulo {
	private Punto supIzq; // Punto superior izquierdo (define el color)
	private Punto infDer; // Punto inferior derecho

	/**
	 * Constructor que crea un rectángulo a partir de dos puntos.
	 * 
	 * @param supIzq Punto superior izquierdo.
	 * @param infDer Punto inferior derecho (no puede ser null).
	 */
	public Rectangulo(Punto supIzq, Punto infDer) {
		if (infDer == null)
			throw new RuntimeException("Esquina inferior derecha no puede ser null");
		setSupIzq(supIzq);
		setInfDer(infDer);
	}

	/**
	 * Constructor que crea un rectángulo a partir de coordenadas.
	 * 
	 * @param xSupIzq Coordenada X del punto superior izquierdo.
	 * @param ySupIzq Coordenada Y del punto superior izquierdo.
	 * @param xInfDer Coordenada X del punto inferior derecho.
	 * @param yInfDer Coordenada Y del punto inferior derecho.
	 */
	public Rectangulo(double xSupIzq, double ySupIzq, double xInfDer, double yInfDer) {
		this(new Punto(xSupIzq, ySupIzq), new Punto(xInfDer, yInfDer));
	}

	// Getters
	public Punto getSupIzq() {
		return supIzq;
	}

	public Punto getInfDer() {
		return infDer;
	}

	// Setters con validación
	public void setInfDer(Punto p) {
		if (p == null)
			throw new RuntimeException("Esquina inferior derecha no puede ser null");
		if (supIzq != null && (supIzq.getX() >= p.getX() || supIzq.getY() <= p.getY()))
			throw new RuntimeException("Esquina inferior derecha inválida: " + p);
		this.infDer = p;
	}

	public void setSupIzq(Punto p) {
		if (p == null)
			throw new RuntimeException("Esquina superior izquierda no puede ser null");
		if (infDer != null && (p.getX() >= infDer.getX() || p.getY() <= infDer.getY()))
			throw new RuntimeException("Esquina superior izquierda inválida: " + p);
		this.supIzq = p;
	}

	/**
	 * Establece el color del rectángulo (mismo que el punto superior izquierdo).
	 * 
	 * @param c Color a asignar.
	 */
	public void color(Color c) {
		supIzq.setColor(c);
	}

	/**
	 * Dibuja el rectángulo relleno por defecto.
	 */
	public void dibujar() {
		dibujar(true);
	}

	/**
	 * Dibuja el rectángulo, ya sea relleno o solo el borde.
	 * 
	 * @param relleno Si es true, lo rellena; si es false, dibuja solo el borde.
	 */
	public void dibujar(boolean relleno) {
		StdDraw.setPenColor(supIzq.getColor()); // Usa el color del punto supIzq
		if (relleno) {
			StdDraw.filledRectangle(centro().getX(), centro().getY(), base() / 2, altura() / 2);// usa punto central
																								// para crear el
																								// rectangulo sino lo
																			// tngo calculo a partir
																								// del rectangulo q
																								// tenga
		} else {
			StdDraw.setPenRadius(0.005);
			StdDraw.rectangle(centro().getX(), centro().getY(), base() / 2, altura() / 2);
		}
	}

	/**
	 * Calcula la altura del rectángulo.
	 * 
	 * @return Altura (diferencia entre coordenadas Y).
	 */
	public double altura() {
		return supIzq.getY() - infDer.getY();
	}

	/**
	 * Calcula la base del rectángulo.
	 * 
	 * @return Base (diferencia entre coordenadas X).
	 */
	public double base() {
		return infDer.getX() - supIzq.getX();
	}

	/**
	 * Calcula el área del rectángulo.
	 * 
	 * @return Área del rectángulo.
	 */
	public double area() {
		return base() * altura();
	}

	/**
	 * Calcula el punto central del rectángulo usando la fórmula del promedio.
	 * 
	 * Fórmula del centro de un rectángulo a partir de sus esquinas opuestas:
	 * x_centro = (x_supIzq + x_infDer) / 2 y_centro = (y_supIzq + y_infDer) / 2
	 * 
	 * 🔹 Esta fórmula solo es válida si se usan **dos puntos opuestos** (esquinas).
	 * 🔹 Si usas otros puntos que no sean opuestos, obtendrás un punto medio de ese
	 * segmento
	 * 
	 * @return Punto en el centro del rectángulo. Calcula el punto central del
	 *         rectángulo usando la fórmula del promedio.**dos puntos opuestos**
	 * 
	 *         Conclusión: Si buscas el centro de la diagonal, promedias las
	 *         coordenadas. Si buscas la distancia de la diagonal, usas la raíz
	 *         cuadrada de la suma de los cuadrados de las diferencias.
	 */
	public Punto centro() {
		return new Punto((supIzq.getX() + infDer.getX()) / 2, (supIzq.getY() + infDer.getY()) / 2);
	}

	/**
	 * todo estos metodo podria usar 3 opciones q se me ocuren 1formula de punto
	 * medio 2si ya tengo el centro y 2 puntos opuesto tengo todos los centro de
	 * cada lado 3usando base y la altura y 2 dos puntos opuestos *
	 * 
	 * @return
	 */
	// Métodos para obtener los puntos centrales de cada lado
	public Punto centroDer() {
		return new Punto(infDer.getX(), centro().getY());
		// return new Punto(infDer.getX(), infDer.getY()+altura()/2);
	}

	public Punto centroInf() {  
	    return new Punto(infDer.getX() - base() / 2, infDer.getY());}  
	  //return new Punto((infDer().getX-supIzq().getX)/2,infDer().getY());
	    //  Calcula el punto medio del lado inferior del rectángulo.  
	    // - Se obtiene tomando la coordenada X del vértice inferior derecho (infDer.getX())  
	    //   y restándole la mitad de la base.  La coordenada Y se mantiene igual a la de infDer, ya que está en la base del rectángulo.  
	/**
	 * /Regla clave Siempre que calcula un punto medio en un segmento, debes partir
	 * de un extremo conocido y sumar o restablecer la mitad de la longitud del
	 * segmento infDer.getX() - base() / 2
	 */

	public Punto centroIzq() {
		return new Punto(supIzq.getX(), centro().getY());
		//return new Punto (supIzq.getX(),supIzq().getY()-altura()/2)
	}

	public Punto centroSup() {
		return new Punto(centro().getX(), supIzq.getY());
		//return new Punto(supIzq.getX()+base()/2,supIzq.getY())
	}

	// Métodos para obtener los vértices restantes
	public Punto infIzq() {
		return new Punto(supIzq.getX(), infDer.getY());
	}

	public Punto supDer() {
		return new Punto(infDer.getX(), supIzq.getY());
	}

	/**
	 * Aplica un movimiento al rectángulo.
	 * 
	 * @param movX Desplazamiento en X.
	 * @param movY Desplazamiento en Y.
	 */
	public void movimiento(double movX, double movY) {
		supIzq.setMovX(movX);
		supIzq.setMovY(movY);
		infDer.setMovX(movX);
		infDer.setMovY(movY);
	}

	/**
	 * Aplica el movimiento a los puntos del rectángulo.
	 */
	public void mover() {
		supIzq.mover();
		infDer.mover();
	}

	/**
	 * Representación en String del rectángulo.
	 */
	@Override
	public String toString() {
		return "Rectangulo [supIzq=" + supIzq + ", infDer=" + infDer + "]";
	}
}
