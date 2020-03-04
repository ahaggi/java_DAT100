package no.hib.dat100.v2015.oppgave2;

public class ToDoListe {

	private int antall;
	private ToDoElement[] todoTab;

	public ToDoListe(int maksAntall) {

		todoTab = new ToDoElement[maksAntall];
		antall = 0;
	}

	// skrivUt er ikke en del av oppgaven
	public void skrivUt() {
		System.out.println("----------------------");
		for (int i = 0; i < antall; i++) {

			System.out.print(todoTab[i].toString());

		}
		System.out.println("----------------------");
	}

	public void LeggTil(ToDoElement tde) {
		if (antall < todoTab.length) {
			todoTab[antall] = tde;
			antall++;
		} else {
			System.out.println("Ikke plass til flere elementer");
		}
	}

	public void nyPrioritet(int nummer, int prioritet) {
		boolean funnet = false;

		int i = 0;
		while (!funnet && i < antall) {
			if (todoTab[i].getNummer() == nummer) {
				todoTab[i].setPrioritet(prioritet);
				funnet = true;
			}
			i++;
		}
		
		if (!funnet) {
			System.out.println("Finner ikke element nr: " + nummer);
		}
	}

	// Unøyaktig oppgavetekst. Ikkje samsvar med tekst og returtype (void).
	public void slett(int nummer) {
		int sletteindex = -1;
		
		
		int i = 0;
		while (sletteindex < 0 && i < antall) {
			if (todoTab[i].getNummer() == nummer) {
				sletteindex = i;
			}
			i++;
		}
		
		if (sletteindex >= 0) {
			todoTab[sletteindex] = todoTab[antall - 1];
			todoTab[antall - 1] = null;
			antall--;
		}
	}

	public ToDoElement finnViktig() {
		ToDoElement element = null;

		if (antall > 0) {
			element = todoTab[0];

			for (int i = 1; i < antall; i++) {
				if (todoTab[i].getPrioritet() < element.getPrioritet()) {
					element = todoTab[i];
				}
			}
		}

		return element;
	}

	public ToDoListe merPlass() {
		ToDoListe nyliste = new ToDoListe(todoTab.length * 2);

		for (int i = 0; i < antall; i++) {
			nyliste.LeggTil(todoTab[i]);
		}

		return nyliste;
	}
}
