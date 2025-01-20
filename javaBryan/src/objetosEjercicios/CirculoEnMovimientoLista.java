package objetosEjercicios;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import utilidades.StdDraw;

public class CirculoEnMovimientoLista {

    public static void main(String[] args) {
        // Establecer sistema de coordenadas
        StdDraw.setXscale(-100, 100);
        StdDraw.setYscale(-100, 100);
        StdDraw.enableDoubleBuffering();

        Random r = new Random();

        int numeroCirculosIniciales = 5; // Número inicial de círculos
        double radioCirculo = 2.0;       // Radio de los círculos
        List<Circulo> circulos = new ArrayList<>();

        // Crear círculos iniciales
        for (int i = 0; i < numeroCirculosIniciales; i++) {
            Circulo c = crearCirculoAleatorio(r.nextDouble(-100, 100), r.nextDouble(-100, 100), radioCirculo);
            circulos.add(c);
        }

        while (true) {
            StdDraw.clear();

            // Mostrar información en pantalla
            StdDraw.setPenColor(Color.BLUE);
            StdDraw.text(0, 95, "Círculos: " + circulos.size());
            StdDraw.text(0, 85, "Pulse el ratón para crear círculos");

            // Dibujar y mover círculos
            for (Circulo c : circulos) {
                controlarRebote(c);
                c.getCentro().mover();
                c.dibujar(true); // Dibujar círculo relleno
            }

            // Crear círculos al pulsar el ratón
            if (StdDraw.isMousePressed()) {
                Circulo c = crearCirculoAleatorio(StdDraw.mouseX(), StdDraw.mouseY(), radioCirculo);
                circulos.add(c);
            }

            // Detectar colisiones y generar nuevos círculos
            List<Circulo> nuevos = new ArrayList<>();
            for (int i = 0; i < circulos.size() - 1; i++) {
                for (int j = i + 1; j < circulos.size(); j++) {
                    if (distancia(circulos.get(i), circulos.get(j)) < 2 * radioCirculo) {
                        Punto medio = puntoMedio(circulos.get(i).getCentro(), circulos.get(j).getCentro());
                        nuevos.add(new Circulo(medio, radioCirculo));
                    }
                }
            }
            circulos.addAll(nuevos);

            StdDraw.show();
            StdDraw.pause(50);
        }
    }

    private static Circulo crearCirculoAleatorio(double x, double y, double radio) {
        Random r = new Random();
        Punto p = new Punto(x, y);
        p.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
        p.setMovX(r.nextDouble(-6, 6));
        p.setMovY(r.nextDouble(-6, 6));
        return new Circulo(p, radio);
    }

    private static void controlarRebote(Circulo circ) {
        Punto centro = circ.getCentro();
        if (Math.abs(centro.getX()) >= 100 - circ.getRadio()) {
            centro.setMovX(-centro.getMovX());
        }
        if (Math.abs(centro.getY()) >= 100 - circ.getRadio()) {
            centro.setMovY(-centro.getMovY());
        }
    }

    private static double distancia(Circulo c1, Circulo c2) {
        return c1.getCentro().distancia(c2.getCentro());
    }

    private static Punto puntoMedio(Punto p1, Punto p2) {
        double medioX = (p1.getX() + p2.getX()) / 2;
        double medioY = (p1.getY() + p2.getY()) / 2;
        return new Punto(medioX, medioY);
    }
}

