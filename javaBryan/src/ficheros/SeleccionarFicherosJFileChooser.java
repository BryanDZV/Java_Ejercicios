package ficheros;

import java.io.File;

import javax.swing.JFileChooser;

public class SeleccionarFicherosJFileChooser {
	/* LAS MAYUSCULAS SUELEN SER CONSTANTES Y DEVEUVLEN UN NUMERO */

	public static void main(String[] args) {
		JFileChooser fc = new JFileChooser(".");// ruta ubicacion inicial de ventanita
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);// aqui selecciono que tipo quiero coger MODO SELECCION
		fc.setDialogTitle("Seleccione fichero origen");// PAARIENCIA DELA VENTNITA
		int opcion = fc.showOpenDialog(null);// abre un dialogo ventanita Y SE ESEPRA Q ELIGA ALGO
		if (opcion == JFileChooser.APPROVE_OPTION) {// QUE SUCEDE CON LA VENTANITA EN FUNCOIND E LA REPSUES DEL USSUARIO
			File ruta = fc.getSelectedFile();// AQUI ASIGNAMOS A LA RUTA LA SELECION DEL USUARIO EN LA VENTANIA
			System.out.println(ruta.getAbsolutePath());
		} else
			System.out.println("No se ha seleccionado ningún fichero.");
	}

}