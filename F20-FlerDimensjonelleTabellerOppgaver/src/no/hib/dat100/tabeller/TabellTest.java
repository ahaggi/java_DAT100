package no.hib.dat100.tabeller;

public class TabellTest {

	int[][] tab;

	public static void main(String[] args) {

		int[][] todimtab = new int[3][4];

		int[][] todimtab2 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

		int v = todimtab[1][1];

		todimtab[2][1] = 13;

		for (int y = 0; y < todimtab2.length; y++) {
			for (int x = 0; x < todimtab2[y].length; x++) {
				System.out.print(todimtab2[y][x] + " ");
			}
			System.out.println();
			
		}
		
		for (int[] endimtab : todimtab2) {
			for (int verdi : endimtab) {
				System.out.print(verdi + " ");
			}
			
			System.out.println();
		}
		
			
			
	}

}
