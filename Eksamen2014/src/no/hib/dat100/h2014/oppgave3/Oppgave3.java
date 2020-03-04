package no.hib.dat100.h2014.oppgave3;

import java.util.HashMap;
import java.util.Scanner;

public class Oppgave3 {

	private static String[] lesDataFraFil() {
		String[] ordliste = { "er", "det", "er", "alle", "det", "det" };

		return ordliste;
	}

	public static void main(String[] args) {

		HashMap<String, Integer> ft = new HashMap<String, Integer>();

		// Etter denne setningen er utf�rt, ligg orda i tabellen data.
		// Alle posisjonane er i bruk
		String[] data = lesDataFraFil();

		// a
		// Lag frekvenstabellen
		for (String s : data) {
			Integer frekvens = ft.get(s);

			if (frekvens != null) {
				ft.put(s, frekvens + 1);
			} else {
				ft.put(s, 1);
			}
		}

		// b
		// Vise korleis du s�ker etter eit ord i frekvenstabellen
		Scanner tastatur = new Scanner(System.in);

		System.out.println("Inntast ord: ");
		String etord = tastatur.next();
		tastatur.close();

		Integer frekvens = ft.get(etord);
		if (frekvens == null) {
			frekvens = new Integer(0);
		}

		System.out.println("Frekvens: " + frekvens);

		// c
		// Skriv ut frekvenstabellen
		for (String ord : ft.keySet()) {
			System.out.println(ord + " " + ft.get(ord));
		}
	}

}
