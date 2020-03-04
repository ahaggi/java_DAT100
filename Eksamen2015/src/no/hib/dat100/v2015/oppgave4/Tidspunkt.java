package no.hib.dat100.v2015.oppgave4;

// import java.time.LocalDateTime;

public class Tidspunkt extends Bestilling {

	private String  tidspunkt;
	private String dato;
	
	public Tidspunkt(int kontaktnummer, String navn, String adresse, String tidspunkt) {
		super(kontaktnummer, navn, adresse);
		this.tidspunkt = tidspunkt; 
	}
	
	
	public void skrivUt() {
		System.out.println("Tidspunkt");
		super.skrivUt();
		System.out.println(tidspunkt.toString());
	}
}
