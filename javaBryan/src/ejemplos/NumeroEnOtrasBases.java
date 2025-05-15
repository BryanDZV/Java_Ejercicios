package ejemplos;

public class NumeroEnOtrasBases {

	public static void main(String[] args) {
		int n=18956;
		
		System.out.println(Integer.toHexString(n));
		System.out.println(Integer.toOctalString(n));
		System.out.println(Integer.toBinaryString(n));
		System.out.println("-------------------");
		int n2=0x4a0c;
		System.out.println(n2);
		n2=045014;
		System.out.println(n2);
		n2=0b100101000001100;
		System.out.println(n2);
	}

}