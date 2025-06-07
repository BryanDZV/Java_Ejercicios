package examenFinal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import utilidades.Entrada;

public class DiasVivido {

	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf1=new SimpleDateFormat("EEEE/dd/MM/yyyy");
		
		Date fecha=null;
		sdf.setLenient(false);
		System.out.println("pon fcha de nacimiento: dd/MM/yyyy");
		String textoFecha=Entrada.cadena();
		//parsear
		try {
			fecha=sdf.parse(textoFecha);
			System.out.println("formato correcto");
			//calcular edad años
			int años=calcularEdad(fecha);
			System.out.println(años+"años");
			//calculo dias
			long dias=calcularDias(fecha);
			System.out.println(dias+"dias");
			
			
		} catch (ParseException e) {
			System.out.println("formato incorrecto");
			e.printStackTrace();
		}
		
		
		
		

	}

	private static long calcularDias(Date fecha) {
		Date hoy=new Date();
		long milisHoy=hoy.getTime();
		long milisNac=fecha.getTime();
		long milisVivido=milisHoy-milisNac;
		//claclar dias
		long dias=(milisVivido)/(24L*60*60*1000L);
		return dias;
	}

	private static int calcularEdad(Date fecha) {
		//para calcular
				SimpleDateFormat sdfdd=new SimpleDateFormat("dd");//formato a usar
				SimpleDateFormat sdfMM=new SimpleDateFormat("MM");
				SimpleDateFormat sdfyyyy=new SimpleDateFormat("yyyy");
		//a int fecha nancicmiento
				int ddNac=Integer.parseInt(sdfdd.format(fecha));
				int mmNac=Integer.parseInt(sdfMM.format(fecha));
				int yyyyNac=Integer.parseInt(sdfyyyy.format(fecha));
		//a int la fehca de hoy
				Date hoy=new Date();//fecha actual
				int ddHoy=Integer.parseInt(sdfdd.format(hoy));
				int mmHoy=Integer.parseInt(sdfMM.format(hoy));
				int yyyyHoy=Integer.parseInt(sdfyyyy.format(hoy));
		//calulo años nac-hoy
				int edad=yyyyHoy-yyyyNac;
				if (mmNac>mmHoy||(mmNac==mmHoy&&(ddNac>ddHoy))) {
					edad--;
				}
				if (edad < 0) throw new IllegalArgumentException("Fecha futura");
			    return edad;
	}



}
