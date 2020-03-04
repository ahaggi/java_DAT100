package no.hib.dat100;

import java.util.Random;


public class terningkastRandom {

	public static void main(String[] args) {

		int []res=new int[7];
		Random terning = new Random();
		int antallKast=100; //kast så mye som du vil
		double Gjennomsnittskast=0;
		int max=0;
		int flest=0;
		
		for (int i = 0; i < antallKast; i++) {
		int trkast =terning.nextInt(6)+1;//for å få fom 1 tom 6, hvis (7) fom 0 tom 6
		if(trkast!=6 && res[6]==0){res[0]++;}//res[0] hvor mange kast det måtte til for å få den første sekseren 
		res[trkast]++; 	
		System.out.print(trkast+" ");
		if ((i+1)%20==0){System.out.println();}
		}//end for
		
		System.out.println();
		System.out.println("antall kast: "+ antallKast);
		
		for (int i = 1; i <= 6; i++) {
			System.out.println("Antall "+i+"-ere" + "\t:\t"+ res[i]);
			Gjennomsnittskast=Gjennomsnittskast+(res[i]*i);
			if(max<res[i]){max=res[i]; flest=i;}

		}

		System.out.printf("Gjennomsnittskast: %.3f%n", (Gjennomsnittskast/antallKast));
		System.out.println("Antall kast for å få den første 6-eren : "+ res[0]);
		System.out.println("Terningverdien det var flest av : "+ flest);


	}

}
