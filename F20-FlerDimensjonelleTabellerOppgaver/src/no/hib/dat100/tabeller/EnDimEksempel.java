package no.hib.dat100.tabeller;

public class EnDimEksempel {

	int[] itab;    // tabell primitiv type
	Person[] ptab; // tabell ikke-primitiv type
	
	int[] inittab = {1,2,3,4,5,6,7};
	
	public void enMetode(Person[] ptab) { 
	
		itab = new int[4];
		
		
		
		itab[0] = 5;      // <tabelnavn>[<indeks>] = <verdi>
		int v = itab[0];  // <tabellnavn[<indeks>]
		
		for (int i = 0;i < itab.length;i++) {
			System.out.println(itab[i]);
		}
		
		for (int verdi : itab) { // forenklet for-løkke
			System.out.println(verdi);
		}
			
		int i = 0;
		while (i < itab.length) {
			System.out.println(itab[i]);
			i++;
		}
			
	}
	
	
}
