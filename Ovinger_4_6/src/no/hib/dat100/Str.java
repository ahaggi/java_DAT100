package no.hib.dat100;
import java.util.*;

public class Str {

	/***************************************************/

	

	public static void giOmvendt(String s) {
		System.out.print("strengen baklengs er:");
	    for (int j = s.length()-1; j>=0; j--) {
	    	System.out.print(s.charAt(j));
	    }//end for
	    System.out.println();

} //end of giOmvendt(String s)


	
	/***************************************************/

		public static boolean  erStigende(int...s) {						
		    int i=0;
		    boolean x=true;
		    while ( x && i<s.length-1) {
		    	x=(s[i] <= s[i+1]);
		    	i++;
		    }//end while
			return x;
		}//end erStigende(int...s)
		
		/***************************************************/
		public static int[]  sortStigende(int...s) {						

		int antall = s.length;
		int [] tallTab = s;

		for (int i = 0; i < antall - 1; i++) {
			int minste = i;
			for (int j = i + 1; j < antall; j++) {
				if ((tallTab[j]-tallTab[minste]) < 0) {
					minste = j;
				}
			}
			int k = tallTab[i];
			tallTab[i] = tallTab[minste];
			tallTab[minste] = k;
		}
		return tallTab;
		}
		
		
		/***************************************************/
		public static String giFøsrtIUnicode(String ...str) {
			int comp =0;
	        String førstHittil = str[0]; // tallene[0] er fّrste tallet i listen         
	        for (String nestestr : str) {
	        	comp =nestestr.compareTo(førstHittil);
	        	if(comp<0) {
	            	førstHittil=nestestr;
	        	}
	        }//for
	        return førstHittil;
		}//giFøsrtIUnicode
		
			

		/***************************************************/

		
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
