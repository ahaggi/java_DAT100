package oppgave5;

import java.util.Random;
import easyIO.*;


public class Graf{

	private boolean [][] nabomatrise;

	public Graf(int k, int l){
		nabomatrise = new boolean [k][l];
	}

	//som fra ....

	public boolean erNaboer(int u, int w){
		return (nabomatrise[u][w]);
	}

	public int grad (int v){
		int grd=0;
		for(boolean br:nabomatrise[v]){
			if(br){grd++;}
		}
		return grd;
	}


	public boolean regular(int k){
		boolean b=true;
		int i=0;
		while (b && i<nabomatrise.length){
			b=(k==grad(i));
			i++;
		}
		return b;
	}

	public boolean klikk(int [] s){
		boolean b=true;
		for(int i=0; i<s.length&& b ; i++){
			for(int j=i+1; j<s.length && b ; j++){
				b=(erNaboer(s[i],s[j]));
			}
		}
		return b;
	}


	static public void main(String[] args) {
		Random r = new Random();
		Graf g=new Graf(4, 4);
		Out skjerm = new Out();
		In tastatur= new In();
		for (int i=0; i<g.nabomatrise.length;i++){
			for (int j = 0; j <=i; j++) {
				g.nabomatrise[i][j]=r.nextBoolean();
				g.nabomatrise[j][i]=g.nabomatrise[i][j];
			}
		}

		for (boolean [] bb : g.nabomatrise) {
			for (boolean b : bb) {
				skjerm.out(""+b,10,3);
			}
			System.out.println("");
		}	

		String valg="";
		String meny="1-Sjekk om to noder er naboer.\n"
				+ "2-Finn antall naboer til en node.\n"
				+ "3-Er grafen ragulær?\n"
				+ "4-sjekk om en mengde noder er i klikken?\n";
		do{
			skjerm.out(meny);
			valg=tastatur.inWord();
			String svar="";
			switch (valg) {
			case "1":
				skjerm.outln("Tast inn 2 hel tall: ");
				int a=tastatur.inInt();
				int c=tastatur.inInt();
				if (g.erNaboer(a-1, c-1)) {
					svar="naboer";
				}else{
					svar="ikke naboer";
				}
				System.out.println("node nr"+(a)+" "+"node nr"+(c)+" er "+svar);
				break;
			case "2":
				skjerm.outln("Tast inn nodes nr \"hel tall\": ");
				int w=tastatur.inInt();
				int grd=g.grad(w-1);
				System.out.println("node nr"+(w)+" "+", har grad "+grd);

				break;
			case "3":
				skjerm.outln("Tast inn tallet på degree \"hel tall\": ");
				int e=tastatur.inInt();
				if (g.regular(e)) {
					svar="er regulær som har "+e+". degree";
				}else{
					svar="er ikke "+e+". degree";
				}
				System.out.println("Grafen "+svar);
				break;
			case "4":
				skjerm.outln("Tast inn tallet på noder \"hel tall\": ");
				int taletpaatab=tastatur.inInt();
				int [] meng= new int[taletpaatab];
				skjerm.outln("Tast inn nodenes-nr \"hel tall\": ");
				for (int i = 0; i < meng.length; i++) {
					meng[i]=tastatur.inInt()-1;
				}
				if (g.klikk(meng)) {
					svar="en klikk";
				}else{
					svar="ikke en klikk";
				}
				System.out.println("Nodene er "+svar);


				break;

			default:
				break;

			}

		}while(!valg.equals("x"));

	}


}