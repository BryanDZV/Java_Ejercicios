package coleciones;

import java.util.Objects;

public class Vehiculo {
	private String fabricante;
	private String modelo;
	private TipoVehiculo tipo;
	private int cilindrada;
	private String color;
	
	//concepto de duplicidad o igualdad pero en hasset//
	
	public static void main(String[] args) {
		//main PRUEBA
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return tipo == other.tipo;
	}

	public Vehiculo(String fabricante, String modelo, TipoVehiculo tipo, int cilindrada, String color) {
	super();
	this.fabricante = fabricante;
	this.modelo = modelo;
	this.tipo = tipo;
	this.cilindrada = cilindrada;
	this.color = color;
}




	public String getFabricante() {
		return fabricante;
	}


	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public TipoVehiculo getTipo() {
		return tipo;
	}


	public void setTipo(TipoVehiculo tipo) {
		this.tipo = tipo;
	}


	public int getCilindrada() {
		return cilindrada;
	}


	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}

}
