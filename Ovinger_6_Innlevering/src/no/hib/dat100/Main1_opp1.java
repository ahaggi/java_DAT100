package no.hib.dat100;

import easyIO.In;
import easyIO.Out;

public class Main1_opp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		In tastValg = new In();
		In tastatur = new In();

		Out skjerm = new Out();
		String meny = "\n" + "1 -  En metode som skriver ut en streng baklengs.\n"
				+ "2 -  En metode for å avgjøre om en array (tabell) fylt av heltal er sortert stigende. \n"
				+ "3 -  En metode som gitt en tabell fylt av tekststrengar, returnerer den strengen i tabellen som kjem først i (Unikode) alfabetet.\n"
				+ "4 -  En metode som gitt en tekststreng, returnerer den bokstaven i tekststreng som kjem først i (Unikode) alfabetet.\n"
				+ "5 -  avslutt program\n" + "\n" + "valg: ";

		int valg = 0;

		do {
			skjerm.out(meny);
			valg = tastValg.inInt();

			switch (valg) {
			case 1:
				skjerm.out("Tast inn en setning: ");
				String setning3 = tastatur.inLine();
				Str.giOmvendt(setning3);// opp3 A
				System.out.println();
				break;

			case 2:
				skjerm.out("Tast inn en array fylt av heltal i en linje tallene må skylles med et mellomrom:  ");
				String sTall = tastatur.inLine();
				String[] st = sTall.split(" ");
				int j = 0;
				for (String w : st) {
					if (w.length() != 0) {
						j++;
					}
				}

				int[] tall = new int[j];
				int i = 0;

				for (String w : st) {
					if (w.length() != 0) {
						tall[i] = Integer.parseInt(w);
					}
					i++;
				}

				boolean b = Str.erStigende(tall);// opp3 B
				if (b == true) {
					System.out.println("Tabellen er sortert stigande");
				} else {

					System.out.println("Tabellen er ikke sortert stigande");
				}
				break;

			case 3:

				String[] setning = new String[] { "ggdld", "abAbt", "ar", "abbt" };
				String alfabet = Str.giFøsrtIUnicode(setning);
				System.out.println("I tabellen { ggdld, abAbt, ar, abbt },  stringen som er først i (Unikode) alfabetetter er: " + alfabet);
				break;

			case 4:
				skjerm.out("Tast inn en setning: ");
				String setning4 = tastatur.inLine();

				char alfabet2 = Str.giFøsrtIUnicodechar(setning4);
				System.out.println();
				System.out.println("I setning : " + setning4);
				System.out.println("Det char som er først i (Unikode) alfabetetter er: " + (alfabet2)
						+ " og har Unicode nr: " + (alfabet2 + 0));
				break;
			case 5: // avslutter
				break;

			default:
				skjerm.outln("Ukjent menyvalg, valg nr 5 avslutter programmet.");
			}
		} while (valg != 5); // lّkke

	}// metode
}
