package no.hib.dat100;
public class terningkastResultat {

	public  static void skriv(int [] res){

		int antallKast=res.length; //kast så mye som du vil
		int [] analysres= new int [7];
		double Gjennomsnittskast=0;
		int max=0;
		int max2=0;
		int flest=0;
		int flest2=0;
		
		for (int i = 0; i < antallKast; i++) {
			analysres[res[i]]++;
			if(res[i]!=6 && analysres[6]==0){analysres[0]++;}//analysres[0] hvor mange kast det måtte til for å få den første sekseren ;
		   	System.out.print(res[i]+" ");
			if ((i+1)%20==0 || i == antallKast-1 ){System.out.println();}
		}
		
		for (int i = 1; i <= 6; i++) {
			System.out.println("Antall "+i+"-ere:\t"+ analysres[i]);
			Gjennomsnittskast=Gjennomsnittskast+(((double)analysres[i]*i)/antallKast);
			if(max<analysres[i]){max2=max; max=analysres[i]; flest2=flest; flest=i;}
			if(max2<analysres[i]&& flest!=i){max2=analysres[i]; flest2=i;}
		}
		
		System.out.println("antall kast: "+ antallKast);
		System.out.printf("Gjennomsnittskast: %.3f%n", Gjennomsnittskast);
		System.out.println("Antall kast for å få den første 6-eren : "+ analysres[0]);
		System.out.println("Terningverdien  det   var   flest  av  : "+ flest+" ,"+max+" ganger");
		System.out.println("Terningverdien  det var nest flest av  : "+ flest2+" ,"+max2+" ganger");

	


		}


	}


