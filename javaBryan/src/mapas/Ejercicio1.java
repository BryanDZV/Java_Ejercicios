package mapas;

import java.util.HashMap;
import java.util.Map;

import utilidades.Entrada;

public class Ejercicio1 {

	public static void main(String[] args) {
		/**
		 * Ejercicio 1 Implementa el control de acceso al área restringida de un
		 * programa. Se debe pedir un identificador de el usuario y una contraseña. Si
		 * el usuario introduce los datos correctamente, el programa dirá“Ha accedido al
		 * área restringida”. El usuario tendrá un máximo de 3 oportunidades. Si se
		 * agotan las oportunidades el programa dirá“Lo siento, no tiene acceso al área
		 * restringida”. Los identificadores de usuario con sus correspondientes
		 * contraseñas deben estar almacenados en una estructura de clase HashMap. Se
		 * creará el mapa con datos de prueba antes de comenzar a solicitar
		 * identificador de usuario y contraseña. El identificador de usuario es un
		 * número entero positivo y la contraseña es cualquier String.
		 */

		System.out.println("intrdouzca su usuario y contraseña //solo tendra 3 intentos antes de bloquear su area//");

		String user = Entrada.cadena();
		int psw = Entrada.entero();

		comprobador(psw, user);

	}

	private static void comprobador(int psw, String user) {
		/**
		 * comprobar los dos parametros
		 * si usuario falla 1 intento meno
		 * si el susaurio es correcto comprobar su clave si falla 1 menos
		 * su clave falla 1 intento menos 
		 * si calve es correcta comprobar su valor si falla 1 menos
		 * si los dos falla 1 intento menos 
		 * si se acaba lso 3 intetos adios
		 * si todo es okay entra
		 * 
		 */
		Map<Integer, String> m = new HashMap<Integer, String>();

		m.put(1111, "224477");
		m.put(1234, "pepe");
		m.put(12345, "p");
		String userL = user.toLowerCase();
		int intentos = 0;
		m.get(psw);
		
		if (m.containsValue(userL)) {
			if (m.get(psw)==) {
				
			}
			
			System.out.println("acceso");

		} else if (m.containsKey(userL) && m.containsKey(userL)) {
			
		}
			System.out.println("erro 1 intento");
			intentos++;

		

	}

}
