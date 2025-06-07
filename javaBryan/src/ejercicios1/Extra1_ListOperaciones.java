package ejercicios1;

import java.util.*;

public class Extra1_ListOperaciones {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>(Arrays.asList("uno", "dos", "tres", "cuatro"));
        lista.add("cinco");
        lista.remove("tres");
        Collections.sort(lista);
        for (String s : lista) {
            System.out.println(s);
        }
    }
}