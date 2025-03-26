package ficheros;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ejercicios33 {
    public static void main(String[] args) throws IOException {
        File rutaArchivo =new File("C:\\Users\\bryan\\Downloads\\numeros1-1000.csv");//ruta de destino si solo hay nombre lo crea en el directorio de trabaj la carpeta principal al nivel de SRC        
        PrintWriter pw=new PrintWriter(new FileWriter(rutaArchivo));
       
            for (int i = 1; i <= 1000; i++) {
            	pw.print(i+";");
            	
            	if (i%10==0) {//cosas ciclicas %
            		pw.println();
					
				}
            }//for
            pw.close(); // IMPORTANTE: cerrar el PrintWriter para que escriba todo en el archivo
            System.out.println("Archivo generado correctamente.");
    }//main
}//clase
