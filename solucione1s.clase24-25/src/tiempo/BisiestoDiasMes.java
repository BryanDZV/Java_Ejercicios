package tiempo;

public class BisiestoDiasMes {

	public static void main(String[] args) {
		System.out.println(diasMes(2, 2024));

	}

	public static boolean bisiesto(int a) {
	
		return (a % 400 == 0) || (a % 4 == 0 && a % 100 != 0);
	}

	public static int diasMes(int m, int a) {
		if (m<1 || m>2)
			throw new IllegalArgumentException("El mes debe estar entre 1 y 12");
	
		switch (m) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 4:
		case 6:
		case 9:
		case 11:
			return (30);
		case 2:
			if (bisiesto(a))
				return 29;
			else
				return 28;
		default:
			return 0;
		}
	}

}
