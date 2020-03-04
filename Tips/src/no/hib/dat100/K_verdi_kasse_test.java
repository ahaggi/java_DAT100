package no.hib.dat100;

public class K_verdi_kasse_test {

		int k = 1;
		
		public void skriv() {// Objektmetode
		System.out.println("a) verdien av t.k:" + k);
		int k = 4; //skriv methode sin k
		System.out.println("b) verdien av k:" + k);
		System.out.println("b) verdien av k:" + this.k);

		}

}
