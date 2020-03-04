package loop;

public class loop2 {

	public static void main(String[] args) {

/*eller ;)
	    System.out.println("     a");
		System.out.println("    a a");
		System.out.println("   a b a");
		System.out.println("  a c c a");
		System.out.println(" a d f d a"); 
		System.out.println("a a a a a a"); 
 */
		for (int i = 1; i <= 6; i++) {
		       
			for (int k = 1; k <= 6-i; k++) {System.out.print(" ");}
		        	for (int j = 1; j <= (1+(i-1)*2); j++) {
		        		if (j%2==0){System.out.print(" ");}
		        			
		        			else if(i==3 && j==3){
		        				System.out.print("b");}
		        			
		        			else if(i==4 && (j==3||j==5)){
		        				System.out.print("c");}
		        			
		        			else if(i==5 && (j==3||j==7)){
		        				System.out.print("d");}
		        		
		        			else if(i==5 && j==5){
        						System.out.print("f");}
		        		
		        			else{
		        				System.out.print("a");}
		        			
		        		
		        	}//for j
		                           
		 System.out.println("");
		}//for i

 
 	}

}

 
        

	