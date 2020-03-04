package no.hib.dat100;

public class printf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double pris = 25.60;
		System.out.printf("%6.3f", pris);
		System.out.println(" kr");

		int i = 461012;
		System.out.format("The value of i is: %d%n", i);
		/*
		 * %n start from new line
		 20 tegnplasser venstrejustert (-tegnet)
		 8 tegnplasser og tar 2 desimaler, høyrejustert
		 6 tegnplasser, høyrejustertlinjeskift
		 */
	}

}
