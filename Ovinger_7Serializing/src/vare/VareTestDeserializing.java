package vare;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class VareTestDeserializing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Varelager vlager = new Varelager() ;
				
				
				try {
					FileInputStream fileIn = new FileInputStream("vare.ser");
					ObjectInputStream in = new ObjectInputStream(fileIn);

						vlager = (vare.Varelager) in.readObject();//read the first object	
					

					

					in.close();
				} catch (IOException i) {
					i.printStackTrace();
					return;
				} catch (ClassNotFoundException c) {
					System.out.println("Employee class not found");
					c.printStackTrace();
					return;
				}//end try catch

							
				

		
		vlager.visAlle();
		System.out.println("totalPris=  "+vlager.totalPris()); 



		System.out.println("totalPris=  "+vlager.totalPris()); 

		
		
	}


}
