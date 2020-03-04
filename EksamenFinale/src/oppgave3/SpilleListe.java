package oppgave3;

import java.util.ArrayList;
import java.util.Iterator;

import oppgave3.Sang.Sjanger;

public class SpilleListe{
	private ArrayList <Sang> sanger;

	public SpilleListe(){
		sanger= new ArrayList<Sang>();
	}

	public ArrayList<Sang> getspilleliste() {
		return sanger;
	}

	public void setspilleliste(ArrayList<Sang> sanger) {
		this.sanger = sanger;
	}

	public void leggTil(Sang sang){
		sanger.add(sang);
	}

	public boolean leggTilSjekk(Sang sang){
		boolean b=true;
		for(Sang s:sanger){
			if (s!=null){
				if(s.equals(sang)){
					b=false;
					System.out.println("xxx");

					return b;
				}}
		}
		leggTil(sang);
		return b;
	}


	public void visListe(){
		Iterator <Sang>it = sanger.iterator();
		while(it.hasNext()){
			Sang s=it.next();
			s.skrivUt();
		}
	}


	public ArrayList<Sang> finnSanger(Sjanger sjanger){
		ArrayList <Sang> sListe = new ArrayList <Sang>();
		Iterator <Sang>it = sanger.iterator();
		while(it.hasNext()){
			Sang s=it.next();
			if(s.getSjanger().equals(sjanger)){
				sListe.add(s);
			}
		}
		return sListe;
	}
}