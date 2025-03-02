package cuatroEnRaya.copy;

import java.awt.Color;
import java.util.Objects;

import utilidades.StdDraw;

/**
 * Clase que representa un punto en un plano 2D.
 */
public class Punto { 
    private double x; // Coordenada X del punto.
    private double y; // Coordenada Y del punto.
    private Color color; // Color del punto.
    private double movX; // Movimiento en X del punto.
    private double movY; // Movimiento en Y del punto.

    /**
     * Constructor que inicializa un punto con coordenadas X e Y, asignándole el color negro por defecto.
     * @param x Coordenada X del punto.
     * @param y Coordenada Y del punto.
     */
    public Punto(double x, double y) { 
        this.x = x;
        this.y = y;
        this.color = Color.BLACK; // Color por defecto: negro.
    }

    /**
     * Constructor que inicializa un punto con coordenadas X, Y y un color específico.
     * @param x Coordenada X.
     * @param y Coordenada Y.
     * @param c Color del punto.
     */
    public Punto(double x, double y, Color c) { 
        this.x = x;
        this.y = y;
        this.color = c; 
    }

    public double getX() { return x; } // Devuelve la coordenada X.

    public void setX(double x) { this.x = x; } // Modifica la coordenada X.

    public double getY() { return y; } // Devuelve la coordenada Y.

    public void setY(double y) { this.y = y; } // Modifica la coordenada Y.

    /**
     * Calcula la distancia entre este punto y otro punto P.
     * @param p Punto con el que se calculará la distancia.
     * @return Distancia euclidiana entre los dos puntos.
     */
    public double distancia(Punto p) {
        return distancia(this.x, this.y, p.x, p.y);
    }

    /**
     * Método estático que calcula la distancia entre dos puntos dadas sus coordenadas.
     * @param x1 Coordenada X del primer punto.
     * @param y1 Coordenada Y del primer punto.
     * @param x2 Coordenada X del segundo punto.
     * @param y2 Coordenada Y del segundo punto.
     * @return Distancia entre los dos puntos.
     */
    public static double distancia(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)); // Fórmula de distancia euclidiana.
    }

    /**
     * Calcula la distancia entre dos objetos de la clase Punto.
     * @param a Primer punto.
     * @param b Segundo punto.
     * @return Distancia entre los dos puntos.
     */
    public static double distancia(Punto a, Punto b) {
        return distancia(a.x, a.y, b.x, b.y);
    }

    /**
     * Dibuja el punto en la pantalla usando la librería StdDraw.
     */
    public void dibujar() { 
        StdDraw.setPenColor(color); // Establece el color del punto.
        StdDraw.setPenRadius(0.02); // Define el tamaño del punto.
        StdDraw.point(x, y); // Dibuja el punto en sus coordenadas X e Y.
    }

    /**
     * Mueve el punto sumando los valores de movX y movY.
     */
    public void mover() { 
        x += movX; // Suma el desplazamiento en X.
        y += movY; // Suma el desplazamiento en Y.
    }

    public Color getColor() { return color; } // Devuelve el color del punto.

    public void setColor(Color color) { this.color = color; } // Modifica el color del punto.

    public double getMovX() { return movX; } // Devuelve el movimiento en X.

    public void setMovX(double movX) { this.movX = movX; } // Modifica el movimiento en X.

    public double getMovY() { return movY; } // Devuelve el movimiento en Y.

    public void setMovY(double movY) { this.movY = movY; } // Modifica el movimiento en Y.

    /**
     * Verifica si este punto está dentro de un círculo dado.
     * @param circ Objeto de tipo Circulo.
     * @return true si el punto está dentro del círculo, false si está fuera.
     */
    public boolean dentroDe(Circulo circ) {
        return this.distancia(circ.getCentro()) < circ.getRadio();
    }

    /**
     * Genera una representación en texto del punto, incluyendo sus atributos.
     * @return Cadena con los valores del punto.
     */
    @Override
    public String toString() {
        return "Punto [x=" + x + ", y=" + y + ", movX=" + movX + ", movY=" + movY + ", color=" + color + "]";
    }

    /**
     * Genera un código hash basado en las coordenadas del punto, útil para estructuras como HashSet y HashMap.
     * @return Código hash único para este punto.
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * Compara si dos objetos Punto son iguales basándose en sus coordenadas X e Y.
     * Sobrescribe el método equals para comparar contenido en lugar de referencias de memoria.
     * @param obj Objeto a comparar.
     * @return true si ambos puntos tienen las mismas coordenadas, false si son diferentes.
     */
    @Override
    public boolean equals(Object obj) {
        // 1️⃣ Si es el mismo objeto en memoria, retorna true.
        if (this == obj) 
            return true;

        // 2️⃣ Si el objeto comparado es null, retorna false.
        if (obj == null) 
            return false;

        // 3️⃣ Si el objeto no es de la misma clase, no pueden ser iguales.
        if (getClass() != obj.getClass()) 
            return false;

        // 4️⃣ Convierte el objeto a un Punto para comparar sus atributos (cast seguro).
        Punto other = (Punto) obj;

        // 5️⃣ Compara si las coordenadas X e Y son iguales, convirtiéndolas a long para evitar errores de precisión con doubles.
        return Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x) &&
               Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);
    }
}

