package no.hib.dat100.h2014.oppgave4;

import java.util.Scanner;

public class BlogTester {

	// f)
	public static void main(String[] args) {
		
		Scanner tastatur = new Scanner(System.in);

		System.out.print("Brukernavn :");
		String bruker = tastatur.nextLine();

		System.out.print("Dato: ");
		String dato = tastatur.nextLine();

		System.out.println("Velg type: (1) Bilde - (2) Tekst");

		int type = tastatur.nextInt();
		tastatur.nextLine();
		
		switch (type) {
		case 1:
			System.out.println("URL for bilde : ");
			String url = tastatur.nextLine();

			Bilde bildeinnlegg = new Bilde(bruker, dato, url);
			bildeinnlegg.skrivUt();
			break;
		case 2:
			System.out.println("Tekst: ");
			String tekst = tastatur.nextLine();
			Tekst tekstinnlegg = new Tekst(bruker, dato, tekst);
			tekstinnlegg.skrivUt();
			break;
		default:
			break;
		}
		
		tastatur.close();
	}
}
