package llamarFunciones;

import java.util.Random;

import funciones.Funciones;
import utilidades.Entrada;

public class llamarFunciones {

    public static void main(String[] args) {
        
        // Llamada a función área del triángulo
        System.out.println("Calcula el área de un triángulo:");
        System.out.print("Introduce base: ");
        double base = Entrada.real();
        System.out.print("Introduce altura: ");
        double altura = Entrada.real();
        System.out.println("Área del triángulo: " + Funciones.areaTriangulo(base, altura));

        // Bucle para calcular áreas de triángulos con bucle
        System.out.println("----------EMPIEZA BUCLE DE ÁREAS-----------");
        for (int n = 1; n <= 10; n++) {
            System.out.println("Área para base y altura " + n + ": " + Funciones.areaTriangulo(n, n));
        }

        // Llamada a función mayúsculas
        String texto = "hola";
        String mayusculas = Funciones.mayusculas(texto);
        System.out.println("En mayúsculas: " + mayusculas);

        // Llamada a función volumen del círculo
        System.out.print("Introduce el radio del círculo: ");
        double radio = Entrada.real();
        double volumen = Funciones.volumenCirculo(radio);
        System.out.println("Volumen del círculo: " + volumen);

        // Llamada a función multiplicarArrays
        double[] a = {2.3, 3.3, 0, 8};
        double[] b = {2, 2.0, 2, 2};
        double[] resultado = Funciones.multiplicarArrays(a, b);

        // Métodos de impresión del array de resultados
        System.out.println("SOLUCIÓN 1: " + java.util.Arrays.toString(resultado));
        
        // Método 3: Impresión con función auxiliar mostrarArray
        System.out.println("SOLUCIÓN 3 (con mostrarArray):");
        Funciones.mostrarArray(resultado);

        // Llamada a función ecuación de segundo grado
        System.out.println("---- Ecuación de segundo grado: ax^2 + bx + c = 0 ------");
        System.out.print("Coeficiente a: ");
        double d = Entrada.real();
        System.out.print("Coeficiente b: ");
        double e = Entrada.real();
        System.out.print("Coeficiente c: ");
        double f = Entrada.real();

        double[] soluciones = Funciones.ecuacionSegundoGrado(d, e, f);
        switch (soluciones.length) {
            case 0:
                System.out.println("La ecuación no tiene solución.");
                break;
            case 1:
                System.out.println("La ecuación tiene una solución: " + soluciones[0]);
                break;
            case 2:
                System.out.println("La ecuación tiene dos soluciones: " + soluciones[0] + " y " + soluciones[1]);
                break;
        }

        // Llamada a función esBisiesto
        for (int year = 1900; year <= 2000; year++) {
            System.out.print(year + " - ");
            if (Funciones.esBisiesto(year))
                System.out.println("Bisiesto");
            else
                System.out.println("No bisiesto");
        }

        // Llamada a función esPrimo para lista de primos
        System.out.print("¿Cuántos números primos quieres? ");
        int cantidadPrimos = Entrada.entero();
        int contadorPrimos = 0;
        int numero = 2;

        while (contadorPrimos < cantidadPrimos) {
            if (Funciones.esPrimo(numero)) {
                System.out.print(numero + " ");
                contadorPrimos++;
                if (contadorPrimos % 10 == 0) System.out.println();
            }
            numero++;
        }

        // Llamada a función esPrimo en un intervalo
        System.out.println("\n== Números primos en un intervalo ==");
        int min, max;
        do {
            System.out.print("Mínimo: ");
            min = Entrada.entero();
        } while (min <= 1);

        do {
            System.out.print("Máximo: ");
            max = Entrada.entero();
        } while (max <= min);

        for (int i = min; i <= max; i++) {
            if (Funciones.esPrimo(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        // Llamada para obtener palabras de un array aleatoriamente
        String[] palabras = {"hola", "adios", "buenas tardes", "buenas noches"};
        Random random = new Random();

        System.out.println("Palabra aleatoria del array:");
        int indice = random.nextInt(palabras.length);
        System.out.println(palabras[indice]);

        System.out.println("Cinco palabras aleatorias:");
        for (int i = 0; i < 5; i++) {
            indice = random.nextInt(palabras.length);
            System.out.println(palabras[indice]);
        }

        // Llamar función de días en un mes
        System.out.println("Días en cada mes del año 2024:");
        for (int mes = 1; mes <= 12; mes++) {
            System.out.println("Mes " + mes + ": " + Funciones.diasMes(mes, 2024) + " días");
        }

        // Simulación de tirar dado
        System.out.println("Tirar dado 20 veces:");
        for (int i = 0; i < 20; i++) {
            int resultadoDado = Funciones.tirarDado();
            System.out.println("Resultado: " + resultadoDado);
        }

        // Simulación de tirar moneda
        int resultadoMoneda = Funciones.tirarMoneda();
        System.out.println("Resultado de tirar moneda: " + (resultadoMoneda == 0 ? "Cara" : "Cruz"));

        // Llamada a función obtener nombre del mes
        System.out.println("Nombres de los meses en varios idiomas:");
        for (int mes = 1; mes <= 12; mes++) {
            System.out.println("Mes " + mes + ": " 
                + Funciones.nombreMes(mes, "es") + ", "
                + Funciones.nombreMes(mes, "fr") + ", "
                + Funciones.nombreMes(mes, "ing"));
        }

        // Llamada a función para sustituir un carácter (Ejemplo)
        String frase = "Ejemplo de sustitución de caracteres";
        System.out.println("Frase original: " + frase);
        System.out.println("Frase con sustitución: " + Funciones.sustituirCaracter(frase, 'e', 'E'));
    }
}

    
    
    
    
    
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    
    
    

