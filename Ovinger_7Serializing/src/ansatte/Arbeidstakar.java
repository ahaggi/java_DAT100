package ansatte;

public class Arbeidstakar {

	private String navn;
	private int arbeidstakarNr;
	private double timeløn;
	private double antallTimar;
	private final double arbeidsuke=37.5;
	private double skatteprosent;
	private double overtid;

	public Arbeidstakar() {
		navn = "Ole nordmann";
		arbeidstakarNr=0;
		timeløn=0.0;
		antallTimar=0.0;
		skatteprosent=0.2;
		overtid=finnOvertidsTimar();
	}


	public Arbeidstakar(String n, int arnr, double tl, double at, double sp) {
		navn=n;
		arbeidstakarNr=arnr;
		timeløn=tl;
		antallTimar=at;
		skatteprosent=sp;		
		overtid=finnOvertidsTimar();
	}

	public double finnOvertidsTimar() {
		if (antallTimar>arbeidsuke) {
			overtid=antallTimar-arbeidsuke;
			return overtid;
		}
		overtid=0.0;
		return overtid;
	}

	public double finnBruttoløn() {
		double Bløn;
		if (overtid>0) {
			Bløn=(arbeidsuke*timeløn)+(overtid*timeløn);
			return Bløn;
		}
		Bløn=antallTimar*timeløn;
		return Bløn;
	}

	
	public double finnSkatt() {
		double skatt = finnBruttoløn()* skatteprosent;
		return skatt;
	}

	public double finnNettoløn() {
		double nettoløn = finnBruttoløn()- finnSkatt();
		return nettoløn;
	}

	public void skrivUt() {
		System.out.println("Navn: "+getNavn() +"ArbeidstakarNr: "+getArbeidstakarNr() +", Antall Timar: "+getAntallTimar()+ ", Timeløn: "+ getTimeløn()+ ", Overtid: "+ finnOvertidsTimar()+", Brutto: "+finnBruttoløn()+ ", Skatt: "+ finnSkatt()+ ", Netto: "+ finnNettoløn());
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getArbeidstakarNr() {
		return arbeidstakarNr;
	}

	public void setArbeidstakarNr(int arbeidstakarNr) {
		this.arbeidstakarNr = arbeidstakarNr;
	}

	public double getTimeløn() {
		return timeløn;
	}

	public void setTimeløn(double timeløn) {
		this.timeløn = timeløn;
	}

	public double getAntallTimar() {
		return antallTimar;
	}

	public void setAntallTimar(double antallTimar) {
		this.antallTimar = antallTimar;
	}

	public double getSkatteprosent() {
		return skatteprosent;
	}

	public void setSkatteprosent(double skatteprosent) {
		this.skatteprosent = skatteprosent;
	}

	public double getArbeidsuke() {
		return arbeidsuke;
	}

}
