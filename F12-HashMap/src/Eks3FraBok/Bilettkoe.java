package Eks3FraBok;
import java.util.*;
import easyIO.In;


public class Bilettkoe {

	public static void main(String[] args) {
		 final int ANTALL = 5;
		In tastatur = new In();
		
		//Lag personobjekter:
		Person[]personer = new Person[ANTALL];
	    for (int i = 0; i < ANTALL; i++){
	    	personer[i] = new Person();
	    	personer[i].lesData();
	   }
	    
	    //Initaialsierer en bilettkø-ArrayList
	    ArrayList<Person> kø = new ArrayList<Person>();
	    
	    //personene ankommer og stiller seg i køen
	    kø.add(personer[0]);                  //først i køen
	    kø.add(personer[1]);                  //nr 2 i køen
	    kø.add(1, personer[2]);                // ny nr 2 i køen 
	    Person utperson1 = kø.set(2, personer[3]);  // erstatt nr 3
	    kø.add(personer[4]);                  // bakerst i køen
	    Person utperson2 = kø.remove(2);      // fjerner nr 3 i køen, 0...
	    
	    System.out.println();
	    //skriver ut oversikt over køen:
	    System.out.println("Status i køen nå:");
	    for(Person person: kø){
	    	person.skrivData();
	    }
	    
	    System.out.println("Disse står ikke lenger i kø:");
	    utperson1.skrivData();
	    utperson2.skrivData();	        

	}//main

}//class
