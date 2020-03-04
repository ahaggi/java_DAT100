package no.hib.dat100.v2015.oppgave4;

public class Bestilling {

	private int kontaktnummer;
	private String navn;
	private String adresse;
	
	public Bestilling(int kontaktnummer, String navn, String adresse) {
		this.kontaktnummer = kontaktnummer;
		this.navn = navn;
		this.adresse = adresse;
	}

	public void skrivUt() {
		System.out.println("Kontaktnummer: " + kontaktnummer);
		System.out.println("Navn         : " + navn);
		System.out.println("Adresse      : " + adresse);
	}
}
