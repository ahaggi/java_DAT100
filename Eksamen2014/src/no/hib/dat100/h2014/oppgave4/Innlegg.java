package no.hib.dat100.h2014.oppgave4;

public class Innlegg {

	// a)
	private String bruker;
	private String dato;
	private int likes;
	
	public Innlegg(String bruker, String dato) {
		this.bruker = bruker;
		this.dato = dato;
		likes = 0;
	}

	public String getBruker() {
		return bruker;
	}

	public void setBruker(String bruker) {
		this.bruker = bruker;
	}

	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	// b)
	public void skrivUt() {
		System.out.println("Bruker : " + bruker);
		System.out.println("Dato: :  " + dato);
		System.out.println("Likes :  " + likes);
	}
	
	// c)
	public void atLike() {
		likes++;
	}
}
	
