package no.hib.dat100.h2014.oppgave4;

public class Tekst extends Innlegg {

	// d)
	private String tekst;
	
	// e)
	public Tekst(String bruker, String dato, String tekst) {
		super(bruker, dato);
		this.tekst = tekst;
	}

	// f)
	public void skrivUt() {
		super.skrivUt();
		System.out.println(tekst);
	}
}
