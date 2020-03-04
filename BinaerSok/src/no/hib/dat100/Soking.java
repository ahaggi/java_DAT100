package no.hib.dat100;

public class Soking {

	/*************************************************************************************************/
	// S�kealgoritmer
	/*************************************************************************************************/

	/**
	 * Metoden gj�r et bin�rt s�k i en sortert tabell av heltall
	 * 
	 * @param data
	 *            er data som skal s�kes i
	 * @param min
	 *            er startindeks
	 * @param maks
	 *            er sluttindeks
	 * @param el
	 *            er elementet vi s�ker etter
	 * @return sann dersom elementet ble funnet ellers usann.
	 */

	/* Rekursiv bin�rs�k som returnerer ved funn ellers -1 */

	public static int binaerSok(int[] data, int min, int maks, int el) {
		// Returnerer indeksen til m�lelementet hvis det fins ellers -1
		if (min > maks) { // basistilfelle, ingen element
			return -1;
		}

		int midten = (min + maks) / 2;
		int midtTall = data[midten];
		if (el == midtTall) { // basistilfelle, finner elementet
			return midten;
		}
		if (el < midtTall) {// ( vil her ogs� fungere med else if)
			return binaerSok(data, min, midten - 1, el);
		} else { // resultat > 0
			return binaerSok(data, midten + 1, maks, el);
		}
	}// metode

	
	/* Ikke rekursiv bin�rs�k som returnerer indeks */
	public static  int binaerSok2(int[] data, int min, int maks, int el) {
		// Returnerer indeksen til m�lelementet hvis det fins ellers -1
		int forste = min;
		int siste = maks;
		int indeks = -1;
		boolean funnet = false;
		while ((forste <= siste) && !(funnet)) {
			int midten = (forste + siste) / 2;
			int midtTall = data[midten];
			if (el == midtTall) {
				funnet = true;
				indeks = midten;
			} else if (el < midtTall) {// S�k i nedre halvdel
				siste = midten - 1;
			} else {// S�k i �vre halvdel
				forste = midten + 1;
			}
		} // while

		return indeks;
	}//

}// class
