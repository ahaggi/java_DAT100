package no.hib.dat100;

import easyIO.*;

public class terningkastTest {

	public static void main(String[] args) {
		In tastatur = new In();
		Out skjerm = new Out();
		
		skjerm.out("Tast inn antall ganger terning skal kaste: ");
		int  antall = tastatur.inInt();


		int [] res=terningkast.Random(antall);//kaller klasse-metode terningkast.Random
		terningkastResultat.skriv(res);//kaller klasse-metode terningkastResultat.skrive og sender []res
	}

}
