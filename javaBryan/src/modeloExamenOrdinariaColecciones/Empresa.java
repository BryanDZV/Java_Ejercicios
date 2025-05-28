package modeloExamenOrdinariaColecciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Empresa {
	private HashMap<String, ArrayList<Empleado>> porDepto;
	private TreeMap<Integer, ArrayList<Empleado>> porTramoSalario;
	// ej. tramo = (int)(salario/1000) → 0,1,2…

	public Empresa() {
		porDepto = new HashMap<String, ArrayList<Empleado>>();
		porTramoSalario = new TreeMap<Integer, ArrayList<Empleado>>();

	}

	// 1) void añadirEmpleado(Empleado e)
	// – Inserta en porDepto (clave=departamento).
//  – Calcula tramo y añade en porTramoSalario.

	public void añadirEmpleado(Empleado e) {
		if (!porDepto.containsKey(e.getDepartamento())) {
			porDepto.put(e.getDepartamento(), new ArrayList<Empleado>());
			porDepto.get(e.getDepartamento()).add(e);

		} else {
			porDepto.get(e.getDepartamento()).add(e);
		}

		// — porTramoSalario —
		int tramo = (int) (e.getSalario() / 1000);
		if (!porTramoSalario.containsKey(tramo)) {
			porTramoSalario.put(tramo, new ArrayList<>());
		}
		porTramoSalario.get(tramo).add(e);

	};

	// 2) List<Empleado> listarPorDepto(String depto)
	// – Devuelve la ArrayList asociada (o vacía).
	public List<Empleado> listarPorDepto(String depto) {
		// comprobar antes de llamar al constructor de copia:
		List<Empleado> l = porDepto.get(depto);
		if (l == null) {
			return new ArrayList<>();
		} else {
			l = new ArrayList<Empleado>(porDepto.get(depto));

			return l;
		}
	};

	// 3) List<Empleado> tramoSalario(int tramo)
	// – Devuelve ArrayList del tramo.

	public List<Empleado> tramoSalario(int tramo) {
		ArrayList<Empleado> lista = porTramoSalario.get(tramo);
		if (lista == null) {
			// si no existe ese tramo, devolvemos lista vacía
			return new ArrayList<>();
		}
		// devolvemos copia para no exponer tu mapa interno
		return new ArrayList<>(lista);
	}

	// 4) Set<String> departamentos()
	// – Devuelve conjunto de claves de porDepto (TreeSet para ordenarlo).
	public Set<String> departamentos() {

		Set<String> s = porDepto.keySet();
		if (s == null) {
			return new TreeSet<>();
		} else {

			s = new TreeSet<String>(porDepto.keySet());
			return s;
		}

	};

	// 5) int totalEmpleados()
	// – Recorre porDepto y suma tamaños de cada lista.

	public int totalEmpleados() {

		int totalSize = 0;
		for (String clave : porDepto.keySet()) {
			totalSize += porDepto.get(clave).size();
		}

		return totalSize;

	};

}
