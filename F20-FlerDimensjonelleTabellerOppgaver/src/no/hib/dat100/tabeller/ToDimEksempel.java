package no.hib.dat100.tabeller;

public class ToDimEksempel {

	int[][] todimtab; // <datatype>[][] <navn>;

	public void enMetode(int[][] tab) // <datatype>[][] <navn>
	{
		// <datatype>[][] <navn> = new <datatype>[<antall rekker>][<antall kolonner>];
		int[][] todimtab1 = new int[3][2];

		// <datatype>[][] <navn> = { { <start00>,<start01>, ... <start0(N-1)> },
		//                           { <start10>,<start11>, ... <start1(N-1)> },
		//                             ...
		//                           { <start(M-1)0>,<start(M-1>1,...<start(M-1)(N-1)> } }

		// i dette tilfelle M=3(rekker),N=2(kolonner)
		int[][] todimtab2 = { { 1, 2 }, { 3, 4 }, { 5, 6 } }; 

		// <tabellnavn>[<rekkeindeks>][<kolonneindeks>];
		int verdi = todimtab2[2][1]; 
		
		// <tabellnavn>[<rekkeindeks>][<kolonneindeks>] = <verdi>;
		todimtab1[0][1] = 42; 
		
		int[] enrad = todimtab2[1]; // <tabellnavn>[<rekkeindeks>];

		for (int r = 0; r < todimtab2.length; r++) {
			for (int k = 0; k < todimtab2[r].length; k++) {
				System.out.print(todimtab2[r][k]);
			}
			
			System.out.println();
		}
		
		for (int[] t : todimtab2) {
			for (int v : t) {
				System.out.print(v);
			}
			
			System.out.println();
		}

	}
}
