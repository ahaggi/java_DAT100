package Eks2b;
import java.util.HashMap;

public class KlientFjell {

	public static void main(String[] args) {
		FjellRegister fjellR = new FjellRegister();
				
		// Lese inn data
		fjellR.setteInn();
		fjellR.setteInn();
		fjellR.setteInn();
		fjellR.setteInn();
		fjellR.setteInn();
		
		//Skrive ut 
		fjellR.skrivMap();
		
		//S�ke
		fjellR.soke();
		
		//Endre og skrive ut
		fjellR.endre();
		fjellR.skrivMap();
		
		//Fjerne og skrive ut
		fjellR.fjerne();
		fjellR.skrivMap();
	}
}
/*
 * Oppgi navn p� fjell :a
 
Oppgi h�yden i meter :1
Oppgi navn p� fjell :b
Oppgi h�yden i meter :2
Oppgi navn p� fjell :c
Oppgi h�yden i meter :3
Oppgi navn p� fjell :d
Oppgi h�yden i meter :4
Oppgi navn p� fjell :e
Oppgi h�yden i meter :5

Innholdet i HashMap
a	1 meter
b	2 meter
c	3 meter
d	4 meter
e	5 meter
Oppgi navn p� fjell som skal s�kes etter :d
Fjellet er registert d	d meter
Oppgi navn p� fjell som skal f� ny h�yde :c
Oppgi den nye h�yden i meter :7


Innholdet i HashMap
a	1 meter
b	2 meter
c	7 meter
d	4 meter
e	5 meter
Oppgi navn p� fjell som skal fjernes :
d


Innholdet i HashMap
a	1 meter
b	2 meter
c	7 meter
e	5 meter

Noen virkelige fjell
("Galdh�piggen", 2246)
("Glittertinden", 2465)
("Grytkollen", 1836)
("Midtre Fossafjell", 1708)
("Nordre Fossafjell", 1708)
*/
