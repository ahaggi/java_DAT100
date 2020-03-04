package no.hib.dat100.v2015.oppgave4;

import java.util.Scanner;

public class TaxiTester {

	public static void main(String[] args) {
		Scanner tastatur = new Scanner(System.in);

		System.out.print("Kontaktnummer :");
		int kontaktnummer = tastatur.nextInt();

		tastatur.nextLine();

		System.out.print("Navn: ");
		String navn = tastatur.nextLine();

		System.out.print("Adresse: ");
		String adresse = tastatur.nextLine();

		System.out.println("Velg type: (1) Snarest mulig - (2) Tidspunkt");

		int type = tastatur.nextInt();

		switch (type) {
		case 1:
			System.out.println("Max ventetid: ");
			int makstid = tastatur.nextInt();
			SnarestMulig smbestilling = new SnarestMulig(kontaktnummer, navn,
					adresse, makstid);
			smbestilling.skrivUt();
			break;
		case 2:
			System.out.println("Tidspunkt : ");
			String tidspunkt = tastatur.nextLine();

			Tidspunkt tbestilling = new Tidspunkt(kontaktnummer, navn, adresse,
					tidspunkt);
			tbestilling.skrivUt();
			break;

		default:
			break;
		}
	}
}
