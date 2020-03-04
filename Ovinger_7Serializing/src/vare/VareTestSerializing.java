package vare;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import easyIO.*;

public class VareTestSerializing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Varelager vlager = new Varelager() ;
		In fil = new In("register_Varer.txt");


			while (!fil.lastItem()) {
				int vareNr = fil.inInt();
				String vareNavn = fil.inWord();
				double pris = fil.inDouble();
				
				Vare v = new Vare(vareNr,vareNavn,pris);
				vlager.leggTil(v);
				
			}// while

			
			  try
		      {
		         FileOutputStream fileOut = new FileOutputStream("vare.ser");
		         ObjectOutputStream out = new ObjectOutputStream(fileOut);
		         out.writeObject(vlager);
		         out.close();
		         fileOut.close();
		         System.out.println("Serialized data is saved in vare.ser");
		      }catch(IOException i)
		      {
		          i.printStackTrace();
		      }

			
		
		vlager.visAlle();
		System.out.println("totalPris=  "+vlager.totalPris()); 

		vlager.slett(1);
		vlager.visAlle();


		System.out.println("totalPris=  "+vlager.totalPris()); 

		
		
	}


}
