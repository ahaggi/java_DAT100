package no.hib.dat100.h2014.oppgave5;

public class LoginTester {

	static boolean[][] m1 =
		{ { true, false, false }, 
		  { true, true, true }, 
		  { false, false, true } };
	
	static boolean[][] m2 =
		{ { true, false, false }, 
		  { true, true, false }, 
		  { false, true, true } };
	
	public static void p (Object o) {
		System.out.println(o);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Login login = new Login();

		p(login.erMed(0, 0));
		p(login.erMed(0, 1));
		login.skrivUt();
		
		p(login.sjekkMonsterWhile(m1));
		
		p(login.sjekkMonsterWhile(m2));
		
		p(login.sjekkMonsterFor(m1));
		
		p(login.sjekkMonsterFor(m2));
	}
}
