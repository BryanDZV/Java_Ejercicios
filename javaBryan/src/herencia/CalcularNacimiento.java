package herencia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import utilidades.Entrada;

public class CalcularNacimiento {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");//la plantilla del formato
		sdf.setLenient(false); // Control de rangos numéricos en fechas porque si evita fechas tipo 32/01/2025 es permisivo osea poiner false.
		String fecha=null;
		Date fechaD=null;
		boolean fechaIncorrecta;
		int edad=0;
		do {
			try {
				System.out.print("Fecha (DD/MM/AAAA): ");
				fecha = Entrada.cadena();
				fechaIncorrecta = false;
				fechaD = sdf.parse(fecha);
				edad=CalcularEdad(fechaD);
			} catch (ParseException e) {
				System.out.println("Fecha incorrecta");
				fechaIncorrecta = true;
			}
		} while (fechaIncorrecta);
		//System.out.println(sdf2.format(fechaD));
		//System.out.println(fechaD);
	}

	private static int CalcularEdad(Date fechaD) {

        // Calcular edad restando milisegundos
        Date fechaActual = new Date();
        //System.out.println(fechaActual);
        long diferenciaMilis = fechaActual.getTime() - fechaD.getTime();

        // 1000 milisegundos * 60 seg * 60 min * 24 h * 365.25 días 
        long milisPorAnio = (long)(1000L * 60 * 60 * 24 * 365.25);
        int edad = (int)(diferenciaMilis / milisPorAnio);

        System.out.println("Edad: " + edad + " años");
		
		
		return edad;
	}


}
