package no.hib.dat100.miniexcel;

public class Ark {

	int[][] data;

	public Ark(int[][] data) {
		this.data = data;
	}

	public void skrivUt() {

		// TODO
		System.out.println("---------------");

		for (int y = 0; y < data.length; y++) {
			for (int x = 0; x < data[y].length; x++) {
				System.out.print(data[y][x]);
				System.out.print(" ");
			}
			System.out.println();
		}

		System.out.println("---------------");
	}

	public void beregnSum() {

		int ylengde = data.length;
		int sisteyindex = ylengde - 1;

		int xlengde = data[0].length; // antar alle samme lengde og minnst en rad
		int sistexindex = xlengde - 1;

		// summer rekker
		for (int y = 0; y < sisteyindex; y++) {

			int sum = 0;
			for (int x = 0; x < sistexindex; x++) {
				sum = sum + data[y][x];
			}

			data[y][sistexindex] = sum;
		}

		// summer kolonner
		

		for (int x = 0; x < sistexindex; x++) {

			int sum = 0;
			
			for (int y = 0; y < sisteyindex; y++) {
				sum = sum + data[y][x];
			}

			data[sisteyindex][x] = sum;
		}
	}
}
