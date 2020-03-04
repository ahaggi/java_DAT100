package no.hib.dat100.v2015.oppgave5;

public class Sjakkbrett {

	private final int ST�RRELSE = 8;

	private boolean[][] brett = {
			{ true, true, true, false, true, true, true, true },
			{ true, true, true, true, true, true, true, true },
			{ true, true, true, true, true, true, true, true },
			{ true, false, true, false, true, true, true, true },
			{ true, true, true, true, true, true, true, true },
			{ true, true, true, true, true, true, true, true },
			{ true, true, true, false, true, true, true, true },
			{ true, true, true, true, true, true, true, true } };

	public boolean innanfor(int r, int k) {
		return (r >= 0 && r < ST�RRELSE && k >= 0 && k < ST�RRELSE);
	}

	public int antallTomme() {
		int antall = 0;

		for (boolean[] rad : brett) {
			for (boolean felt : rad) {
				if (felt) {
					antall++;
				}
			}
		}

		return antall;

	}

	// alternativ
	public int antallTomme2() {
		int antall = 0;

		for (int i = 0; i < ST�RRELSE; i++) {
			for (int j = 0; j < ST�RRELSE; j++) {
				if (brett[i][j]) {
					antall++;
				}
			}
		}

		return antall;

	}

	public int antalTaarnTrekk(int r, int k) {

		int antall = 0;

		/* sjekk til h�yre */
		int klh = k + 1;
		while (innanfor(r, klh) && brett[r][klh]) {
			antall++;
			klh++;
		}

		/* sjekk til venstre */
		int klv = k - 1;
		while (innanfor(r, klv) && brett[r][klv]) {
			antall++;
			klv--;
		}

		/* sjekk opp */
		int ro = r - 1;
		while (innanfor(ro, k) && brett[ro][k]) {
			antall++;
			ro--;
		}

		/* sjekk ned */
		int rn = r + 1;
		while (innanfor(rn, k) && brett[rn][k]) {
			antall++;
			rn++;
		}

		return antall;
	}
}
