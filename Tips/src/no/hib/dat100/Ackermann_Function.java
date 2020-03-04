package no.hib.dat100;

import java.time.Duration;
import java.time.Instant;

public class Ackermann_Function {
	
	public static void main(String[] args) {
		Ackermann_Function ackermann=new Ackermann_Function();
		for (int i=0; i<5; i++)
			for (int j=0;j<6; j++){
				Instant start = Instant.now();
				System.out.print("ackerman of "+i+","+j+ " is: "+ ackermann.ack(i,j));
				Instant end = Instant.now();
			    long w = Duration.between(start, end).toMillis();
			    System.out.println(",  Prosesseringstid er: "+w+"\n *************************************");
			}
	}

	

	public int ack(int m,int n){
	int ans;
	if (m == 0) ans = n+1;
	else if (n == 0) ans = ack(m-1,1);
	else ans = ack(m-1, ack(m,n-1));
	return (ans);
	}

}
