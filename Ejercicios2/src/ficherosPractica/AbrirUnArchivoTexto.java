package ficherosPractica;

import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

public class AbrirUnArchivoTexto {

	public static void main(String[] args) {
	JFileChooser jfc=new JFileChooser(".");//Puedes poner cualquier ruta válida (como una ruta absoluta o relativa) solo es la donde se abrria la ventana inicialmente
	jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);//abro selector y configuro
	int seleccion=jfc.showOpenDialog(null);//showSaveDialog(null); para guardar archivos
	if (seleccion==JFileChooser.APPROVE_OPTION) {
		File ruta=jfc.getSelectedFile();
		System.out.println(ruta.getAbsolutePath());
	}else {
		System.out.println("se cancelo la selecion");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
