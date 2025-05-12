import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> puntos = new ArrayList<>();

        // 1. Pedir puntos kilométricos
        while (true) {
            System.out.print("Introduce un punto kilométrico o 'fin': ");
            String entrada = sc.nextLine();

            if (entrada.equalsIgnoreCase("fin")) break;

            try {
                int pk = Integer.parseInt(entrada);

                if (pk <= 0)
                    throw new Exception("El número debe ser mayor que 0");

                if (!puntos.isEmpty() && pk <= puntos.get(puntos.size() - 1))
                    throw new Exception("Los puntos deben ser ascendentes");

                puntos.add(pk);

            } catch (NumberFormatException e) {
                System.out.println("Error: Debes introducir un número válido o 'fin'");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // 2. Crear tramos PK numerados
        ArrayList<Tramo> tramos = new ArrayList<>();
        int contadorPK = 1;

        for (int i = 0; i < puntos.size() - 1; i++) {
            int pk1 = puntos.get(i);
            int pk2 = puntos.get(i + 1);
            tramos.add(new Tramo("PK" + contadorPK++, pk1, pk2));
        }

        // 3. Ordenar por distancia
        tramos.sort(Comparator.comparingInt(Tramo::getDistancia));

        // 4. Mostrar tramos ordenados
        System.out.println("\nTramos ordenados por distancia:");
        for (Tramo t : tramos) {
            System.out.println(t);
        }
    }
}

// Clase Tramo con nombre (PK1, PK2...)
class Tramo {
    private String nombrePK;
    private int pkInicio;
    private int pkFin;
    private int distancia;

    public Tramo(String nombrePK, int pkInicio, int pkFin) {
        this.nombrePK = nombrePK;
        this.pkInicio = pkInicio;
        this.pkFin = pkFin;
        this.distancia = pkFin - pkInicio;
    }

    public int getDistancia() {
        return distancia;
    }

    @Override
    public String toString() {
        return nombrePK + ": de " + pkInicio + " hasta " + pkFin + " -> Distancia: " + distancia + " km";
    }
}
