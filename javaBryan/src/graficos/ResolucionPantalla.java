package graficos;

import java.awt.Dimension;
import java.awt.Toolkit;

import utilidades.StdDraw;

public class ResolucionPantalla {

	public static void main(String[] args) {
		//Obtenemos resolución de nuestra pantalla (en píxeles)
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double anchoPantalla = screenSize.getWidth();
		double altoPantalla = screenSize.getHeight();
		
		System.out.println("Píxeles ancho: "+anchoPantalla);
		System.out.println("Píxeles alto: "+altoPantalla);
		
		//Tamaño de la ventana de StdDraw (píxeles)
		int anchoVentana=(int)(anchoPantalla);
		int altoVentana=(int)(altoPantalla/2);
		StdDraw.setCanvasSize(anchoVentana,altoVentana);

	}

} 