package oppgave4;

public class Privatebil extends Kjoretoy{
	private int fodselsnummer;

	public Privatebil(String regnr, int saldo, int fnr){
		super(regnr, saldo);
		fodselsnummer=fnr;
	}
	public boolean passer(){
		super.setSaldo(super.getSaldo()-25);
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

}//end class privatebil
