package herencia;

public class EstudianteDAW1 extends Estudiante {

	public EstudianteDAW1(String nombre, int edad, String curso) {
		super(nombre, edad, curso);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void presentarse() {
		super.presentarse();
		System.out.println("Soy un BRO de DAW1 y me llamo " + getNombre());
	}

}
