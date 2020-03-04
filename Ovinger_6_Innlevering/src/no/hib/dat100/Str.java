package no.hib.dat100;
import java.util.*;
public class Str {

	/***************************************************/

	/*	 a) Lag ein metode som skriv ut ein streng baklengs.*/


	public static void giOmvendt(String s) {
		System.out.print("strengen baklengs er:");
	    for (int j = s.length()-1; j>=0; j--) {
	    	System.out.print(s.charAt(j));
	    }//end for
	    System.out.println();

} //end of giOmvendt(String s)


	
	/***************************************************/
	/*b) Lag ein metode for å avgjere om ein array (tabell) fylt av heiltal er sortert stigande (dvs. at alle tal skal vere større enn det forrige). Case2*/

		public static boolean  erStigende(int...s) {						
		    int i=0;
		    boolean x=true;
		    while ( x && i<s.length-1) {
		    	x=(s[i] <= s[i+1]);
		    	i++;
		    }//end while
			return x;
		}//end erStigende(int...s)
		
		
		/***************************************************
		/*c) Lag ein metode som gitt ein tabell fylt av tekststrengar, returnerer den strengen i tabellen som kjem først i (Unikode) alfabetet. Case3*/

		public static String giFøsrtIUnicode(String ...str) {
			int comp =0;
	        String førstHittil = str[0];          
	        for (String nestestr : str) {
	        	comp =nestestr.compareTo(førstHittil);
	        	if(comp<0) {
	            	førstHittil=nestestr;
	        	}
	        }//for
	        return førstHittil;
		}//giFأ¸srtIUnicode
		
			

		/***************************************************/
/*	d) Lag ein metode som gitt ein tabell fylt av tekststrengar, returnerer den strengen i tabellen som kjem først i (Unikode) alfabetet. Case4*/


		
		public static char  giFøsrtIUnicodechar(String s) {
			char[] c = s.toCharArray();

		    Arrays.parallelSort(c); ////// forskjell mellom "parallelSort" OG "Sort"
		    int i=0;
		    char førstHittil= c[i];
		    
			while (førstHittil ==' ' && i<c.length-1){
		    	førstHittil=c[i++];
		    }//end while
		    return førstHittil;
		}

	

}
