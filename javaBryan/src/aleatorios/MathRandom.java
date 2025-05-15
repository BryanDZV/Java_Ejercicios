package aleatorios;

import java.util.Iterator;

public class MathRandom {

	public static void main(String[] args) {
		
		for (int i=1;i<=20;i++) {
			String res=tirarMoneda();
			System.out.println(res);
		}
	}

	private static String tirarMoneda() {
		double al=Math.random(); //Entre 0 y 1
		
		if (al>=0.5)
			return "cruz";
		else
			return "cara";
	}

}
