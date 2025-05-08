package examenFinalColeciones;

import java.util.*;

public class GestionFrutas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<TipoFruta> listaTipos = new ArrayList<>();

        int opcion;
        do {
            System.out.println("""
                1. Añadir tipo de fruta
                2. Añadir fruta a un tipo
                3. Mostrar frutas de un tipo (ordenadas por precio)
                4. Eliminar fruta de un tipo
                5. Mostrar todas las frutas
                6. Salir
                """);
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre del tipo de fruta: ");
                    String tipo = sc.nextLine();
                    listaTipos.add(new TipoFruta(tipo));
                    System.out.println("Tipo añadido.");
                }

                case 2 -> {
                    mostrarTipos(listaTipos);
                    System.out.print("Selecciona tipo de fruta: ");
                    String tipo = sc.nextLine();

                    TipoFruta t = buscarTipo(listaTipos, tipo);
                    if (t != null) {
                        System.out.print("Nombre de la fruta: ");
                        String nombre = sc.nextLine();
                        System.out.print("Precio por kg: ");
                        double precio = Double.parseDouble(sc.nextLine());
                        t.añadirFruta(new Fruta(nombre, precio));
                        System.out.println("Fruta añadida.");
                    } else {
                        System.out.println("Tipo no encontrado.");
                    }
                }

                case 3 -> {
                    mostrarTipos(listaTipos);
                    System.out.print("Tipo a mostrar: ");
                    String tipo = sc.nextLine();
                    TipoFruta t = buscarTipo(listaTipos, tipo);
                    if (t != null) {
                        t.getListaFrutas()
                         .stream()
                         .sorted(Comparator.comparingDouble(Fruta::getPrecioKg))
                         .forEach(System.out::println);
                    } else {
                        System.out.println("Tipo no encontrado.");
                    }
                }

                case 4 -> {
                    mostrarTipos(listaTipos);
                    System.out.print("Tipo: ");
                    String tipo = sc.nextLine();
                    TipoFruta t = buscarTipo(listaTipos, tipo);
                    if (t != null) {
                        System.out.print("Fruta a eliminar: ");
                        String nombre = sc.nextLine();
                        t.eliminarFrutaPorNombre(nombre);
                        System.out.println("Fruta eliminada (si existía).");
                    } else {
                        System.out.println("Tipo no encontrado.");
                    }
                }

                case 5 -> {
                    for (TipoFruta tipo : listaTipos) {
                        System.out.println(tipo);
                        for (Fruta fruta : tipo.getListaFrutas()) {
                            System.out.println("  - " + fruta);
                        }
                    }
                }

                case 6 -> System.out.println("Hasta luego.");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 6);

        sc.close();
    }

    private static TipoFruta buscarTipo(List<TipoFruta> lista, String nombre) {
        for (TipoFruta tipo : lista) {
            if (tipo.getNombreTipo().equalsIgnoreCase(nombre)) {
                return tipo;
            }
        }
        return null;
    }

    private static void mostrarTipos(List<TipoFruta> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay tipos de frutas registrados.");
        } else {
            System.out.println("Tipos disponibles:");
            for (TipoFruta tipo : lista) {
                System.out.println(" - " + tipo.getNombreTipo());
            }
        }
    }
}
