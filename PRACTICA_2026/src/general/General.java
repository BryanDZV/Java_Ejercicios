package general;

public class General {
	private String mensajes[];

	private int numeroMensajes;
	private int indice;
	private final int DESPLAZAMIENTO = 3;

	public General(int numeroMensajes) {
		this.numeroMensajes = numeroMensajes;
		this.mensajes = new String[this.numeroMensajes];
	}

	public String[] getMensajes() {
		return mensajes;
	}

	public int getNumeroMensajes() {
		return numeroMensajes;
	}

	public void setNumeroMensajes(int numeroMensajes) {
		this.numeroMensajes = numeroMensajes;
	}

	public String cifraMensaje(String mensajeX) {
		String mensajeCifrado = "";
		for (int i = 0; i < mensajeX.length(); i++) {
			char c = mensajeX.charAt(i);
			int nuevaPosicion = c + DESPLAZAMIENTO;
			char nuevoChar = (char) nuevaPosicion;
			mensajeCifrado += nuevoChar;
		}
		return mensajeCifrado;
	}

	public String decifrarMensaje(String mensajeY) {
		String mensajeDecifrado = "";
		for (int i = 0; i < mensajeY.length(); i++) {
			char c = mensajeY.charAt(i);
			int nuevaPosicion = c - DESPLAZAMIENTO;
			char nuevoChar = (char) nuevaPosicion;
			mensajeDecifrado += nuevoChar;
		}
		return mensajeDecifrado;

	}

	public void guardarMensaje(String texto) {
		validar(texto);
		
		if (this.indice >= mensajes.length) {
			throw new IllegalStateException("capacidad al maximo");
		}
		mensajes[this.indice] = cifraMensaje(texto);
		this.indice++;
	}

	public void validar(String x) {
		if (x.isEmpty()) {
			throw new IllegalArgumentException("no se puede guardar mensaje vacios");
		}
	}

}
