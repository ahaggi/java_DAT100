package ansatte;

import easyIO.In;
import easyIO.Out;

public class ArbeidstakarOversikt {
	private int max;
	private Arbeidstakar [] arbeidstakre;
	private int antall;
	private double totBrutto=0;
	private double totOvertid=0;
	private double HogasteBrutto=0;
	Arbeidstakar ar=null;
	

	
	ArbeidstakarOversikt() {
		antall=0;
		beregnmax();//åpne filen og telle hvor mange linjer det er
		arbeidstakre= new Arbeidstakar [max];//max antall arbeidstakar
	}
	
	public void beregnmax() {
	In fil = new In("register_Arbeidstakar.txt");
	while (!fil.lastItem()) {
	fil.inLine();
	max++;//antall linjer i filen dvs antall arbeidtakre
	}
	}	
	
	
	public void leggTil(Arbeidstakar a) {
		arbeidstakre[antall]=a;
		antall++;
	}
	
	

	public void total (double ot,double bl) {
		totOvertid+=ot;
		totBrutto+=bl;
	}
	
	public void finnHogasteBrutto (Arbeidstakar a) {//regnes ved oversiktig utskrift OPS OPS 
		if (a.finnBruttoløn()>HogasteBrutto) {
			HogasteBrutto=a.finnBruttoløn();
			ar=a;
		}
	}
	
	public Arbeidstakar finnArbeidstakarNavn() {//Søkning ved navn
		In tast = new In();
		Out skjerm = new Out();
	
		skjerm.out("Gi navn på arbeidstakar: ");
		String navn = tast.inLine();
	
		ar = null;
		for (int i = 0; i < antall&& ar==null; i++) {
			if (navn.equals(arbeidstakre[i].getNavn())) {
				ar = arbeidstakre[i];
			}//end if
		}//end for
		return ar;
	}
	
	public int finnArbeidstakarNr() {//Søking ved nr
		In tast = new In();
		Out skjerm = new Out();
	
		skjerm.out("Gi nr på arbeidstakar: ");
		int nr = tast.inInt();
	
		int indx = -1;
		for (int j = 0; j < antall && indx==-1; j++) {
			if (nr ==arbeidstakre[j].getArbeidstakarNr()) {
			indx=j;
			}//end if
		}//end for
		return indx;
	}

	public void  skrivArbeidstakar() {
		ar=finnArbeidstakarNavn();//metode kall
		Out skjerm = new Out();
		if (ar!=null) {
			skjerm.out("Navn: "+ar.getNavn() +", ArbeidstakarNr: "+ar.getArbeidstakarNr());
			skjerm.out(", Antall Timar: "+ar.getAntallTimar(),2);
			skjerm.out(", Timeløn: "+ ar.getTimeløn(),2);
			skjerm.out(", Overtid: "+ ar.finnOvertidsTimar(),2);
			skjerm.out(", Brutto: "+ar.finnBruttoløn(),2);
			skjerm.out(", Skatt: "+ ar.finnSkatt(),2);
			skjerm.outln(", Netto: "+ ar.finnNettoløn(),2);
		}else{
			skjerm.outln("Feil inndata! påkrevd forespørsel kan ikke gjennomføres.");
		}
		skjerm.outln();
	}

	public void slett() {
		int indx =finnArbeidstakarNr();//metode kall
		Out skjerm = new Out();
		if (indx!=-1) {
			if (indx == antall-1) {
				arbeidstakre[indx]=null;
				skjerm.outln("Arbeidstakar er slettet.");
				antall--;
				}else{
				arbeidstakre[indx]=arbeidstakre[antall-1];
				arbeidstakre[antall-1]=null;
				skjerm.outln("Arbeidstakaren er slettet.");
				antall--;
				}
		}else{
			skjerm.outln("Feil inndata! påkrevd forespørsel kan ikke gjennomføres.");
		}
		skjerm.outln(); 
}

	
	public void visAlle(){
		Out skjerm = new Out();
	    skjerm.out("Navn",13,3);
	    skjerm.out("|");
	    skjerm.out("ArTakarNr",9,3);
	    skjerm.out("|");
	    skjerm.out("Ant Timar",9,3);
	    skjerm.out("|");
	    skjerm.out("Timeløn",9,3);
	    skjerm.out("|");
	    skjerm.out("Overtid",9,3);
	    skjerm.out("|");
	    skjerm.out("Brutto",9,3);
	    skjerm.out("|");
	    skjerm.out("Skatt",9,3);
	    skjerm.out("|");
	    skjerm.outln("Netto",9,3);
 		skjerm.outln("------------------------------------------------------------------------------------");
 		for (int i = 0; i < antall; i++) {
 		    skjerm.out(arbeidstakre[i].getNavn(),13,1);
 		    skjerm.out("|");
 		    skjerm.out(arbeidstakre[i].getArbeidstakarNr(),9,3);
 		    skjerm.out("|");
 		    skjerm.out(arbeidstakre[i].getAntallTimar(),2,9,3);
 		    skjerm.out("|");
 		    skjerm.out(arbeidstakre[i].getTimeløn(),2,9,3);
 		    skjerm.out("|");
 		    skjerm.out(arbeidstakre[i].finnOvertidsTimar(),2,9,3);
 		    skjerm.out("|");
 		    skjerm.out(arbeidstakre[i].finnBruttoløn(),2,9,3);
 		    skjerm.out("|");
 		    skjerm.out(arbeidstakre[i].finnSkatt(),2,9,3);
 		    skjerm.out("|");
 		    skjerm.out(arbeidstakre[i].finnNettoløn(),2,9,3);
 		    skjerm.outln("|");
 		    total(arbeidstakre[i].finnOvertidsTimar(), arbeidstakre[i].finnBruttoløn());//metode kall
 		    finnHogasteBrutto(arbeidstakre[i]);//metode kall
		}
		    skjerm.outln();
	 		skjerm.outln("------------------------------------------------------------------------------------");
	 		skjerm.out("Brutto totalt: "+totBrutto);
	 		skjerm.outln(" kr.");
	 		skjerm.out("Overtid totalt: "+totOvertid);
	 		skjerm.outln(" timer.");
	 		skjerm.outln("HogasteBrutto: "+ar.getNavn()+", Bruttoløn: " +ar.finnBruttoløn()+" kr.");
	 		totBrutto=totOvertid=HogasteBrutto=0;//leg merke til at det er v. viktig å sete DE til null
	 		skjerm.outln("------------------------------------------------------------------------------------");
		    skjerm.outln();
	
	}



}

