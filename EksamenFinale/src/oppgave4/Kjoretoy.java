package oppgave4;

public abstract class Kjoretoy{
	private String regnr;
	private int saldo;

	public Kjoretoy (String regnr, int saldo){
		this.regnr=regnr;
		this.saldo=saldo;
	}

	public String getRegnr(){
		return regnr;
	}
	public void setRegnr(String s){
		regnr=s;
	}
	public int getSaldo(){
		return saldo;
	}
	public void setSaldo(int s){
		saldo=s;
	}

	public void betal(int belop){
		saldo=saldo+belop;
	}

	public abstract boolean passer();
}//end Kjoretoy
