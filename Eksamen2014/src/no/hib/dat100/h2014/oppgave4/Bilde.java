package no.hib.dat100.h2014.oppgave4;

public class Bilde extends Innlegg {

	// d)
	private String url;
	
	// e)
	public Bilde(String bruker, String dato, String url) {
		super(bruker, dato);
		this.url = url;
	}

	// f)
	public void skrivUt() {
		super.skrivUt();
		System.out.println("Url " + url);
	}
}

