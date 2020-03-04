package modell;

import javax.swing.SwingUtilities;

import utsyn.MainJframe;


public class Main {

	public static void main(String[] args) {
		// start utsyn (Swing grensesnitt)
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				try {
					new MainJframe();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}

}
