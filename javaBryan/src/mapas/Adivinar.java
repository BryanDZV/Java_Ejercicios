package mapas;

import java.util.Objects;

public class Adivinar {
	private String clave;
	private String repuesta;
	private String repsuestaCorrecta;
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getRepuesta() {
		return repuesta;
	}
	public void setRepuesta(String repuesta) {
		this.repuesta = repuesta;
	}
	public String getRepsuestaCorrecta() {
		return repsuestaCorrecta;
	}
	public void setRepsuestaCorrecta(String repsuestaCorrecta) {
		this.repsuestaCorrecta = repsuestaCorrecta;
	}
	public Adivinar(String clave, String repuesta, String repsuestaCorrecta) {
		super();
		this.clave = clave;
		this.repuesta = repuesta;
		this.repsuestaCorrecta = repsuestaCorrecta;
	}
	@Override
	public int hashCode() {
		return Objects.hash(clave, repsuestaCorrecta, repuesta);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adivinar other = (Adivinar) obj;
		return Objects.equals(clave, other.clave) && Objects.equals(repsuestaCorrecta, other.repsuestaCorrecta)
				&& Objects.equals(repuesta, other.repuesta);
	}
	@Override
	public String toString() {
		return   clave + "--->" + repuesta +" --->CORRECCION---> "+ repsuestaCorrecta +" \n" ;
	}

	

}
