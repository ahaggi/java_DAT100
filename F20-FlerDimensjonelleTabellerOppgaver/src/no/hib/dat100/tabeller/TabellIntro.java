package no.hib.dat100.tabeller;

public class TabellIntro {

	int[][] todimtab;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] todimtab = new int[4][3];
		
		int[][] todimtabinit = { {1,2,3}, {4,5,6}, {7,8,9}, {10,11,12}};
		
		for (int y = 0; y<todimtabinit.length; y++) {
			for (int x = 0; x<todimtabinit[y].length;x++) {
				System.out.print(todimtabinit[y][x] + " ");
			}
			System.out.println();
			
		}
		
		int v = todimtabinit[2][1];
		
		System.out.println(v);
		
		for (int[] entab : todimtabinit) {
			for (int verdi : entab) {
				System.out.print(verdi + " ");
			}
			
			System.out.println();
		}
		
		
	}


}
