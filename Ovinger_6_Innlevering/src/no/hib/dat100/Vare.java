package no.hib.dat100;
 

public class Vare {
	
	private int vareNr;
	private String navn;
	private double pris; 

	Vare() {
		vareNr=0;
		navn = "uten navn";
		pris = 0.0;
	}
	Vare(int vnr, String nv, double p) {
		vareNr=vnr;
		navn = nv;
		pris = p;
	}

	public double getmoms() {
		return pris*0.2;
	}
	
	public boolean erBilligereEnn(Vare v) {
		
		if (pris<v.getPris()){//
			return true;
		}else{
			return false;
		}
	}
	
	public void skriv(){
		System.out.println("Vare nr:"+vareNr +" ,Navn: "+navn+ " ,Pris "+ pris+ " "+" mos:"+ getmoms());
	}

	
	
	public int getVareNr() {
		return vareNr;
	}
	public void setVareNr(int vareNr) {
		this.vareNr = vareNr;
	}
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	public double getPris() {
		return pris;
	}
	public void setPris(double pris) {
		this.pris = pris;
	}

	
	
}
