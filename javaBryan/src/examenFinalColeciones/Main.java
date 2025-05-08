package examenFinalColeciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Categoria> categorias = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n1. Añadir categoría");
            System.out.println("2. Añadir producto a categoría");
            System.out.println("3. Mostrar productos de una categoría");
            System.out.println("4. Eliminar producto de una categoría");
            System.out.println("5. Mostrar todas las categorías y productos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    añadirCategoria();
                    break;
                case 2:
                    añadirProductoACategoria();
                    break;
                case 3:
                    mostrarProductosDeCategoria();
                    break;
                case 4:
                    eliminarProductoDeCategoria();
                    break;
                case 5:
                    mostrarTodasLasCategorias();
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void añadirCategoria() {
        System.out.print("Nombre de la nueva categoría: ");
        String nombre = scanner.nextLine();
        categorias.add(new Categoria(nombre));
        System.out.println("Categoría añadida.");
    }

    private static void añadirProductoACategoria() {
        System.out.print("Nombre de la categoría: ");
        String nombreCategoria = scanner.nextLine();
        Categoria categoria = buscarCategoria(nombreCategoria);
        if (categoria != null) {
            System.out.print("Nombre del producto: ");
            String nombreProducto = scanner.nextLine();
            System.out.print("Precio del producto: ");
            double precio = Double.parseDouble(scanner.nextLine());
            categoria.añadirProducto(new Producto(nombreProducto, precio));
            System.out.println("Producto añadido.");
        } else {
            System.out.println("Categoría no encontrada.");
        }
    }

    private static void mostrarProductosDeCategoria() {
        System.out.print("Nombre de la categoría: ");
        String nombreCategoria = scanner.nextLine();
        Categoria categoria = buscarCategoria(nombreCategoria);
        if (categoria != null) {
            System.out.println("Productos en la categoría " + categoria.getNombre() + ":");
            for (Producto producto : categoria.getProductos()) {
                System.out.println(producto);
            }
        } else {
            System.out.println("Categoría no encontrada.");
        }
    }

    private static void eliminarProductoDeCategoria() {
        System.out.print("Nombre de la categoría: ");
        String nombreCategoria = scanner.nextLine();
        Categoria categoria = buscarCategoria(nombreCategoria);
        if (categoria != null) {
            System.out.print("Nombre del producto a eliminar: ");
            String nombreProducto = scanner.nextLine();
            categoria.eliminarProducto(nombreProducto);
            System.out.println("Producto eliminado si existía.");
        } else {
            System.out.println("Categoría no encontrada.");
        }
    }

    private static void mostrarTodasLasCategorias() {
        for (Categoria categoria : categorias) {
            System.out.println(categoria);
        }
    }

    private static Categoria buscarCategoria(String nombre) {
        for (Categoria categoria : categorias) {
            if (categoria.getNombre().equalsIgnoreCase(nombre)) {
                return categoria;
            }
        }
        return null;
    }
}
