package no.hib.dat100.modell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Hovedklasse for eiendomsregister.
 * @author Lars Kristensen
 * @version 1.0
 */
public class EiendomsRegister {

	private String kommune;
	private HashMap<String,Eiendom> eiendommer;
	
	/**
	 * Konstruer og initialiser eiendomsregister.
	 * @param kommune kommune for register
	 */
	public EiendomsRegister(String kommune) {
		this.kommune = kommune;
		eiendommer = new HashMap<String,Eiendom>();
	}
	
	// gns og bns blir brukt som nّkkel (key) i HashMap
	private String key(int gns,int bns) {
		return gns + " " + bns;
	}
	
	/**
	 * Registrer eiendom i register.
	 * @param nyeiendom eiendom som skal registreres
	 */
	public void registrerEiendom(Eiendom nyeiendom) {
		int gns = nyeiendom.getGns();
		int bns = nyeiendom.getBns();
		
		eiendommer.put(key(gns,bns),nyeiendom);
	}
	
	/**
	 * Finn eier i eiendomsregister.
	 * @param fodselsnummer fّdselsnummer pه eier
	 * @return eier (null hvis eier ikke finnes)
	 */
	public Eier finnEier(int fodselsnummer) {//TODO ITL ÅFINNE EN EIER SOM ER REGISTERET I EIENDOMREGISTERET مش في كلاس الملاك لكن من كلاس الممتلاكات
		
		// TODO potensjale for effektivitetsforbedring her
		Eier eier = null;
		boolean funnet = false;
		
		// iterator for eiendommer
		Iterator<Eiendom> eiendomit = eiendommer.values().iterator();
		
		while (!funnet && eiendomit.hasNext()) {
			
			// sjekk eiere i neste eiendom
			Eiendom eiendom = eiendomit.next();
			ArrayList<Eier> eiere = eiendom.getEiere();
			
			int i = 0;
			while (!funnet & i<eiere.size()) {
				
				Eier eneier = eiere.get(i);
				
				if (eneier.getFodselsnummer() == fodselsnummer) {
					funnet = true;
					eier = eneier; 
				}
				
				i++;
			}
		}
		return eier;
	}
	
	/**
	 * Registrer (legg til) eier pه en eiendom.
	 * @param eier eier som skal registreres pه eiendom
	 * @param gns gهrdsnummer for eiendom
	 * @param bns bruksnummer for eiendom
	 */
	public void registrerEier(Eier eier, int gns, int bns) {
		
		Eiendom eiendom = eiendommer.get(key(gns,bns));
		
		eiendom.registrerEier(eier);
	}
	
	/**
	 * Hent eiendom i register.
	 * @param gns Gهrdsnummer
	 * @param bns Bruksnummer
	 * @return eiendom i register (null ellers)
	 */
	public Eiendom finnEiendom(int gns,int bns) {
		return eiendommer.get(key(gns,bns));
	}
}
