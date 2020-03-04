package ansatte;

import easyIO.*;

public class ArbeidstakarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArbeidstakarOversikt arOversikt = new ArbeidstakarOversikt() ;
		In fil = new In("register_Arbeidstakar.txt");


			while (!fil.lastItem()) {
				
				String n = fil.inWord();
				int arnr =fil.inInt();
				double tl=fil.inDouble();
				double at=fil.inDouble();
				double sp=fil.inDouble();		

				Arbeidstakar arTakar = new Arbeidstakar(n,arnr,tl,at,sp);
				arOversikt.leggTil(arTakar);
			}// while

		
			In tastValg = new In();

			Out skjerm = new Out();
			String meny = "\n" + "1 - Søk etter en arbeidstaker.\n"
					+ "2 - Slett en arbeidstakars opplysninger. \n"
					+ "3 - Skriv ut en lønsoversikt.\n"
					+ "4 -  avslutt program\n" + "\n" + "valg: ";

			String valg = "";

			do {
				skjerm.out(meny);
				valg = tastValg.inWord();

				switch (valg) {
				case "1":
					arOversikt.skrivArbeidstakar();//har brukt 2 ulike søking methoder
					skjerm.outln();
					break;
				case "2":
					arOversikt.slett(); //har brukt 2 ulike søking methoder 
					skjerm.outln();
					break;
				case "3":
					arOversikt.visAlle();
					skjerm.outln();
					break;
				case "4": // avslutter
					valg="4";
					break;

				default:
					skjerm.outln("Ukjent menyvalg, valg nr 4 avslutter programmet.");
				}
			} while (valg != "4"); // lّkke


				



			
		



		
		
	}


}
