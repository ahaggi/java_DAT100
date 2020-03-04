package no.hib.dat100.v2015.oppgave3;

public class PinkoderTester {

	public PinkoderTester() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pinkoder pinkoder = new Pinkoder();
		
		pinkoder.registrerPinkode(98765, 1234);
		
		
		System.out.println(pinkoder.sjekkPinkode(98765, 1234));
		System.out.println(pinkoder.sjekkPinkode(98766, 1234));
		System.out.println(pinkoder.sjekkPinkode(98765, 4321));
	}

}
