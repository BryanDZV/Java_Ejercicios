package examenFinalColeciones;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private String nombre;
    private List<Producto> productos;

    public Categoria(String nombre) {
        this.nombre = nombre;
        this.productos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void añadirProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(String nombreProducto) {
        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            if (p.getNombre().equalsIgnoreCase(nombreProducto)) {
                productos.remove(i);
                break; // muy importante para evitar errores ConcurrentModification
            }
        }
    }


    @Override
    public String toString() {
        return nombre + ": " + productos.toString();
    }
}
