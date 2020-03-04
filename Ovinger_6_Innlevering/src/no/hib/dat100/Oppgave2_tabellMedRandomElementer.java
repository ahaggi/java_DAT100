package no.hib.dat100;
import easyIO.*;
import java.time.*;
import java.util.Arrays; 
public class Oppgave2_tabellMedRandomElementer {

	public static void main(String[] args) {
		In tastatur = new In();
		Out skjerm =new Out();
		skjerm.out("Tast inn hvor mange elementer det skall være i tabellen: ");
		int tallet = tastatur.inInt();

		double[] ary = new double [tallet];
		for (int i = 0; i < ary.length; i++) {
			ary[i]=Math.random();
		}
		
		Instant start = Instant.now();
		Arrays.parallelSort(ary);
		Instant end = Instant.now();
	    long w = Duration.between(start, end).toMillis();

		System.out.println("Utføringstiden av programmet er: "+w+"ms");
		
	}

}
