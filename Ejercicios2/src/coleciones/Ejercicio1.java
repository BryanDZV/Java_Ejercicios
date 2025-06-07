package coleciones;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio1 {

	public static void main(String[] args) {

		List<String> l = new ArrayList<String>();
		l.add("bryan");
		l.add("david");
		l.add("lucas");

		for (String elemento : l) {
			System.out.println(elemento);
		}
	}

}
