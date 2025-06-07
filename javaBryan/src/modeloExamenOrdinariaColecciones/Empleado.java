package modeloExamenOrdinariaColecciones;

public class Empleado implements Comparable<Empleado>{
	private int id;
	private String departamento;
	private String nombre;
	private double salario;

	// ctor, getters y setters
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", departamento=" + departamento + ", salario=" + salario
				+ "]";
	}

	public Empleado(int id, String nombre, String departamento, double salario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.departamento = departamento;
		this.salario = salario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public int compareTo(Empleado o) {
		int orden=this.departamento.compareTo(o.departamento);
		return orden;
	}
}
