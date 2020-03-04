package no.hib.dat100.h2014.oppgave2;

public class Bord {

	private int antal;
	private boolean ledig;

	Bord(int antal, boolean ledig) {
		this.antal = antal;
		this.ledig = ledig;
	}

	public int getAntal() {
		return antal;
	}

	public void setAntal(int antal) {
		this.antal = antal;
	}

	public boolean erLedig() {
		return ledig;
	}

	public void setLedig(boolean ledig) {
		this.ledig = ledig;
	}
	
	
}
