package ejercicios2;

import java.text.SimpleDateFormat;
import java.util.*;

public class Ejercicio4_MapFechas {
    public static void main(String[] args) throws Exception {
        Map<String, Date> mapa = new TreeMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        mapa.put("Laura", sdf.parse("12/03/2024"));
        mapa.put("Carlos", sdf.parse("01/02/2024"));
        mapa.put("Ana", sdf.parse("20/01/2024"));

        for (Map.Entry<String, Date> entry : mapa.entrySet()) {
            System.out.println(entry.getKey() + " → " + sdf.format(entry.getValue()));
        }
    }
}