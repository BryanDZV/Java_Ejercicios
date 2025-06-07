package ej3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Departamentos {
	// private Ciudad ciudad;
	private Map<String, List<Integer>> porDepartamento;
	private Map<String, List<Integer>> porPoblacion;

	public Departamentos() {

		porDepartamento = new HashMap<String, List<Integer>>();
		// porPoblacion = new HashMap<String, List<String>>();
	}

	public void agregarM1(Map<String, Integer> mostolesDep) {
		for (String dep : mostolesDep.keySet()) {
			if (!porDepartamento.containsKey(dep)) {
				porDepartamento.put(dep, new ArrayList<Integer>());

			} else {
				porDepartamento.get(dep).add(mostolesDep.get(dep));
			}

		}

	}

	public void agregarV1(Map<String, Integer> villalba) {
		for (String dep : villalba.keySet()) {
			if (!porDepartamento.containsKey(dep)) {
				porDepartamento.put(dep, new ArrayList<Integer>());

			} else {
				porDepartamento.get(dep).add(villalba.get(dep));
			}

		}

	}

	public void agregarMj1(Map<String, Integer> majadahonda) {
		for (String dep : majadahonda.keySet()) {
			if (!porDepartamento.containsKey(dep)) {
				porDepartamento.put(dep, new ArrayList<Integer>());

			} else {
				porDepartamento.get(dep).add(majadahonda.get(dep));
			}

		}

	};

	public TreeMap<String, Integer> listado() {
		TreeMap<String, Integer> listado = new TreeMap<String, Integer>();
		int suma = 0;
		if (listado == null) {
			return new TreeMap<String, Integer>();
		} else {

			for (String dep : porDepartamento.keySet()) {
				// System.out.println(dep+"---"+porDepartamento.get(dep));
				for (int i = 0; i < porDepartamento.get(dep).size(); i++) {
					suma += porDepartamento.get(dep).get(i);
					listado.put(dep, suma);

				}

			}
		}

		return listado;

	};

}
