package oppgave3;

import java.util.Random;

import easyIO.In;
import easyIO.Out;
import oppgave3.Sang.Sjanger;

public class Oppgave_3_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random r = new Random();
		Out skjerm = new Out();
		In tastatur= new In();
		SpilleListe spl =new SpilleListe();


		String valg="";
		String meny="1-legg til tilfeldlige 20 sanger\n"
				+ "2-legg til en sang.\n"
				+ "3-Vis alle sanger i spillelisten\n"
				+ "4-Vis en spilleliste av en vis sjange: \n";
		do{
			skjerm.out(meny);
			valg=tastatur.inWord();
			String svar="";

			switch (valg) {
			case "1":
				for (int i = 0; i < 20; i++) {
					String nv1="Random "+(i+1);

					int enumsjn=r.nextInt(Sjanger.values().length);
					Sjanger sjn=Sjanger.values()[enumsjn];

					Sang sg=new Sang(nv1,sjn);
					spl.leggTil(sg);
				}


				break;
			case "2":
				skjerm.outln("Tast inn navnet på sangen: ");
				String nv=tastatur.inWord();

				int enumsjn=r.nextInt(Sjanger.values().length);
				Sjanger sjn=Sjanger.ANNENT;

				Sang sg=new Sang(nv,Sjanger.ANNENT);
				if(spl.leggTilSjekk(sg)){
					svar="Sangen "+sg.getNavn()+" har blitt lagt til spilleListen";
				}else{
					svar="Sangen "+sg.getNavn()+" fins fra før i spilleListen";
				}
				System.out.println(svar);
				break;
			case "3":
				spl.visListe();
				break;

			case "4":
				skjerm.outln("1- POP sjange\n"
						+ "2- ROCK sjange\n"
						+ "3-ANNENT sjange\n" );
				SpilleListe sListe=new SpilleListe();
				String valg2=tastatur.inWord();
					switch (valg2) {
					case "1":
						sListe.setspilleliste(spl.finnSanger(Sjanger.POP));
						sListe.visListe();
						break;
					case "2":
						sListe.setspilleliste(spl.finnSanger(Sjanger.ROCK));
						sListe.visListe();
						break;
					case "3":
						sListe.setspilleliste(spl.finnSanger(Sjanger.ANNENT));
						sListe.visListe();
						break;
	
					default:
						break;
					}
				break;

			default:
				break;

			}

		}while(!valg.equals("x"));


	}

}
