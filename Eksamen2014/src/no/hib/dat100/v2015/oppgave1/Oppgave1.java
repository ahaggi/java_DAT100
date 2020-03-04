package no.hib.dat100.v2015.oppgave1;

public class Oppgave1 {

	public Oppgave1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		a();
		b(5);
		System.out.println(c(2));
		System.out.println(c(5));
		
		System.out.println(f("abc", 7));
		
		e();
		
	    }

	public static void a() {

		System.out.println(5 - 3 + 2);
		System.out.println(12 % 4);
		System.out.println(12 / 5);

		String s = new String("abc");
		String t = new String("abc");

		System.out.println(s == t);
		System.out.println(s.equals(t));

	}
	public static void b(int n) {

		for (int i = 0; i < n; i++) {

			for (int j = n - 1 - i; j > 0; j--) {
				System.out.print(".");
			}

			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}

			System.out.println();
		}
	}
	
	public static String c(int kode) {
		
		String svar;

			switch (kode) {
			case 1:
				svar = "kontor";
				break;
			case 2:
				svar = "klasserom";
				break;
			case 3:
				svar = "møterom";
				break;
			case 4:
				svar = "annet";
				break;
			default:
				svar = "ukjent";
			}

			return svar;
		    }

	public static int f(int a, String b) {
		return a - b.length();
	   }

	   public static int f(String a, int b) {
		return a.length() - b;
	   }

	   public static void e() {
			String[] sTab = new String[3];
			sTab[0] = "a";
			sTab[1] = "ab";
			sTab[2] = "abc";

			int totalLengde = 0;
			try {
				for (int i = 0; i <= sTab.length; i++) {
					totalLengde += sTab[i].length();
					System.out.println("Lengde så langt: " + totalLengde);
				}

				System.out.println("Total lengde av strengene: " + totalLengde);

			    } catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Unntak nr 1 kasta.");
			    } catch (NullPointerException e) {
					System.out.println("Unntak nr 2 kasta.");
			    } catch (Exception e) {
				       System.out.println("Unntak nr 3 kasta.");
			    } 
		    }

}
