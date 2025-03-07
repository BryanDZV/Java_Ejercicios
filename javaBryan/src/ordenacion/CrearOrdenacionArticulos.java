package ordenacion;
import java.util.ArrayList;
import java.util.List;

public class CrearOrdenacionArticulos {

    public static void main(String[] args) {
        List<Articulo> tienda = new ArrayList<>();

        tienda.add(new Articulo("PT", 5, "Patatas", 1500, Categoria.ALIMENTACION));
        tienda.add(new Articulo("CH", 7, "Chirimoyas", 800, Categoria.ALIMENTACION));
        tienda.add(new Articulo("AM", 25, "Alma", 21, Categoria.OTROS));
        tienda.add(new Articulo("BO", 7.5, "Boniato", 1000, Categoria.ALIMENTACION));
        tienda.add(new Articulo("TEC1", 8, "Ratón óptico", 130, Categoria.TECNOLOGIA));
        tienda.add(new Articulo("TEC2", 4, "Alfombrilla", 195, Categoria.TECNOLOGIA));
        tienda.add(new Articulo("TX1", 40, "Pantalón vaquero", 900, Categoria.TEXTIL));
        tienda.add(new Articulo("AG", 300, "Angulas", 500, Categoria.ALIMENTACION));
        tienda.add(new Articulo("OTR1", 5, "Karkamusa", 1500, Categoria.OTROS));
        tienda.add(new Articulo("TX5", 27, "Camisa", 300, Categoria.TEXTIL));

        // **Ordenación por nombre (Comparable)**
        tienda.sort(null);
        System.out.println("\n------ Ordenación por nombre (Comparable) ------");
        for (Articulo a : tienda) {
            System.out.println(a);
        }

        // **Ordenación por precio (Comparator)**
        tienda.sort(new OrdenacionPorPrecio());
        System.out.println("\n------ Ordenación por precio ------");
        for (Articulo a : tienda) {
            System.out.println(a);
        }

        // **Ordenación por peso descendente (Comparator)**
        tienda.sort(new OrdenacionPorPesoDesc());
        System.out.println("\n------ Ordenación por peso descendente ------");
        for (Articulo a : tienda) {
            System.out.println(a);
        }
        
        tienda.sort(new OrdenacionPorDenominacionYPrecioDesc());
        System.out.println("\n------ Ordenación por denominación y precio descendente ------");
        for (Articulo a : tienda) {
            System.out.println(a);
        }

    }
}
