package utsyn;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Kontroll.Kontroll;


public class SaveloadPanel extends JPanel {
	private static final long serialVersionUID = 4160415168184929730L;

	private JLabel newGame = new JLabel();
	private JLabel save = new JLabel();
	private JLabel load = new JLabel();
	private JLabel exit = new JLabel();
	private JLabel info = new JLabel();
	private JLabel logo = new JLabel();
	private JLabel background = new JLabel();

	private MainJframe mainJframe;
	
	private Font font = new Font("Tahoma", Font.PLAIN, MainJframe.scaleWidth(15));

	/**
	 * Create the frame.
	 */
	public SaveloadPanel(MainJframe mainJframe) {
		this.mainJframe = mainJframe;
		
	    setBounds(0, 0,MainJframe.scaleWidth(1366), MainJframe.scaleWidth(768));
	    setOpaque(true);
		setBorder(new EmptyBorder(MainJframe.scaleWidth(5), MainJframe.scaleHeight(5), MainJframe.scaleWidth(5), MainJframe.scaleHeight(5)));
		setLayout(null);
		setBackground(Color.WHITE);


		newGame.setFont(font);
		newGame.setHorizontalTextPosition(SwingConstants.CENTER);
		newGame.setHorizontalAlignment(SwingConstants.CENTER);
		newGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		newGame.setText("Enter '1' for New Game.");
		newGame.setBorder(new LineBorder(new Color(0, 0, 0)));
		newGame.setBounds(MainJframe.scaleWidth(349), MainJframe.scaleHeight(470), MainJframe.scaleWidth(324), MainJframe.scaleHeight(58));
		add(newGame);
		
		save.setText("Enter '2' to Save.");
		save.setHorizontalTextPosition(SwingConstants.CENTER);
		save.setHorizontalAlignment(SwingConstants.CENTER);
		save.setFont(font);
		save.setBorder(new LineBorder(new Color(0, 0, 0)));
		save.setAlignmentX(0.5f);
		save.setBounds(MainJframe.scaleWidth(693), MainJframe.scaleHeight(470), MainJframe.scaleWidth(324), MainJframe.scaleHeight(58));
		add(save);
		
		load.setFont(font);
		load.setHorizontalAlignment(SwingConstants.CENTER);
		load.setHorizontalTextPosition(SwingConstants.CENTER);
		load.setAlignmentX(Component.CENTER_ALIGNMENT);
		load.setText("Enter '3' to Load.");
		load.setBorder(new LineBorder(new Color(0, 0, 0)));
		load.setBounds(MainJframe.scaleWidth(349), MainJframe.scaleHeight(550), MainJframe.scaleWidth(324), MainJframe.scaleHeight(58));
		add(load);
		
		exit.setFont(font);
		exit.setHorizontalAlignment(SwingConstants.CENTER);
		exit.setHorizontalTextPosition(SwingConstants.CENTER);
		exit.setAlignmentX(Component.CENTER_ALIGNMENT);
		exit.setText("Enter '4' to Leave the Game.");
		exit.setBorder(new LineBorder(new Color(0, 0, 0)));
		exit.setBounds(MainJframe.scaleWidth(693), MainJframe.scaleHeight(550), MainJframe.scaleWidth(324), MainJframe.scaleHeight(58));
		add(exit);
		
		info.setFont(font);
		info.setHorizontalAlignment(SwingConstants.CENTER);
		info.setHorizontalTextPosition(SwingConstants.CENTER);
		info.setAlignmentX(Component.CENTER_ALIGNMENT);
		info.setText("Press Enter to go back...");
		info.setBorder(new LineBorder(new Color(0, 0, 0)));
		info.setBounds(MainJframe.scaleWidth(424), MainJframe.scaleHeight(650), MainJframe.scaleWidth(518), MainJframe.scaleHeight(35));
		add(info);
		
		add(logo);
		add(background);
		setLogoBackground();
		
		setVisible(true);
	}
	
	public void setnewGame(String labelText){
		newGame.setText(labelText);
	}
	public String  getnewGame(){
		return newGame.getText();
	}
	public void setSave(String labelText){
		save.setText(labelText);
	}
	public String  getSave(){
		return save.getText();
	}
		
	public void setLoad(String labelText){
		load.setText(labelText);
	}
	public String  getSaveLoad(){
		return load.getText();
	}
	public void setExit(String labelText){
		exit.setText(labelText);
	}
	public String  getExit(){
		return exit.getText();
	}
	public void setInfo(String text){
		String labelText = String.format("<html><div style=\"text-align: center;\">%s</div><html>", text);

		info.setText(labelText);
	}
	public String  getInfo(){
		return info.getText();
	}

	
	public void enter(String valg){
		switch (valg) {
		case "1":
			mainJframe.addProloguePanel();
			break;
			
		case "2":
			if (mainJframe.getKontroll()!=null) {
			  try{
		         FileOutputStream fileOut = new FileOutputStream("saveLoad.ser");
		         ObjectOutputStream out = new ObjectOutputStream(fileOut);
		         out.writeObject(mainJframe.getKontroll());
		         out.close();
		         fileOut.close();
		         setInfo("Gamedata is saved in 'saveLoad.ser'.<br>Press Enter to Continue...");
				 mainJframe.setTextInputField();
		      }catch(IOException i){
					setInfo(" IOException");
					i.printStackTrace();
					return;
		      }
			}else{
		         setInfo("Gamedata is not saved <br>Typing in 1 or pressing Enter will start a new game...");
			}

			break;
			
		case "3":
			//den delen er nÃ¸dvendig i tilfellet spilleren vil gjenopprette et tidligere laget spill fÃ¸r spillet blir opprettet
			
			//loading previously saved data
			try {
				FileInputStream fileIn = new FileInputStream("saveLoad.ser");
				ObjectInputStream in = new ObjectInputStream(fileIn);
				String msg="";
				
				if (mainJframe.getAlleRomPanel()!=null) {
					mainJframe.setKontroll((Kontroll) in.readObject());//loading fil
					msg="Gamedata has been loaded from 'saveLoad.ser'.<br>Press Enter to Continue...";
				}else{
					msg="Gamedata is not loaded <br>Typing in 1 or pressing Enter will start a new game...";

				}

				fileIn.close();
				in.close();
				setInfo(msg);
				mainJframe.setTextInputField();
				
			} catch (IOException i) {
				i.printStackTrace();
				return;
			} catch (ClassNotFoundException c) {
				setInfo(" class not found");
				c.printStackTrace();
				return;
			}//end try catch
			break;
			
		case "":

				if (getInfo().endsWith("Typing in 1 or pressing Enter will start a new game...</div><html>")) {
					mainJframe.addProloguePanel();
				}else if (getInfo().endsWith("Press Enter to Continue...</div><html>")) {
					mainJframe.addpostActivePanel();
			}
			break;
			
		case "4":
			mainJframe.exit();
			break;
		default:
			break;
		}
	}
	
	private void setLogoBackground(){
		Label.addImage(logo, "Textures/Logo.jpg", 300, 70, 766, 350);
		Label.addImage(background, "Textures/Background/MENU.png", 0, 0, 1366, 768);
	}
}
