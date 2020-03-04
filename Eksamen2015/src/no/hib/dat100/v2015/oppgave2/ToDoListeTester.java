package no.hib.dat100.v2015.oppgave2;

public class ToDoListeTester {

	public ToDoListeTester() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ToDoElement element1 = new ToDoElement("Eksamen i DAT100",1,1);
		ToDoElement element2 = new ToDoElement("Kjøpe juletre",2,2);
		
		System.out.print(element1.toString());
		System.out.print(element2.toString());
		
		ToDoListe liste = new ToDoListe(10);
		
		liste.LeggTil(element1);
		liste.LeggTil(element2);
		
		liste.nyPrioritet(1, 3);
		
		System.out.print(liste.finnViktig().toString());
		
		liste.slett(1);
		
		ToDoListe nyliste = liste.merPlass();
		
		nyliste.skrivUt();
	}

}
