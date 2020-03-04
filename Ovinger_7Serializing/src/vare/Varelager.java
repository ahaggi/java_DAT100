package vare;

import java.io.Serializable;

import easyIO.Out;

public class Varelager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5215623689558336946L;
	private Vare [] varer;
	private int antall;


	Varelager() {
		antall=0;
		varer= new Vare [10];//max antall varer
	}
	
	public void leggTil(Vare v) {
		varer[antall]=v;
		antall++;
	}
	
	public double totalPris(){
		double sum=0;
		for (int i = 0; i < antall; i++) {
			sum=sum+varer[i].getPris();
		}
		return sum;
	}
	
	
	
	public void slett(int vareNr) {
			int funnet=finnVare(vareNr);
			if (funnet != 0) {
				if (funnet != antall) {
				varer[funnet-1]=varer[antall-1];
				varer[antall-1]=null;
				System.out.println("Varer Nr "+ vareNr+" er slettet");
				antall--;
				}else {
				varer[antall-1]=null;
				System.out.println("Varer Nr "+ vareNr+" er slettet");
				antall--;
				}
			}else{System.out.println("Varer Nr "+ vareNr+" fins ikke i lageret");}

	}
	
	public int finnVare (int vareNr) {
		int funnet=0;
		for (int i = 0; i < antall&& funnet==0; i++) {
			
			if (varer[i].getVareNr() == vareNr) {
				funnet=i+1;//vil retunere indexen verdi. Derfor "funnet" må være i+1 i tilfelle indeksen er lik null
			}//end if		
			
		}//end for
		return funnet;

	}
	
	public void visAlle(){
		Out skjerm = new Out();
	    skjerm.out("Antall",13,3);
	    skjerm.out("|");
	    skjerm.out("Vare. nr.",13,3);
	    skjerm.out("|");
	    skjerm.out("Vare navn",13,3);
	    skjerm.out("|");
	    skjerm.out("Pris",13,3);
	    skjerm.out("|");
	    skjerm.outln("moms",13,3);
 		skjerm.outln("----------------------------------------------------------------------");
 		for (int i = 0; i < antall; i++) {
 		    skjerm.out(i+1,13,3);
 		    skjerm.out("|");
 		    skjerm.out(varer[i].getVareNr(),13,3);
 		    skjerm.out("|");
 		    skjerm.out(varer[i].getNavn(),13,3);
 		    skjerm.out("|");
 		    skjerm.out(varer[i].getPris(),2,13,3);
 		    skjerm.out("|");
 		    skjerm.out(varer[i].getmoms(),2,13,3);
 		    skjerm.outln("|");
		}
		    skjerm.outln();
	}



}

