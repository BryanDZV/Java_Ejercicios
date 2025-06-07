package mapas;

import java.util.Comparator;

public class OrdenPorAparYNum implements Comparator< Pares> {

	@Override
	public int compare(Pares o1, Pares o2) {
		int orden=-(o1.getApariciones()-o2.getApariciones());///-PARA HACER IVERSO 
		if (orden==0) {
			orden=o1.getClave()-o2.getClave();
		}
		return orden;
	}

}
