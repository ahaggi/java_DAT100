package no.hib.dat100.flooding;

import java.util.Scanner;

public class Flooding {

	static char DEKKET_CHR = '~';

	static char NESTEN_DEKKET_CHR = 'O';
	static int NESTEN_DEKKET_INT = 2; // nesten dekket hvis mindre en fra
										// havoverflade

	static char SIKKERT_CHR = '+';

	public static void main(String args[]) {

		// terreng hogde
		int[][] terreng = { { 0, 0, 0, 3, 3, 3, 6, 7, 8, 10 },
				{ 0, 0, 0, 3, 3, 3, 6, 7, 8, 10 },
				{ 0, 0, 0, 3, 3, 3, 6, 7, 8, 10 } };

		int hav = 0;

		while (hav >= 0) {
			Scanner in = new Scanner(System.in);

			// TODO - START
			// Kunne også ha brukt vanlig for-løkke
			
			for(int[] x : terreng){
				for(int h : x ){
					char c;

					if (h < hav)
						c = DEKKET_CHR;
					else if (h - hav > NESTEN_DEKKET_INT)
						c = SIKKERT_CHR;
					else
						c = NESTEN_DEKKET_CHR;

					System.out.print(c);
				}
				System.out.println();

			}

			// TODO - SLUTT
			
			System.out.print("Hav høyde : ");
			hav = in.nextInt();
		}
	}
}