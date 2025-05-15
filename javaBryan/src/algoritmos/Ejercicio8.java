package algoritmos;

public class Ejercicio8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] grupo= {2,5,8,7,454,7,454,78,121,1,5,1,54,12};
		int contador1=0;
		int contador2=0;
		int contador3=0;
		
		for (int i = 0; i < grupo.length; i++) {
			
			if (grupo[i]<25) {
				contador1++;}
				else if (grupo[i]>=25 && grupo[i]<70) {
					contador2++;
				}else {
					contador3++;
				}
				
			}
		System.out.println("numero menores de 25:----"+contador1);
		System.out.println("numero mayores o igual que 25 y menores que 70:----"+contador2);
		System.out.println("numeros mayores que 70:---"+contador3);
		}

	}


