package examenFinalColeciones;

import java.util.ArrayList;
import java.util.List;

public class TipoFruta {
    private String nombreTipo;
    private List<Fruta> listaFrutas;

    public TipoFruta(String nombreTipo) {
        this.nombreTipo = nombreTipo;
        this.listaFrutas = new ArrayList<>();
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public List<Fruta> getListaFrutas() {
        return listaFrutas;
    }

    public void añadirFruta(Fruta f) {
        listaFrutas.add(f);
    }

    public void eliminarFrutaPorNombre(String nombre) {
        listaFrutas.removeIf(f -> f.getNombre().equalsIgnoreCase(nombre));
    }

    @Override
    public String toString() {
        return "Tipo: " + nombreTipo + " (" + listaFrutas.size() + " frutas)";
    }
}
