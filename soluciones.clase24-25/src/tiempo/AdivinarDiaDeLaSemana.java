package tiempo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import utilidades.Entrada;

public class AdivinarDiaDeLaSemana {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("EEEE");
		sdf.setLenient(false); // Control de rangos numéricos en fechas
		String fecha=null;
		Date fechaD=null;
		boolean fechaIncorrecta;
		do {
			try {
				System.out.print("Fecha (DD/MM/AAAA): ");
				fecha = Entrada.cadena();
				fechaIncorrecta = false;
				fechaD = sdf.parse(fecha);
			} catch (ParseException e) {
				System.out.println("Fecha incorrecta");
				fechaIncorrecta = true;
			}
		} while (fechaIncorrecta);
		System.out.println(sdf2.format(fechaD));
		System.out.println(fechaD);
	}

}
