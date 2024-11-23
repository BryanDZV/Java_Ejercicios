package algoritmos;

public class BucleFor {

	public static void main(String[] args) {

		int i;
		for (/* A */ i = 1; /* B */ i <= 10; /* C */ i = i + 1) {

			/* FOR ESCRITO COMO WHILE */

			System.out.println("for escrito como while");
			i = 1;/* A */
			while (/* B */i <= 10) {
				System.out.println(i);
				System.out.println(i);
				System.out.println(i);
				i = i++;/* C */
				
			}
		}

	}

};
