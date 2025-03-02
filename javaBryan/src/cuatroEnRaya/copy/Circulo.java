package cuatroEnRaya.copy;

import java.awt.Color;
import java.util.Objects;

import utilidades.StdDraw;

public class Circulo {
	private Punto centro;// atributo punto de la clase circulo, ES UNA CLASE ACTUANDO COMO ATRIBUTO
	private double radio; // atributo radio

	// constructor
	public Circulo(Punto centro, double radio) {// crea circulos con punto y radio

		setCentro(centro);// usa el set al crear circulos y al mismo tiempo los valida
		setRadio(radio);
	}

	// constructor
	public Circulo(double x, double y, double rad) {// crea circulos con cordenadas y radio
		centro = new Punto(x, y);// usas las coordenas de atributo Punto centro
		setRadio(rad);// usa un radio argumento
	}

	// constructor
	public Circulo() {// se crea ciruclos sin argumentos
		centro = new Punto(0, 0);// usa las coordenadas x e y con 0 0
		setRadio(10);// usa radio por defecto 10
	}

	// metodo set valida radio no sea 0
	public void setRadio(double radio) {// almacena radio como argumento
		if (radio <= 0)
			throw new IllegalArgumentException("El radio de un círculo debe ser mayor que 0");
		this.radio = radio;// asigna al atributo radio el argumento pasado
	}

	public Punto getCentro() {// get para obtener el Punto centro desde otras clases accesible desde objetos
		return centro;
	}

	public void setCentro(Punto centro) {// set del punto centro se incia con un punto
		if (centro == null)// valida que nos que sea nulo el punto centro
			throw new IllegalArgumentException("Un círculo no puede tener centro nulo");
		this.centro = centro;// le asiga al punto centro el argumento que le llege
	}

	public double getRadio() {// get pra obtener el radio accesible desde objetos de la clase Circulo
		return radio;
	}

	@Override
	public String toString() {// covierte el objeto circulo en cadena de texto
		return "Circulo [centro=" + centro + ", radio=" + radio + "]";// imprime el centro del circulo que es Punto
																		// centro y el radio
	}

	public void dibujar() {// sin argumentos se inicia cuando es llamada
		StdDraw.setPenColor(centro.getColor());// almacena el coler del Punto centro objetivo usar el color
		StdDraw.filledCircle(centro.getX(), centro.getY(), radio);// almacena la x e y del Punto centro y el radio para
																	// rellena el circulo
	}

	public void setColor(Color c) {// alamacena un color c
		centro.setColor(c);// modifica el color argumento al Punto centro
	}

	public void mover() {// sin argumentos e incia cuand es llamado
		centro.mover();// parece que da movimiento al Punto centro

	}

	public void movimiento(double movX, double movY) {// recibe 2 argumentos coordenadas x e y
		centro.setMovX(movX);// modifica la MovX con el argumento recibid
		centro.setMovY(movY);// ase lo mismo con la y
	}

	public boolean seSuperpone(Circulo c) {// almacena un objeto circulo

		// true si el círculo(this) se superpone con otro círculo c.
		// Se superponen si la distancia entre sus centros es menor que la suma de sus
		// radios.
		return this.centro.distancia(c.getCentro()) < this.radio + c.getRadio();// cojo el Punto centro del circulo y
																				// distancia al Punto centro del otro
																				// circulo comparo con la suma del radio
																				// del circulo+el radio del troo ciruclo
	}

	public boolean seSuperpone(Rectangulo r) {
		/**
		 * Voy a reformular lo que dijiste con algunos detalles adicionales para que
		 * quede aún más claro:
		 * 
		 * 1️⃣ Primero, verifique si el centro del círculo ( centro.x, centro.y) está
		 * dentro o fuera del rectángulo.
		 * 
		 * Si está dentro , no se cambia nada. Si está fuera , se ajusta el punto más
		 * cercano dentro del rectángulo ( px, py). Se hacen comparaciones con los
		 * bordes (izquierda, derecha, arriba, abajo) para encontrar ese punto más
		 * cercano . 2️⃣ Ese nuevo punto ( px, py) representa el "límite hipotético del
		 * círculo con el rectángulo" porque es el punto más cercano dentro del
		 * rectángulo al centro del círculo.
		 * 
		 * 3️⃣ Se calcula la distancia entre el centro del círculo y este nuevo punto (
		 * px, py).
		 * 
		 * Si la distancia es menor que la radio , significa que el círculo y el
		 * rectángulo se superponen . Si la distancia es mayor o igual al radio , no hay
		 * superposición .
		 */
		// Método que verifica si el círculo se superpone con un rectángulo dado (r)

		// 1️ Encontrar el punto más cercano del rectángulo al centro del círculo
		// (px, py) será el punto más cercano dentro del rectángulo al centro del
		// círculo

		double px = centro.getX(); // Tomamos la coordenada X del centro del círculo

		// Si px está a la izquierda del rectángulo, lo ajustamos al borde izquierdo
		if (px < r.getSupIzq().getX())
			px = r.getSupIzq().getX();

		// Si px está a la derecha del rectángulo, lo ajustamos al borde derecho
		if (px > r.getInfDer().getX())
			px = r.getInfDer().getX();

		double py = centro.getY(); // Tomamos la coordenada Y del centro del círculo

		// Si py está por encima del rectángulo, lo ajustamos al borde superior
		if (py > r.getSupIzq().getY())
			py = r.getSupIzq().getY();

		// Si py está por debajo del rectángulo, lo ajustamos al borde inferior
		if (py < r.getInfDer().getY())
			py = r.getInfDer().getY();

		// 2️⃣ Comprobar si la distancia entre el centro del círculo y el punto más
		// cercano es menor que el radio
		return centro.distancia(new Punto(px, py)) < radio;
		// Si la distancia es menor que el radio, significa que hay superposición
	}

	public boolean dentroDe(Rectangulo r) {
		// Este método devuelve true si TODO el círculo está dentro del rectángulo.
		// Para que esto ocurra, el círculo NO debe sobresalir en ninguna dirección.

		return
		// 1️⃣ Verifica que el borde derecho del círculo esté dentro del rectángulo
		centro.getX() + radio < r.getInfDer().getX() &&
		// Esto comprueba que la coordenada X más el radio (es decir, el extremo derecho
		// del círculo)
		// sea menor que la coordenada X del vértice inferior derecho del rectángulo.
		// Si es verdadero, significa que el círculo no sobresale por la derecha.

		// 2️⃣ Verifica que el borde izquierdo del círculo esté dentro del rectángulo
				centro.getX() - radio > r.getSupIzq().getX() &&
				// Esto comprueba que la coordenada X menos el radio (es decir, el extremo
				// izquierdo del círculo)
				// sea mayor que la coordenada X del vértice superior izquierdo del rectángulo.
				// Si es verdadero, significa que el círculo no sobresale por la izquierda.

				// 3️⃣ Verifica que el borde superior del círculo esté dentro del rectángulo
				centro.getY() + radio < r.getSupIzq().getY() &&
				// Esto comprueba que la coordenada Y más el radio (es decir, el extremo
				// superior del círculo)
				// sea menor que la coordenada Y del vértice superior izquierdo del rectángulo.
				// Si es verdadero, significa que el círculo no sobresale por arriba.

				// 4️⃣ Verifica que el borde inferior del círculo esté dentro del rectángulo
				centro.getY() - radio > r.getInfDer().getY();
		// Esto comprueba que la coordenada Y menos el radio (es decir, el extremo
		// inferior del círculo)
		// sea mayor que la coordenada Y del vértice inferior derecho del rectángulo.
		// Si es verdadero, significa que el círculo no sobresale por abajo.
	}

	@Override
	public int hashCode() {
		// Genera un número único basado en el centro y el radio del círculo.
		// Esto es útil para estructuras como HashSet o HashMap, que usan hashCode()
		// para organizar datos.
		return Objects.hash(centro, radio);
	}

	/**
	 * 
	 * ¡Exacto! Si no sobrescribes equals(), Java compara por referencia, es decir, revisa si los dos objetos están en la misma posición de memoria.

Por ejemplo, si no tuvieras el método equals(), este código daría false:

java
Copiar
Editar
Circulo c1 = new Circulo(new Punto(3,4), 5);
Circulo c2 = new Circulo(new Punto(3,4), 5);

System.out.println(c1 == c2); // false (distintas referencias en memoria)
System.out.println(c1.equals(c2)); // También false si no sobrescribimos equals()
 Sin equals(), aunque los círculos sean iguales en datos, Java los considera distintos porque están en diferentes posiciones de memoria.*/
	@Override
	public boolean equals(Object obj) {
	    // 1️⃣ Si el objeto comparado es el mismo que el actual (misma referencia en memoria), retorna true.
	    if (this == obj) 
	        return true;

	    // 2️⃣ Si el objeto comparado es null, retorna false (no puede ser igual a un objeto nulo).
	    if (obj == null) 
	        return false;

	    // 3️⃣ Si el objeto comparado no es de la misma clase (no es un Circulo), retorna false.
	    if (getClass() != obj.getClass()) 
	        return false;

	    // 4️⃣ Convertimos el objeto "obj" a un Circulo para poder acceder a sus atributos.
	    Circulo other = (Circulo) obj;

	    // 5️⃣ Comparamos si el centro del círculo actual es igual al centro del otro círculo.
	    //    Usamos Objects.equals() para evitar problemas con null (evita NullPointerException).
	    boolean mismoCentro = Objects.equals(centro, other.centro);

	    // 6️⃣ Comparamos los radios de los círculos.
	    //    Como los números decimales (double) pueden tener pequeñas diferencias en memoria,
	    //    convertimos los valores a long antes de compararlos.
	    boolean mismoRadio = Double.doubleToLongBits(radio) == Double.doubleToLongBits(other.radio);

	    // 7️⃣ Retornamos true si ambos círculos tienen el mismo centro y el mismo radio.
	    return mismoCentro && mismoRadio;
	}
}