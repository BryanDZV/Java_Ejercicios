package ej3;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Ciudad {
	private String poblacion;
	private Map<String,List<Integer>> porDepartamento;
	
	
	
	public Ciudad() {
	
		this.poblacion = poblacion;
		this.porDepartamento = new TreeMap<String, List<Integer>>();
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public Map<String, List<Integer>> getPorDepartamento() {
		return porDepartamento;
	}
	public void setPorDepartamento(Map<String, List<Integer>> porDepartamento) {
		this.porDepartamento = porDepartamento;
	}



}
