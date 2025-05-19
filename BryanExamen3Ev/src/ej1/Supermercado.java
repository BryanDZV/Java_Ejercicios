package ej1;

import java.util.*;

// Clase que gestiona los productos de un supermercado
public class Supermercado {
    // Mapas que ligan marca → lista de productos, y categoría → lista de productos
    private Map<String, List<Producto>> productosPorMarca;
    private Map<String, List<Producto>> productosPorCategoria;

    // Constructor: inicializamos ambos mapas vacíos
    public Supermercado() {
        productosPorMarca = new HashMap<String, List<Producto>>();
        productosPorCategoria = new HashMap<String, List<Producto>>();
    }

    // Método para agregar un producto a las colecciones
    public void agregarProducto(Producto producto) {
        // 1) Marca
        String marca = producto.getMarca();
        // Buscamos la lista de esa marca (o creamos una nueva si no existe)
        if (!productosPorMarca.containsKey(marca)) {
            productosPorMarca.put(marca, new ArrayList<Producto>());
        }
        // Añadimos el producto a la lista de su marca
        productosPorMarca.get(marca).add(producto);

        // 2) Categoría
        String categoria = producto.getCategoria();
        // Buscamos la lista de esa categoría (o creamos una nueva si no existe)
        if (!productosPorCategoria.containsKey(categoria)) {
            productosPorCategoria.put(categoria, new ArrayList<Producto>());
        }
        // Añadimos el producto a la lista de su categoría
        productosPorCategoria.get(categoria).add(producto);
    }

    // Devuelve los productos de una marca, ordenados por nombre alfabéticamente
    public List<Producto> obtenerProductosPorMarca(String marca) {
        // Obtenemos lista (o lista vacía si la marca no existe)
        List<Producto> lista = productosPorMarca.get(marca);
        if (lista == null) {
            return new ArrayList<Producto>(); // devolvemos lista vacía
        }
        // Hacemos una copia para no alterar la original
        List<Producto> copia = new ArrayList<Producto>(lista);
        // Ordenamos por nombre usando Collections.sort y un Comparator básico
        copia.sort(null);
        
        return copia;
    }

    // Devuelve los productos de una categoría, ordenados por precio ascendente
    public List<Producto> obtenerProductosPorCategoria(String categoria) {
        List<Producto> lista = productosPorCategoria.get(categoria);
        if (lista == null) {
            return new ArrayList<Producto>();
        }
        List<Producto> copia = new ArrayList<Producto>(lista);
        // Ordenamos por precio
        copia.sort(new PorPrecioComparator());
                return copia;

    }

    // Devuelve todas las marcas disponibles, ordenadas alfabéticamente
    public List<String> obtenerTodasLasMarcas() {
        // Tomamos el set de llaves y lo pasamos a lista
        List<String> marcas = new ArrayList<String>(productosPorMarca.keySet());
        // Ordenamos la lista
        Collections.sort(marcas, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.compareToIgnoreCase(s2);
            }
        });
        return marcas;
    }

    // Devuelve un mapa con la categoría → producto más barato de esa categoría
    public Map<String, Producto> obtenerProductoMasBaratoPorCategoria() {
        // Creamos el mapa resultado
        Map<String, Producto> resultado = new HashMap<String, Producto>();
        // Recorremos cada categoría y su lista
        for (String cat : productosPorCategoria.keySet()) {
            List<Producto> lista = productosPorCategoria.get(cat);
            // Si la lista es nula o vacía, no hay producto
            if (lista == null || lista.isEmpty()) {
                return new HashMap<String, Producto>();
            }

            // Suponemos el primero como más barato
            Producto masBarato = lista.get(0);
            // Recorremos la lista para encontrar si hay uno más barato
            for (Producto p : lista) {
                if (p.getPrecio() < masBarato.getPrecio()) {
                    masBarato = p;
                }
            }
            // Guardamos en el mapa
            resultado.put(cat, masBarato);
        }
        return resultado;
    }
}
