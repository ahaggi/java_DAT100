package no.hib.dat100;

public class K_verdi_klasse {
	
//static int k = 3; // Må være en static-variabel (klassevariabel)// siden metoden som skal bruke den er en klassemetode (static-metode)

	public static void main(String[] args) {// Metoden er static(klassemetode)//System.out.println("statisk variabel:" + k);

	//		System.out.println("c) main: k er:" + k);

			K_verdi_kasse_test t = new K_verdi_kasse_test();
			int k = 2; // Vil ikke bli brukt
			t.skriv();
			System.out.println("c) main: t.ker:" + t.k);
			}
			}
			