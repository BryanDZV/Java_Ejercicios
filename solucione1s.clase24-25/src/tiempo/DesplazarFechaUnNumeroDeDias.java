package tiempo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import utilidades.Entrada;

public class DesplazarFechaUnNumeroDeDias {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
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
		int dias=Entrada.entero("Número de días a saltar (+ futuro/- pasado): ","Días incorrectos!!");
		long ms=dias*24L*3600L*1000L;//Utilizamos L para marcar operadores long (mayor rango numérico);
		Date nuevaFecha=new Date(fechaD.getTime()+ms);
		System.out.println("Al desplazar "+fecha+" "+dias+" días nos trasladamos a: "+sdf.format(nuevaFecha));

	}

}
