package no.hib.dat100.h2014.oppgave5;

public class Login {

	private boolean[][] monster = 
		{ { true, false, false },
		  { true, true, true }, 
		  { false, false, true } };

	// a)
	public boolean erMed(int r, int k) {
		return monster[r][k];
	}

	// b)
	public void skrivUt() {
		for (boolean[] rad : monster) {
			for (boolean c : rad) {
				if (c) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	// c) - løsning med bruk av while-løkke
	public boolean sjekkMonsterWhile(boolean[][] mnstr) {

		boolean identisk = true;

		// løsning med bruk av while-løkke
		int i = 0;
		while (identisk && i < 3) {
			int j = 0;
			while (identisk && j < 3) {
				identisk = (mnstr[i][j] == monster[i][j]);
				j++;
			}
			i++;
		}

		return identisk;
	}
	
	// c) - løsning med bruk av for-løkke
	public boolean sjekkMonsterFor(boolean[][] mnstr) {

		for (int i = 0; i<3;i++) {
			for (int j = 0; j<3;j++) {
				if (mnstr[i][j] != monster[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}

}
