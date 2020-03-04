package no.hib.dat100.h2014.oppgave1;

public class Oppgave1d {

	public static double f(int a, double b) {
		return a - b;
	}

	public static double f(double a, int b) {
		return a + b;
	}

	public static void main(String[] args) {
		System.out.println(f(4.0, 7));
	}

}
