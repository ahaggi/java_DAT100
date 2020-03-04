
package no.hib.dat100;

/* 
 * ”Lag et lite program som lar brukeren taste inn nedbّrsmengde for de 
 *  syv dagene i en uke. Deretter skal programmet finne ut hvilken dag 
 *  det regnet mest og hvor mye det regnet denne dagen. Svaret skrives 
 *  ut pه skjermen.”
 */

import java.util.Scanner; 
 
public class Nedbor {
    
    public static void  main(String[] args) {
        
        Scanner tastatur = new Scanner(System.in);
        
        final int ANTALL_DAGER_I_UKEN = 7;
                
        String[] dager = {"mandag", "tirsdag", "onsdag", "torsdag",
                "fredag", "lّrdag", "sّndag"};
                
        double[] nedbor = new double[ANTALL_DAGER_I_UKEN]; //Indeks 0..6
        
        for (int dagNr = 0; dagNr < ANTALL_DAGER_I_UKEN; dagNr++) {
            System.out.print("Tast inn nedbّr for " + dager[dagNr] + ": ");
            nedbor[dagNr] = tastatur.nextDouble(); 
            //tastatur.nextLine();
        }
        
        int dagMedMaksNedbor = 0;
        for (int dagNr = 1; dagNr < ANTALL_DAGER_I_UKEN; dagNr++) {
            if (nedbor[dagNr] > nedbor[dagMedMaksNedbor]) {
                dagMedMaksNedbor = dagNr;
            }
        }
        
        System.out.println("Det regnet mest på " 
                + dager[dagMedMaksNedbor] 
                + ". Nedbّrsmengden var " 
                + nedbor[dagMedMaksNedbor] + " mm.");
		tastatur.close();

    }
}

