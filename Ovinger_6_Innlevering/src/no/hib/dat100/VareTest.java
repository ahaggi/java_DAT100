package no.hib.dat100;

public class VareTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Vare v1 = new Vare();
		Vare v2 = new Vare(11, "Melk" ,29.5);
		Vare v3 = new Vare(12, "Tomat" ,29.5);
		
		System.out.println("Moms på "+v1.getNavn()+ " er: kr"+v1.getmoms());
		System.out.println("Moms på "+v3.getNavn()+ " er: kr"+v3.getmoms());
		
		if (v2.erBilligereEnn(v3)){
			System.out.println(v2.getNavn()+" er billigere enn "+ v3.getNavn());
		}else if(v3.erBilligereEnn(v2)){
			System.out.println(v3.getNavn()+" er billigere enn "+ v2.getNavn());
		}else {
		System.out.println(v3.getNavn()+" og "+ v2.getNavn()+" har den samme pris");
		}
		System.out.println();
		v3.skriv();
		
	}

}
