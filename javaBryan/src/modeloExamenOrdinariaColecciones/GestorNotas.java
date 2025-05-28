package modeloExamenOrdinariaColecciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorNotas {
	Map<Integer, List<Nota>> notasPorAlumno;
	Map<String, List<Nota>> notasPorAsignatura;

	public GestorNotas() {
		notasPorAlumno = new HashMap<Integer, List<Nota>>();
		notasPorAsignatura = new HashMap<String, List<Nota>>();

	}

	// 1) void agregarNota(Nota n)
	// – Añade la nota a ambos mapas.
	public void agregarNota(Nota n) {
		if (!notasPorAlumno.containsKey(n.getIdAlumno())) {

			notasPorAlumno.put(n.getIdAlumno(), new ArrayList<Nota>());
			notasPorAlumno.get(n.getIdAlumno()).add(n);
		} else {
			notasPorAlumno.get(n.getIdAlumno()).add(n);
		}

		// por asignarua
		if (!notasPorAsignatura.containsKey(n.getAsignatura())) {

			notasPorAsignatura.put(n.getAsignatura(), new ArrayList<Nota>());
			notasPorAsignatura.get(n.getAsignatura()).add(n);
		} else {
			notasPorAsignatura.get(n.getAsignatura()).add(n);
		}

	};

	// 2) List<Nota> obtenerNotasPorAlumno(int idAlumno)
	// – Devuelve lista ordenada por asignatura.
	public List<Nota> obtenerNotasPorAlumno(int idAlumno) {
		List<Nota> l = new ArrayList<Nota>();
		l = notasPorAlumno.get(idAlumno);
		if (l == null)
			return new ArrayList<Nota>();
		l.sort(null);// es sting el striubuto no neceisto implements

		return l;
	};

	// 3) List<Integer> obtenerAlumnosPorAsignatura(String asignatura)
	// – Devuelve IDs ordenados ascendentemente.

	public List<Integer> obtenerAlumnosPorAsignatura(String asignatura) {
		List<Nota> notas = notasPorAsignatura.get(asignatura);
		if (notas == null) {
			return new ArrayList<>();
		}
		List<Integer> ids = new ArrayList<>();
		for (Nota n : notas) {
			if (!ids.contains(n.getIdAlumno())) {
				ids.add(n.getIdAlumno());
			}
		}
		ids.sort(null); // orden natural de Integer = ascendente
		return ids;
	}

	// 4) double mediaAlumno(int idAlumno)
	// – Devuelve la media de sus notas.

	public double mediaAlumno(int idAlumno) {
		List<Nota> l = new ArrayList<Nota>(notasPorAlumno.get(idAlumno));

		int total = l.size();
		double suma = 0;
		double media = 0;

		for (int i = 0; i < l.size(); i++) {

			suma += l.get(i).getValor();

		}
		if (total == 0) {
			System.out.println("no hay lementos");
		} else {
			media = (suma) / total;
		}

		return media;

	};

	// 5) List<String> obtenerTodasLasAsignaturas()
	// – Lista de asignaturas distintas ordenada.

	public List<String> obtenerTodasLasAsignaturas() {
		List<String> l = new ArrayList<String>(notasPorAsignatura.keySet());
		l.sort(null);
		return l;
	};

}
