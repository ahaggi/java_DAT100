package utsyn;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class Intro extends JPanel {
	private static final long serialVersionUID = 4576148386449149056L;


	private MainJframe mainJframe;
	private  JLabel background = new JLabel();
	private JLabel text = new JLabel();
	public  int introScreen = 0;


	public Intro(MainJframe mainJframe) {
		this.mainJframe = mainJframe;

		getMonitorScaling();
		
	    setBounds(0, 0 , MainJframe.scaleWidth(1366), MainJframe.scaleHeight(768));
	    setOpaque(true);
		setBorder(new EmptyBorder(MainJframe.scaleWidth(416), MainJframe.scaleHeight(5), MainJframe.scaleWidth(5), MainJframe.scaleHeight(5)));
		setLayout(null);

		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setFont(new Font("Lucida", Font.PLAIN, MainJframe.scaleWidth(16)));
		text.setBounds(109, 200, 1148, 200);
		text.setVisible(false);
		add(text);
		
		add(background);
		gameStart();
	}

	
	public  void gameStart(){
		if(introScreen == 0){
			Sound.sound_sweep.play();
			setBackground(Color.white);
			Label.addImage(background, "Textures/Logo.jpg", 127, 84, 1113, 600);
			Label.sleep(intro, 5000);
		}
		else if(introScreen == 1){
			text.setVisible(true);
			text.setText("<html><center>A game by<br><br>Abdella Ahmed Haji, Steffen Hammelow-Berg, Lillian Heggernes,<br>Espen Steinbakk, Bartosz Michal Koscielniak</center></html>");
			Label.addImage(background, "Textures/Creators.png", 109, 359, 1148, 106);
			Label.sleep(intro, 5000);
		}
		else if(introScreen == 2){
			text.setVisible(false);
			Label.addImage(background, "Textures/Logo2.png", 102, 84, 1161, 600);
			Label.sleep(intro, 4000);
		}
		else if(introScreen == 3){
			setBackground(SystemColor.menu);
			introScreen = 0;
			mainJframe.addSaveloadPanel();
		}
	}
	
	 Action intro = new AbstractAction() {
		private static final long serialVersionUID = 7892201124490351698L;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			introScreen++;
			gameStart();
		}
	};
	
	
	private static double widthScale = 1.0;
	private static double heightScale = 1.0;
	private void getMonitorScaling(){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		double screenWidth = ((int) toolkit.getScreenSize().getWidth());
		double screenHeight = ((int) toolkit.getScreenSize().getHeight());
		widthScale = screenWidth / 1366;
		heightScale = screenHeight / 768;
	}
	
	public static int scaleWidth(int width){
		int rescale = (int)(width * widthScale);
		return rescale;
	}
	
	public static int scaleHeight(int height){
		int rescale = (int)(height * heightScale);
		return rescale;
	}
}
