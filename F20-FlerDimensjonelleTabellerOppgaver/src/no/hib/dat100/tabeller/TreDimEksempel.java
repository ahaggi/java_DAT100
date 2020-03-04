package no.hib.dat100.tabeller;

public class TreDimEksempel {

	int[][][] tredimtab;

	public void enMetode(int[][][] tab) {
		
		int[][][] tredimtab1 = new int[2][3][4];

		int[][][] tredimtab2 = {
				{ { 1, 2, 3, 4 }, { 2, 3, 4, 5 }, { 3, 4, 5, 6 } },
				{ { 4, 5, 6, 7 }, { 5, 6, 7, 8 }, { 6, 7, 8, 9 } } };

		int v = tredimtab2[1][2][3];

		tredimtab1[0][1][3] = 42;

		int[][] entodimtab = tredimtab2[1];
		int[] enendimtab = tredimtab2[1][2];

		for (int z = 0; z < tredimtab2.length; z++) {
			for (int y = 0; y < tredimtab2[z].length; y++) {
				for (int x = 0; x < tredimtab2[z][y].length; x++) {
					System.out.print(tredimtab2[z][y][x]);
				}
				System.out.println();
			}

			System.out.println();
		}

	}
}
