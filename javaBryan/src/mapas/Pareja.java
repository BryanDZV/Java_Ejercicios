package mapas;

import java.util.Objects;

public class Pareja {
	String palEs;
	String palIng;
	
	public Pareja(String palEs, String palIng) {
		super();
		this.palEs = palEs;
		this.palIng = palIng;
	}
	
	public String getPalEs() {
		return palEs;
	}
	public void setPalEs(String palEs) {
		this.palEs = palEs;
	}
	@Override
	public String toString() {
		return  "[ "+palEs + "-" + palIng + " ]"+ "\n";
	}

	@Override
	public int hashCode() {
		return Objects.hash(palEs, palIng);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pareja other = (Pareja) obj;
		return Objects.equals(palEs, other.palEs) && Objects.equals(palIng, other.palIng);
	}

	public String getPalIng() {
		return palIng;
	}
	public void setPalIng(String palIng) {
		this.palIng = palIng;
	}

}
