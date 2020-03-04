package no.hib.dat100.h2014.oppgave2;

public class BordOversikt {

	private Bord[] bt;

	// constructor - ikke del av oppgaven
	BordOversikt(Bord[] bt) {
		this.bt = bt;
	}

	public int antallLedige() {
		int antall = 0;
		
		for (Bord bord : bt) {
			if (bord.erLedig())
				antall++;
		}

		return antall;
	}

	private boolean erLedigOgPlass(int i, int antall) {
		return bt[i].erLedig() && (bt[i].getAntal() >= antall);
	}

	public int finnForsteLedige(int antall) {
		int i = 0;    // index hvor vi er kommet til
		int fl = -1; //  index på _f_orste _l_edige

		while (fl < 0 && i < bt.length) {
			if (erLedigOgPlass(i, antall)) {
				fl = i;
			}

			i++;
		}

		return fl;
	}

	// sjekker om bord på index i passer bedre en bord på index b
	private boolean passerBedre(int i, int b, int antall) {
		return (bt[i].getAntal() - antall) < (bt[b].getAntal() - antall);
	}

	public int passerBest(int antall) {

		int bsl = finnForsteLedige(antall); // index på _b_este bord _s_å _l_angt

		if (bsl >= 0) { // sjekk om det finnes et bedre blandt resten

			int i = bsl + 1;

			while (i < bt.length) {

				if (erLedigOgPlass(i, antall) && 
						passerBedre(i, bsl, antall)) {
					bsl = i;
				}

				i++;
			}
		}

		return bsl;
	}
}
