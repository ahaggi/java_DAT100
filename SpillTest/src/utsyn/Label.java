package utsyn;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Label {

	//add image to an existing JLabel (label has to already be .add()'ed) JLabel name, path to image, position and size:
		public static void addImage(JLabel labelName, String imagePath, int posLeft, int posTop, int width, int height){
			ImageIcon icon = new ImageIcon(imagePath);
			java.awt.Image img = icon.getImage();
			java.awt.Image imgScaled = img.getScaledInstance((MainJframe.scaleWidth(width)), MainJframe.scaleHeight(height), java.awt.Image.SCALE_SMOOTH);
			
			labelName.setIcon(new ImageIcon(imgScaled));
			labelName.setBounds(MainJframe.scaleWidth(posLeft), MainJframe.scaleHeight(posTop), MainJframe.scaleWidth(width), MainJframe.scaleHeight(height));

			labelName.setVisible(true);
		}

		
		public static void sleep(Action name, int miliseconds){
			Timer timer = new Timer(miliseconds, name);
			timer.setInitialDelay(miliseconds);
			timer.setDelay(miliseconds);
			timer.setRepeats(false);
			timer.start();
		}
}
