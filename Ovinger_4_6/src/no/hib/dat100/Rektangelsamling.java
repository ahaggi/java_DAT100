package no.hib.dat100;

public class Rektangelsamling {
		private Rektangel[] rs;
		private int antall;
		
		public Rektangelsamling(int maksAntall) {
			rs= new Rektangel[maksAntall];
			antall=0;
		}
		
		public void leggTil(Rektangel r) {
			if (antall<rs.length) {
				rs[antall]=r;
				antall++;			
			}else{
				System.out.println("Ikke mer ledige plasser");
			}
		}
		
		public void visAlle() {
			for (int i = 0; i < antall; i++) {
				rs[i].tegn();
			}
		}

		public int totAreal() {
		int totAreal=0;
		for (int i = 0; i < antall; i++) {
			totAreal=totAreal+rs[i].giAreal();
		}
		return totAreal;
		}
}
