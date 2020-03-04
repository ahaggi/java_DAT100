package oppgave1;

public class D {


	public static void metode1(int x){
		if (x<0) {
			throw new ArithmeticException("X er neg.");
		}else{
			System.out.print(x+" ");
		}

	}

	public static void metode2(){
		int[] tab ={0,1,-1,2,3,};
		int x=0;
		try {
			for (int i = 0; i < tab.length; i++) {
				x=i;
				metode1(tab[i]);
			}

		} catch (ArithmeticException e) {
			System.out.println();
			System.out.println(tab[x]);
		} finally {
			System.out.println("x = "+x);
		}


	}
	public static void main(String[] args) {
		metode2();
	}

}
