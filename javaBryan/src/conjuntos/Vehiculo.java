package conjuntos;

import java.util.*;

public class Vehiculo implements Comparable<Vehiculo> {
    private String fabricante;
    private String modelo;
    private TipoVehiculo tipo;
    private int cilindrada;
    private String color;

    public Vehiculo(String fabricante, String modelo, TipoVehiculo tipo, int cilindrada, String color) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.tipo = tipo;
        this.cilindrada = cilindrada;
        this.color = color;
    }

    // Getters y Setters
    public String getFabricante() { return fabricante; }
    public String getModelo() { return modelo; }
    public TipoVehiculo getTipo() { return tipo; }
    public int getCilindrada() { return cilindrada; }
    public String getColor() { return color; }

    public void setFabricante(String fabricante) { this.fabricante = fabricante; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setTipo(TipoVehiculo tipo) { this.tipo = tipo; }
    public void setCilindrada(int cilindrada) { this.cilindrada = cilindrada; }
    public void setColor(String color) { this.color = color; }

    // Método toString
    @Override
    public String toString() {
        return fabricante + " " + modelo + " (" + tipo + ", " + cilindrada + "cc, " + color + ")";
    }

    // Métodos equals y hashCode
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) obj;
        return Objects.equals(fabricante, vehiculo.fabricante) &&
               Objects.equals(modelo, vehiculo.modelo) &&
               tipo == vehiculo.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fabricante, modelo, tipo);
    }

    // Implementación de compareTo para TreeSet
    @Override
    public int compareTo(Vehiculo otro) {
        return Integer.compare(this.cilindrada, otro.cilindrada);
    }

    public static void main(String[] args) {
        List<Vehiculo> lista = new ArrayList<>();
        Vehiculo v1 = new Vehiculo("Seat", "Ibiza", TipoVehiculo.COCHE, 1200, "Rojo");
        Vehiculo v2 = new Vehiculo("Seat", "Ibiza", TipoVehiculo.COCHE, 1400, "Azul");
        Vehiculo v3 = new Vehiculo("Seat", "Ibiza", TipoVehiculo.COCHE, 1600, "Verde");
        Vehiculo v4 = new Vehiculo("Renault", "Clio", TipoVehiculo.COCHE, 1100, "Blanco");
        Vehiculo v5 = new Vehiculo("Honda", "CBR", TipoVehiculo.MOTO, 600, "Negro");
        
        lista.add(v1);
        lista.add(v2);
        lista.add(v3);
        lista.add(v4);
        lista.add(v5);
        
        System.out.println("Lista de vehículos: " + lista);
        System.out.println("Número de elementos en la lista: " + lista.size());

        Set<Vehiculo> hashSet = new HashSet<>(lista);
        System.out.println("\nHashSet de vehículos: " + hashSet);
        System.out.println("Número de elementos en el HashSet: " + hashSet.size());
        
        Set<Vehiculo> treeSet = new TreeSet<>(lista);
        System.out.println("\nTreeSet de vehículos: " + treeSet);
        System.out.println("Número de elementos en el TreeSet: " + treeSet.size());
    }
}


