package graficos;



import utilidades.StdDraw;

public class RatonDetectarClick {
	static boolean recienPulsado=false;

	public static void main(String[] args) {
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		StdDraw.enableDoubleBuffering();

		for (;;) {
			StdDraw.clear();
			// Ejes y círculo de referencia
			pintarEjes();
			StdDraw.circle(0, 0, 50);
			StdDraw.show();
			StdDraw.pause(50);

			if (clickRaton())
				System.out.println("Click de ratón");
		}
	}

	private static boolean clickRaton() {
		if (StdDraw.isMousePressed()) {
			if (!recienPulsado) {
				recienPulsado = true;
				return true;
			}
		}else
			recienPulsado = false;
		return false;
	}

	private static void pintarEjes() {
		// Ejes
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setPenRadius(0.003);
		StdDraw.line(0, -100, 0, 100);
		StdDraw.text(2, 98, "y");
		StdDraw.line(-100, 0, 100, 0);
		StdDraw.text(98, 2, "x");
	}

}

