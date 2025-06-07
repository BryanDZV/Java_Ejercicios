package ejemplos;

public class Pareja implements Comparable<Pareja> {
	private String esp;
	private String ing;
	public Pareja(String esp, String ing) {
		super();
		this.esp = esp;
		this.ing = ing;
	}
	public String getEsp() {
		return esp;
	}
	public void setEsp(String esp) {
		this.esp = esp;
	}
	public String getIng() {
		return ing;
	}
	public void setIng(String ing) {
		this.ing = ing;
	}
	@Override
	public int compareTo(Pareja o) {
		
		return this.getIng().compareTo(o.getIng());
	}
	

}
