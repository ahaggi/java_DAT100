package no.hib.dat100.h2014.oppgave1;

public class Oppgave1b {
	public static int b(int x, int y) {

		while (x != y) {
			System.out.println("x = " + x + ", y = " + y);
			if (x > y) {
				x = x - y;
			} else {
				y = y - x;
			}
		}

		return x;
	}

	public static void main(String[] args) {
		System.out.println(b(28, 12));
	}

}
