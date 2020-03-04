package no.hib.dat100;
import java.util.Random;
public class terningkast {

		
		public static int [] Random(int antallKast){
			int [] res =new int[antallKast];
			Random terning = new Random();
			for (int i = 0; i < antallKast; i++) {
				int trkast =terning.nextInt(6)+1;
				res[i]=trkast; 	
			}//end for
			return res ;
			}
		}