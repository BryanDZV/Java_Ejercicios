package examenFinal;

public class Acceso {
	private String usuario="defecto";
	private String contraseña="1234";
	private String url="localhost:8080";
	public String getUsuario() {
		return usuario;
	}
	public Acceso(String usuario, String contraseña, String url) {
		super();
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.url = url;
	}
	
	public Acceso(String usuario) {
		super();
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "Acceso [usuario=" + usuario + ", contraseña=" + contraseña + ", url=" + url + "]";
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
