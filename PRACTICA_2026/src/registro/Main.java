package registro;

import utilidades.Entrada;

public class Main {

    public static void main(String[] args) {

        boolean salir = false;
        Registro registro = null; // 👈 CLAVE

        do {
            try {
                System.out.println("1. Registrarse");
                System.out.println("2. Ver información");
                System.out.println("3. Salir");

                int opcion = Entrada.entero();

                switch (opcion) {
                    case 1:
                        System.out.println("Introduce ID:");
                        String id = Entrada.cadena();

                        System.out.println("Introduce nombre:");
                        String nombre = Entrada.cadena();

                        System.out.println("Introduce edad:");
                        int edad = Entrada.entero();

                        registro = new Registro(id, nombre, edad);
                        System.out.println("Registro creado correctamente");
                        break;

                    case 2:
                        if (registro == null) {
                            System.out.println("No hay ningún registro creado");
                        } else {
                            System.out.println(registro);
                        }
                        break;

                    case 3:
                        salir = true;
                        break;

                    default:
                        System.out.println("Opción no válida");
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (!salir);
    }
}

