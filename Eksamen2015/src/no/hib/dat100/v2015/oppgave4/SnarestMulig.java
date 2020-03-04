package no.hib.dat100.v2015.oppgave4;

public class SnarestMulig extends Bestilling {

	private int makstid;
	
	public SnarestMulig(int kontaktnummer, String navn, String adresse, int makstid) {
		super(kontaktnummer, navn, adresse);
		this.makstid = makstid;
	}

	public void skrivUt() {
		System.out.println("Snarest mulig");
		super.skrivUt();
		System.out.println(makstid);
	}
}
