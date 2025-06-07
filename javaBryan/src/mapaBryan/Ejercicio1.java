package mapaBryan;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

import utilidades.Entrada;

public class Ejercicio1 {
	@Override
	public String toString() {
		return "Ejercicio1 [contraseña=" + contraseña + ", usuario=" + usuario + "]";
	}

	private int contraseña;
	private String usuario;

	public Ejercicio1(int contraseña, String usuario) {
		super();
		this.contraseña = contraseña;
		this.usuario = usuario;
	}

	public int getContraseña() {
		return contraseña;
	}

	public void setContraseña(int contraseña) {
		this.contraseña = contraseña;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/*
	 * Ejercicio 1 Implementa el control de acceso al área restringida de un
	 * programa. Se debe pedir un identificador de de usuario y una contraseña. Si
	 * el usuario introduce los datos correctamente, el programa dirá“Ha accedido al
	 * área restringida”. El usuario tendrá un máximo de 3 oportunidades. Si se
	 * agotan las oportunidades el programa dirá“Lo siento, no tiene acceso al área
	 * restringida”. Los identificadores de usuario con sus correspondientes
	 * contraseñas deben estar almacenados en una estructura de clase HashMap. Se
	 * creará el mapa con datos de prueba antes de comenzar a solicitar
	 * identificador de usuario y contraseña. El identificador de usuario es un
	 * número entero positivo y la contraseña es cualquier String.
	 */
	/**
	 * PASOS CREAR UNA ESTRUCTA HASMAP ALMACENAR 4 DATOS DE PRUEBA CLAVE,VALOR(CLAVE
	 * ES UN NMERO+Y EL VALOR UN STRING SIN RESTRICCION) 3 OPORTUNIDADES CON 0 SE
	 * BLOQUEA EL ACCESO Y DICE LO SIENTO... Y ACCEDE CORRECTAMENTE SE DICE HOLA
	 */

	public static void main(String[] args) {

		Map<Integer, String> map = new HashMap<Integer, String>();

		Ejercicio1 v1 = new Ejercicio1(1215, "v1");
		Ejercicio1 v2 = new Ejercicio1(1520, "v1");
		Ejercicio1 v3 = new Ejercicio1(1508, "v3");
		Ejercicio1 v4 = new Ejercicio1(7891, "v4");

		map.put(v1.contraseña, v1.usuario);
		map.put(v2.contraseña, v2.usuario);
		map.put(v3.contraseña, v3.usuario);
		map.put(v4.contraseña, v4.usuario);

		System.out.println(map);

		// obtener claves del mapa
		System.out.println(map.keySet());
		// obtener el valor de una clave
		System.out.println(map.get(1215));

		// obtener valores del mapa

		for (Integer elemento : map.keySet()) {
			System.out.println(map.get(elemento));

		}

		// contiene un clave-valor
		System.out.println(map.containsKey(1520));

		System.out.println("***********VERIFICACION USUARIOS***********");
		// verificar usuario corresponde a la clave
		/**
		 * DO WHILE Si la variable está fuera del do-while, su valor se mantiene y se
		 * actualiza en cada iteración. Si la variable está dentro del do-while, se
		 * reinicia en cada iteración, porque cada vez que empieza el bucle se vuelve a
		 * declarar y asignar su valor inicial.
		 */

		// datos prueba
		String user = "v1";
		int psw = 15220;
		int oportunidades = 3;
		// dinamico
		String user1;
		String psw1;
		boolean salidaExitosa = true; // no lo necesito solo SI USO BREAK
		do {
			try {
				System.out.println("introduce un usuario");
				user1 = Entrada.cadena();
				System.out.println(user1);
				System.out.println("introduce tu contraseña");
				psw1 = Entrada.cadena();
				int psw1Int = Integer.parseInt(psw1);
				System.out.println(psw1Int);
				if (map.containsKey(psw1Int)) {
					if (map.get(psw1Int).equals(user1)) {
						System.out.println("hola bienvenido a tu area");
						salidaExitosa = false;
					} else {
						System.out.println("usuario mal");

						oportunidades--;
						System.out.println("te quedan " + oportunidades + " intentos");
					}

				} else {
					System.out.println("contraseña mal");
					oportunidades--;
					System.out.println("te quedan " + oportunidades + " intentos");
				}

			} catch (NumberFormatException e) {
				System.out.println("SOLO NUMEROS EN TU CONTRASEÑA " + e.getMessage());
				oportunidades--;
				System.out.println("te quedan " + oportunidades + " intentos");
			}

			if (oportunidades == 0) {
				System.out.println("lo siento su area a sido bloqueada");
			}
		} while (oportunidades > 0 && salidaExitosa);
		System.out.println(oportunidades);

		System.out.println(oportunidades);
	}// main

	@Override
	public int hashCode() {
		return Objects.hash(contraseña, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ejercicio1 other = (Ejercicio1) obj;
		return contraseña == other.contraseña && Objects.equals(usuario, other.usuario);
	}

}// clase
