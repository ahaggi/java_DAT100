package loop;

public class loop {

	public static void main(String[] args) {

		for (int i = 1; i <= 5; i++) {
		       
			for (int k = 1; k <= 5-i; k++) {System.out.print(" ");}
		        	for (int j = 1; j <= (1+(i-1)*2); j++) {
		        		if (j%2==0){System.out.print(" ");}
		        			else{System.out.print(j);}
		        			
		        	}
		                           
		 System.out.println("");
		}
	}

}

        
	
		


/* 1=>9
	    for (int i = 1; i <= 5; i++) {
	       
	        for (int k = 1; k <= 5-i; k++) {System.out.print(" ");}
	        for (int j = 1; j <= (1+(i-1)*2); j++) {System.out.print(j);}
	                           
	        System.out.println("");
	    }

/* 7=>1
	    for (int i = 5; i >= 0; i--) {
	       
	        for (int k = 5-i; k >=0;  k--) {System.out.print(" ");}
	        for (int j = 1; j <= (1+(i-2)*2); j++) {System.out.print(j);}
	                           
	        System.out.println("");
	        }
	    
	    
*/
	