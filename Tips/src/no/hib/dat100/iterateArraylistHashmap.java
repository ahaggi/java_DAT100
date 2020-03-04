package no.hib.dat100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;


public class iterateArraylistHashmap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="0";
		int in=Integer.valueOf(a);
		double db=Double.valueOf(a);
		System.out.println(in);
		System.out.println(db);
		
		
             /********************iterate through arraylist*********************************/  //TODO
		// create list
		ArrayList<String> CrunchifyList = new ArrayList<String>();//legg merke til ()
 
		// add 4 different values to list
		CrunchifyList.add("eBay");
		CrunchifyList.add("Paypal");
		CrunchifyList.add("Google");
		CrunchifyList.add("Yahoo");
 
		// iterate via "for loop"
		System.out.println("==> For Loop Example.");
		for (int i = 0; i < CrunchifyList.size(); i++) {
			System.out.println(CrunchifyList.get(i));
		}
 
		// iterate via "New way to loop"
		System.out.println("\n==> Advance For Loop Example..");
		for (String temp : CrunchifyList) {
			System.out.println(temp);
		}
 
		// iterate via "iterator loop"
		System.out.println("\n==> Iterator Example...");
		Iterator<String> CrunchifyIterator = CrunchifyList.iterator();  // 3 metoder .iterator() .hasNext() .Next()
		while (CrunchifyIterator.hasNext()) {
			System.out.println(CrunchifyIterator.next());
		}
 
		// iterate via "while loop"
		System.out.println("\n==> While Loop Example....");
		int i = 0;
		while (i < CrunchifyList.size()) {
			System.out.println(CrunchifyList.get(i));
			i++;
		}
 
		// collection stream() util: Returns a sequential Stream with this collection as its source
		System.out.println("\n==> collection stream() util....");
		CrunchifyList.stream().forEach((temp) -> {
			System.out.println(temp);
		});
		
		
		
        /**********************iterate through hashmap*******************************/ //TODO

		
		
		
		HashMap<String, Integer> testHashmap  = new HashMap<String, Integer>();//legg marke til ()
		for(int n=0;n<10;n++){
			testHashmap.put((String.valueOf(n)), n);
			//elternative 2			testHashmap.put(""+n, n);
			
			 //elternative 3			testHashmap.put(n.toSting , n); //itilfelle n vert Integer ikke int dvs objektveriabel
		}
		
		for (int s : testHashmap.values()) {
			System.out.print(s+" ");
		}
		
		System.out.println();
		
		//eller
		
		for(int h=0; h<10; h++){
			int temp=testHashmap.get(""+h);
			System.out.print(temp);
		}
		
		//eller
		
		String [] nokler= new String [testHashmap.size()]; 

		int l=0;
		for (String s:testHashmap.keySet()) {
			nokler[l]=s;
			l++;
		}
		Arrays.parallelSort(nokler);
		for(int f=0; f<10; f++){
			int tempo=testHashmap.get(""+f);
			System.out.print(tempo);
		}

		
     	}

}
