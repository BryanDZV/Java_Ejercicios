package ejercicios1;

import java.util.Scanner;

public class Extra6_TryCatchNumero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Introduce un número: ");
            int num = Integer.parseInt(sc.nextLine());
            System.out.println("Doble: " + (num * 2));
        } catch (NumberFormatException e) {
            System.out.println("Eso no era un número válido.");
        }
    }
}