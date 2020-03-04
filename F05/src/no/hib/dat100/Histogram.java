package no.hib.dat100;

import java.util.Scanner;

public class Histogram {

	public static void main(String[] args) {
		// lag tabell for 200 elementer
		final int MAKS = 200;
		int[] f = new int[MAKS];

		// les inn det første tallet
		Scanner tastatur = new Scanner(System.in);
		int tal;
		tal = tastatur.nextInt();

		//      løkke
        //		så lenge(tall mellom 0 og 199){
        //		   tell opp i tabell
        //		   les neste tall
        //		}

		while (tal >= 0  && tal < MAKS) {
			f[tal]++;
			tal = tastatur.nextInt();
		}
		// løkke
		// finn indeksen til det minste tallet registrert
		
		int minste = 0;
		while (f[minste] == 0) {
			minste++;
		}
		
		

		// løkke
		// finn indeksen til det største tallet registrert
		int storste = MAKS - 1;
		while (f[storste] == 0) {
			storste--;
		}
		
		// løkke
		// skriv ut tabell fra indeks lik minste til indeks lik største

		for (int i = minste; i <= storste; i++){
			System.out.print(i + ": ");
			for (int j = 0; j < f[i]; j++){
				System.out.print("*");
			}
			System.out.println();
		}
		tastatur.close();
	}

}
