package ejercicios3;

import java.text.*;
import java.util.*;

public class Extra5_DateComparacion {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha1 = sdf.parse("01/01/2024");
        Date fecha2 = sdf.parse("15/03/2024");

        if (fecha1.before(fecha2)) {
            System.out.println("Fecha1 es anterior a Fecha2");
        }
    }
}