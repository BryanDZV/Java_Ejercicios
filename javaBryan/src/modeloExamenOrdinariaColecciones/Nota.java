package modeloExamenOrdinariaColecciones;

public class Nota implements Comparable<Nota> {
	private int idAlumno;
	private String asignatura;
	private double valor;

	// constructor, getters y setters
	@Override
	public String toString() {
		return "Nota [idAlumno=" + idAlumno + ", asignatura=" + asignatura + ", valor=" + valor + "]";
	}

	public Nota(int idAlumno, String asignatura, double valor) {
		super();
		this.idAlumno = idAlumno;
		this.asignatura = asignatura;
		this.valor = valor;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public int compareTo(Nota o) {
		int orden = this.asignatura.compareTo(o.asignatura);
		return orden;
	}

}
