package utsyn;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import easyIO.In;


public class PrologueCreditsPanel extends JPanel {
	private static final long serialVersionUID = 4160415168184929730L;

	private JLabel proText = new JLabel();
	private JLabel proSkip = new JLabel();
	private JLabel proImg = new JLabel();
	private JLabel creText = new JLabel();
	private JLabel creImg = new JLabel();

	private MainJframe mainJframe;
	
	private StringBuilder string = new StringBuilder();

	private Sound p1 = new Sound("Sound/Rooms/PRO/p1.wav");
	private Sound p2 = new Sound("Sound/Rooms/PRO/p2.wav");
	private Sound p3 = new Sound("Sound/Rooms/PRO/p3.wav");
	private Sound p4 = new Sound("Sound/Rooms/PRO/p4.wav");
	private Sound p5 = new Sound("Sound/Rooms/PRO/p5.wav");
	private Sound p6 = new Sound("Sound/Rooms/PRO/p6.wav");

	
	/**	Create the frame. */
	public PrologueCreditsPanel(MainJframe mainJframe) {
		this.mainJframe = mainJframe;
		
	    setBounds(0, 0, MainJframe.scaleWidth(1366), MainJframe.scaleHeight(768));
	    setOpaque(true);
		setBorder(new EmptyBorder(MainJframe.scaleWidth(5), MainJframe.scaleHeight(5), MainJframe.scaleWidth(5), MainJframe.scaleHeight(5)));
		setLayout(null);
		setBackground(SystemColor.BLACK);

		
		add(proImg);
		
		proSkip.setFont(new Font("Lucida", Font.PLAIN, MainJframe.scaleWidth(10)));
		proSkip.setForeground(Color.WHITE);
		proSkip.setText("To Skip the Prologue press Return (Enter)...");
		proSkip.setHorizontalAlignment(SwingConstants.CENTER);
		proSkip.setBounds(MainJframe.scaleWidth(0), MainJframe.scaleHeight(700), MainJframe.scaleWidth(1366), MainJframe.scaleHeight(20));
		add(proSkip);
		
		proText.setFont(new Font("Lucida", Font.PLAIN, MainJframe.scaleWidth(21)));
		proText.setVerticalAlignment(SwingConstants.TOP);
		proText.setHorizontalAlignment(SwingConstants.CENTER);
		proText.setBounds(MainJframe.scaleWidth(0), MainJframe.scaleHeight(0), MainJframe.scaleWidth(1366), MainJframe.scaleHeight(768));
		add(proText);
		
		add(creImg);
		
		creText.setFont(new Font("Lucida", Font.PLAIN, MainJframe.scaleWidth(16)));
		creText.setHorizontalAlignment(SwingConstants.CENTER);
		creText.setBounds(MainJframe.scaleWidth(0), MainJframe.scaleHeight(0), MainJframe.scaleWidth(1366), MainJframe.scaleHeight(768));
		add(creText);
		
		setVisible(true);
	}
	
	
	
	public void enter(String s){
		mainJframe.getKontroll().enter(s);
	}
	
	public void skip(){
		p1.stop(); p2.stop(); p3.stop(); p4.stop(); p5.stop(); p6.stop(); Sound.sound_rain.stop();
		proScreen = -2;
	}
	
	private int proScreen = 0;
	public void prologue(){
		proImg.setVisible(true); proSkip.setVisible(true); proText.setVisible(true); creImg.setVisible(false); creText.setVisible(false);
			proText.setForeground(Color.WHITE);
			
			if(proScreen == -1){
				proScreen = 0;
			}
			else if(proScreen == 0 || proScreen == -2){
				proScreen = 0;
				mainJframe.visTextInputField(true);
				Sound.sound_rain.play();
				p1.play();
				
				readFileLines("Text/Intro.txt", 0, 1);	sendText(proText);	Label.sleep(pro, 3000);
			}
			else if(proScreen == 1){
				setBackground(Color.WHITE);									Label.sleep(pro, 800);
			}
			else if(proScreen == 2){
				p2.play();
				setBackground(Color.BLACK);
				readFileLines("Text/Intro.txt", 1, 3);	sendText(proText);	Label.sleep(pro, 5500);
			}
			else if(proScreen == 3){
				p3.play();
				readFileLines("Text/Intro.txt", 1, 8);	sendText(proText);	Label.sleep(pro, 28000);
			}
			else if(proScreen == 4){
				p4.play();
				readFileLines("Text/Intro.txt", 1, 13);	sendText(proText);	Label.sleep(pro, 20000);
			}
			else if(proScreen == 5){
				p5.play();
				readFileLines("Text/Intro.txt", 1, 16);	sendText(proText);	Label.sleep(pro, 8000);
			}
			else if(proScreen == 6){
				p6.play();
				readFileLines("Text/Intro.txt", 1, 19);	sendText(proText);	Label.sleep(pro, 4500);
			}
			else if(proScreen == 7){
				Sound.sound_rain.stop();
				setBackground(Color.WHITE);
				Label.sleep(pro, 200);
			}
			else if(proScreen == 8){
				Sound.sound_thunder.play();
				proSkip.setVisible(false);
				setBackground(Color.BLACK);
				readFileLines("Text/Intro.txt", 1, 22);	sendText(proText);
				
				Label.addImage(proImg, "Textures/IntroLogo.png", 261, 506, 845, 106);
			
				proScreen = 0;
			}
	}
	
	private Action pro = new AbstractAction() {
		private static final long serialVersionUID = 7892201124490351698L;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			proScreen++;
			prologue();
		}
	};
	
	
	private int line = -1;
	private int yAxis = 2140;
	public void credits(){
		proImg.setVisible(false); proSkip.setVisible(false); proText.setVisible(false); creImg.setVisible(true); creText.setVisible(true);
		setBackground(SystemColor.BLACK);
		creText.setForeground(Color.WHITE);
		mainJframe.visTextInputField(false);
		
			if(line == -1){
				Label.sleep(scroll, 8000);
				Sound.sound_win.play();
				creText.setText("<html><center><font size='40'>Congratulations!<br><br><br>You have Escaped the Asylum!<br><br>Thank you for playing!</font></center></html>");				
			}
			else if(line == 109){
				line = -1;
				yAxis = 2140;
				setBackground(SystemColor.menu);
				mainJframe.addSaveloadPanel();//Gå automatisk til menyen
				mainJframe.visTextInputField(true);
			}
			else if(line < 110){
				Label.sleep(scroll, 500);
				skipLines(110 - line);
				readFileLines("Text/Outro.txt", 1, 17);
				skipLines(line + 10);
				sendText(creText);
				
				Label.addImage(creImg, "Textures/Creators.png", 200, yAxis, 966, 100);
			}
			
	}
		
	private Action scroll = new AbstractAction() {
			private static final long serialVersionUID = 7892201122490351698L;
			@Override
			public void actionPerformed(ActionEvent arg0) {
				line++;
				yAxis = yAxis - 26;
				credits();
			}
		};
	
		
		
	private void sendText(JLabel name){
		name.setText("<html>" + string.toString() + "</html>");
		string.delete(0, string.length());
	}
	
	private void readFileLines(String fileName, int startLine, int endLine){
		int lines = (endLine - startLine + 1);
		In file = new In(fileName);
		
		for (int i = 0; i < (startLine - 1); i++) {
			file.readLine();
		}
		for (int i = 0; i < lines; i++) {
			string.append(file.readLine());
		}
		file.close();
	}
	
	private void skipLines(int number){
		for (int i = 0; i < number; i++) {
			string.append("<br>");
		}
	}
}
