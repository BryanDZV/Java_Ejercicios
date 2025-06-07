package examenFinalColeciones;

public class Fruta {
    private String nombre;
    private double precioKg;

    public Fruta(String nombre, double precioKg) {
        this.nombre = nombre;
        this.precioKg = precioKg;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioKg() {
        return precioKg;
    }

    @Override
    public String toString() {
        return nombre + " - " + precioKg + " €/kg";
    }
}
