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
	    
	    //Initaialsierer en bilettk�-ArrayList
	    ArrayList<Person> k� = new ArrayList<Person>();
	    
	    //personene ankommer og stiller seg i k�en
	    k�.add(personer[0]);                  //f�rst i k�en
	    k�.add(personer[1]);                  //nr 2 i k�en
	    k�.add(1, personer[2]);                // ny nr 2 i k�en 
	    Person utperson1 = k�.set(2, personer[3]);  // erstatt nr 3
	    k�.add(personer[4]);                  // bakerst i k�en
	    Person utperson2 = k�.remove(2);      // fjerner nr 3 i k�en, 0...
	    
	    System.out.println();
	    //skriver ut oversikt over k�en:
	    System.out.println("Status i k�en n�:");
	    for(Person person: k�){
	    	person.skrivData();
	    }
	    
	    System.out.println("Disse st�r ikke lenger i k�:");
	    utperson1.skrivData();
	    utperson2.skrivData();	        

	}//main

}//class
