package Eks1;
import java.util.HashMap;
import easyIO.In;

public class KlientHashMap {

	public static void main(String[] args) {
		
		In tastatur = new In();
		HashMap<String, Person> personregister = new HashMap<String, Person>();
		
		System.out.print("Antall personer som registereres :");
		int ant = tastatur.inInt();
		
		for(int i = 0; i < ant; i++){
			System.out.println("Antall gjenværende personer " + (ant-i));
			Person person = new Person();
			person.lesData();
			personregister.put(person.getTelefonnr(), person);
		}
		
		//Skriver ut alle personobjektene
		System.out.println("Viser alle personer" + "(ukjent rekkefølge) :");
		
		for(Person person : personregister.values()){
			person.skrivData();
			
		}		
			

	}

}
