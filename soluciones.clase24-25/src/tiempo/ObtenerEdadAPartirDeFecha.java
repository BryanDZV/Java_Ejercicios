package tiempo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import utilidades.Entrada;
import utilidades.StdDraw;

public class ObtenerEdadAPartirDeFecha {

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
		
		int anios=calcularEdad(fechaD);
		System.out.println("Años: "+anios);
	}
	
	public static int calcularEdad(Date nac) {
		SimpleDateFormat fA=new SimpleDateFormat("yyyy");
		SimpleDateFormat fM=new SimpleDateFormat("MM");
		SimpleDateFormat fD=new SimpleDateFormat("dd");
		//Obtenemos año, mes y día de nacimiento
		int aNac=Integer.valueOf(fA.format(nac));
		int mNac=Integer.valueOf(fM.format(nac));
		int dNac=Integer.valueOf(fD.format(nac));
		//Obtenemos año, mes y día actual
		Date ahora=new Date();
		int aAct=Integer.valueOf(fA.format(ahora));
		int mAct=Integer.valueOf(fM.format(ahora));
		int dAct=Integer.valueOf(fD.format(ahora));
		
		int edad=aAct-aNac;
		if (mNac>mAct || (mNac==mAct && dNac>dAct)) //Si el dia de nacimiento es posterior al dia actual restamos 1 a lo calculado anteriormente
			edad--;
		if (edad < 0) //La fecha nac es futura
			throw new IllegalArgumentException("No se puede obtener edad para una fecha futura");
		return edad;
	}

}
