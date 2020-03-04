package utsyn;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class AlleRomPanel extends JPanel {
	private static final long serialVersionUID = 4160415168184929730L;
	
	private JLabel lblHandling = new JLabel();
	
	private JLabel lblValg1 = new JLabel();
	private JLabel lblValg2 = new JLabel();
	
	private JLabel lblPlayerInventory = new JLabel();
	private JLabel lblRoomInventory = new JLabel();
	private JLabel lblRoomDesc = new JLabel();
	private JLabel lblHealth = new JLabel();
	private JLabel background = new JLabel();
	private JLabel topRight = new JLabel();
	private JLabel topBar = new JLabel();
	private JLabel healthRed = new JLabel();
	private JLabel healthGreen = new JLabel();

	private MainJframe mainJframe;
	
	private Sound description;

	/**	Create the frame. */
	public AlleRomPanel(MainJframe mainJframe) {
		this.mainJframe = mainJframe;
		
	    setBounds(0, 0, MainJframe.scaleWidth(1366), MainJframe.scaleHeight(768));
	    setOpaque(true);
		setBorder(new EmptyBorder(MainJframe.scaleWidth(5), MainJframe.scaleHeight(5), MainJframe.scaleWidth(5), MainJframe.scaleHeight(5)));
		setLayout(null);
		setBackground(SystemColor.menu);

		
		//top menu START;
		Font values = new Font("Arial", Font.BOLD, MainJframe.scaleWidth(16));
		lblHealth.setBounds(73, 0, MainJframe.scaleWidth(360), MainJframe.scaleHeight(63));
		lblHealth.setFont(values);
		add(lblHealth);
		
		topRight.setBounds(629, 0, MainJframe.scaleWidth(683), MainJframe.scaleHeight(63));
		topRight.setFont(values);
		topRight.setHorizontalAlignment(SwingConstants.RIGHT);
		topRight.setText("Enter M for Menu");
		add(topRight);
		
		add(topBar);
		add(healthGreen);
		add(healthRed);
		addTopBar();
		//top menu END - this bit is refreshed on;

		
		lblRoomInventory.setFont(values);
		lblRoomInventory.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblRoomInventory.setBounds(MainJframe.scaleWidth(10), MainJframe.scaleHeight(100), MainJframe.scaleWidth(224), MainJframe.scaleHeight(233));
		add(lblRoomInventory);
		lblRoomInventory.setVerticalAlignment(SwingConstants.TOP);
		lblRoomInventory.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		lblPlayerInventory.setFont(values);
		lblPlayerInventory.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblPlayerInventory.setBounds(MainJframe.scaleWidth(1132), MainJframe.scaleHeight(100), MainJframe.scaleWidth(224), MainJframe.scaleHeight(233));
		add(lblPlayerInventory);
		lblPlayerInventory.setVerticalAlignment(SwingConstants.TOP);
		lblPlayerInventory.setHorizontalAlignment(SwingConstants.CENTER);


		lblRoomDesc.setFont(new Font("Lucida", Font.PLAIN, MainJframe.scaleWidth(18)));
		lblRoomDesc.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblRoomDesc.setBounds(MainJframe.scaleWidth(242), MainJframe.scaleHeight(73), MainJframe.scaleWidth(882), MainJframe.scaleHeight(293));
		add(lblRoomDesc);
		
		
		lblHandling.setFont(new Font("Lucida", Font.PLAIN, MainJframe.scaleWidth(16)));
		lblHandling.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblHandling.setBounds(MainJframe.scaleWidth(10), MainJframe.scaleHeight(377), MainJframe.scaleWidth(1346), MainJframe.scaleHeight(150));
		add(lblHandling);
		
		
		lblValg1.setFont(values);
		lblValg1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblValg1.setBounds(MainJframe.scaleWidth(10), MainJframe.scaleHeight(538), MainJframe.scaleWidth(668), MainJframe.scaleHeight(150));
		add(lblValg1);

		
		lblValg2.setFont(values);
		lblValg2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblValg2.setBounds(MainJframe.scaleWidth(688), MainJframe.scaleHeight(538), MainJframe.scaleWidth(668), MainJframe.scaleHeight(150));
		add(lblValg2);		
		
		
		add(background);
		setVisible(true);
		updateValues();
	}
	
	public void enter(String s){
		mainJframe.getKontroll().enter(s);
		updateValues();
	}	

	public void updateValues(){
		addTopBar();
		setBackground();
		setRoomInventory();
		setPlayerInventory();
		setPlayerHealth();
		setRoomDescription();
		setHandling();
		setValgMeny1();
		setValgMeny2();
		playSound();
	}


		
	public void setRoomInventory(){
		String labelText = String.format("<html><center>%s</center><html>", "<u>In room:</u><br>" + mainJframe.getKontroll().getRoomInventory());
		lblRoomInventory.setText(labelText);
	}
	
	public void setPlayerInventory(){
		String labelText = String.format("<html><center>%s</center><html>", "<u>Inventory:</u><br>" + mainJframe.getKontroll().getPlayerInventory());
		lblPlayerInventory.setText(labelText);
		
	}

	public void setPlayerHealth(){
		lblHealth.setText("Health: " + mainJframe.getKontroll().getPlayerHealth());
	}
	
	public void setRoomDescription(){
		String labelText = String.format("<html><div WIDTH=%d style=\"text-align: center;padding:10;\">%s</div><html>", 870, mainJframe.getKontroll().getRoomDescription());
		lblRoomDesc.setText(labelText);
	}
	
	public void setHandling(){
		String labelText = String.format("<html><div WIDTH=%d style=\"text-align: center;padding:10;\">%s</div><html>", 1340, mainJframe.getKontroll().getHandlingtxt());
		if (mainJframe.getKontroll().getHandlingtxt()==null){	labelText=String.format("<html><div  WIDTH=%d style=\"text-align: center;padding:10;\">%s</div><html>", 1340, "");}
		lblHandling.setText(labelText);

	}

	public void setValgMeny1(){
		String labelText = String.format("<html><div WIDTH=%d style=\"padding-left:40;\">%s</div><html>", 500, mainJframe.getKontroll().getValgMeny1());
		lblValg1.setText(labelText);
	}	
	public void setValgMeny2(){
		String labelText = String.format("<html><div WIDTH=%d style=\"padding-left:40;\">%s</div><html>", 500, mainJframe.getKontroll().getValgMeny2());
		lblValg2.setText(labelText);
	}
	
	public void setBackground(){
		String path = "Textures/Background/" + mainJframe.getKontroll().getLook() + ".png";
		Label.addImage(background, path, 0, 63, 1366, 705);
	}
	
	public void playSound(){
		boolean playedSound = mainJframe.getKontroll().getSoundPlayed();
		if(!playedSound){
			try {
				String path = "Sound/Rooms/" + mainJframe.getKontroll().getLook() + "/s1.wav";
				description = new Sound(path);
				description.play();
			} catch (Exception e) {
				description = new Sound("Sound/Missing.wav");
				description.play();
			}
			mainJframe.getKontroll().setSoundPlayed(true);
		}
	}
	public void stopSound(){
		description.stop();
	}
	
	public void addTopBar(){
		int health = mainJframe.getKontroll().getPlayerHealthINT();	
		Label.addImage(topBar, "Textures/TopBar.png", 0, 0, 1366, 63);
		if(health > 0){	Label.addImage(healthGreen, "Textures/HealthBar.png", 282, 6, (int)(health / (100.0 / 802.0)), 50);
		}else{healthGreen.setVisible(false);}
		Label.addImage(healthRed, "Textures/RedBar.png", 281, 6, 804, 50);
	}
}
