package oppgave4;

public class Firmabil extends Kjoretoy{
	private String orgnr;

	public Firmabil(String regnr, int saldo, String onr){
		super(regnr, saldo);
		orgnr=onr;
	}
	public boolean passer(){
		super.setSaldo(super.getSaldo()-15);
		boolean b=(super.getSaldo()>=0);
		return b;
	}

	public int total(Kjoretoy [] kjoretoy){
		int sum=0;
		for(int i=0; i<kjoretoy.length; i++){
			if(kjoretoy[i].getSaldo()<0){
				sum=sum+kjoretoy[i].getSaldo();
			}
		}
		return sum;
	}

}//end klasse firmabil
