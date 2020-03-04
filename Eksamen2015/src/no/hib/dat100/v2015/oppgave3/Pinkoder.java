package no.hib.dat100.v2015.oppgave3;

import java.util.HashMap;

public class Pinkoder {

	private HashMap<Integer, Integer> pinkoder;

	public Pinkoder() {
		pinkoder = new HashMap<Integer, Integer>();
	}

	public void registrerPinkode(Integer kortnummer, Integer pinkode) {
		pinkoder.put(kortnummer, pinkode);
	}

	public boolean sjekkPinkode(Integer kortnummer, Integer pinkode) {
		Integer regpinkode = pinkoder.get(kortnummer);
		boolean korrekt = false;

		if (regpinkode != null) {
			korrekt = (regpinkode.equals(pinkode));
		}

		return korrekt;
	}
	
	/*
	 * d)
	 * D� vil verdien knytta til n�kkelen bli oppdatert. I dette tilfellet
	 * vil det bety at kortet f�r ein ny pinkode.
	 */
}
