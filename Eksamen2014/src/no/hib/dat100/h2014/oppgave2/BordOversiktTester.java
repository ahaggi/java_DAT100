package no.hib.dat100.h2014.oppgave2;

public class BordOversiktTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bord[] bt = {new Bord(5,true), new Bord(4,true), new Bord(1,true)};

		BordOversikt bo = new BordOversikt(bt);
		
		System.out.println(bo.antallLedige());
		System.out.println(bo.finnForsteLedige(10));
		System.out.println(bo.finnForsteLedige(3));
		System.out.println(bo.passerBest(10));
		System.out.println(bo.passerBest(3));
		
	}
}
