package mapas;

import java.util.Objects;

public class Pares  {
	private int clave;
	private int apariciones;
	public int getClave() {
		return clave;
	}
	public void setClave(int clave) {
		this.clave = clave;
	}
	public int getApariciones() {
		return apariciones;
	}
	public void setApariciones(int apariciones) {
		this.apariciones = apariciones;
	}
	@Override
	public int hashCode() {
		return Objects.hash(apariciones, clave);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pares other = (Pares) obj;
		return apariciones == other.apariciones && clave == other.clave;
	}
	public Pares(int clave, int apariciones) {
		super();
		this.clave = clave;
		this.apariciones = apariciones;
	}
	
	
	@Override
    public String toString() {
        return "Número: " + clave + " - Apariciones: " + apariciones;
    }
	
	
	

}
