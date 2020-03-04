package utsyn;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class CombatPanel extends JPanel {
	private static final long serialVersionUID = 4160415168184929730L;
	
	private JLabel lblHandling = new JLabel();
	
	private JLabel lblValg1 = new JLabel();
	
	private JLabel lblRoomDesc = new JLabel();
	private JLabel lblHealth = new JLabel();
	private JLabel lblHealth_1 = new JLabel();
	
	private JLabel monster = new JLabel();
	private JLabel background = new JLabel();
	private JLabel topRight = new JLabel();
	private JLabel topBar = new JLabel();
	private JLabel healthRed = new JLabel();
	private JLabel healthGreen = new JLabel();

	private MainJframe mainJframe;
	
	private Font font = new Font("Tahoma", Font.PLAIN, MainJframe.scaleWidth(15));

	@SuppressWarnings("unused")
	private Sound monsterAttacking = new Sound("Sound/Fail.wav");
	@SuppressWarnings("unused")
	private Sound monsterHurt = new Sound("Sound/Fail.wav");

	/**	Create the frame. */
	public CombatPanel(MainJframe mainJframe) {
		this.mainJframe = mainJframe;
		
	    setBounds(0, 0, MainJframe.scaleWidth(1366), MainJframe.scaleHeight(768));
	    setOpaque(true);
		setBorder(new EmptyBorder(MainJframe.scaleWidth(5), MainJframe.scaleHeight(5), MainJframe.scaleWidth(5), MainJframe.scaleHeight(5)));
		setLayout(null);
		setBackground(SystemColor.gray);

		
		//top menu START;
		Font values = new Font("Arial", Font.BOLD, MainJframe.scaleWidth(12));
		lblHealth.setBounds(MainJframe.scaleWidth(92), 0, MainJframe.scaleWidth(360), MainJframe.scaleHeight(63));
		lblHealth.setFont(values);
		add(lblHealth);
		
		topRight.setBounds(MainJframe.scaleWidth(612), 0, MainJframe.scaleWidth(683), MainJframe.scaleHeight(63));
		topRight.setFont(values);
		topRight.setHorizontalAlignment(SwingConstants.RIGHT);
		topRight.setText("Enter M for Menu");
		add(topRight);
		
		add(topBar);
		add(healthGreen);
		add(healthRed);
		addTopBar();
		//top menu END - this bit is refreshed on;

		add(monster);
		lblHealth.setFont(font);
		lblHealth_1.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblHealth_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblHealth_1.setBounds(MainJframe.scaleWidth(613), MainJframe.scaleHeight(75), MainJframe.scaleWidth(120), MainJframe.scaleHeight(30));
		add(lblHealth_1);
		

		lblRoomDesc.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblRoomDesc.setBounds(MainJframe.scaleWidth(100), MainJframe.scaleHeight(73), MainJframe.scaleWidth(1166), MainJframe.scaleHeight(393));
		add(lblRoomDesc);
		
		
		lblHandling.setFont(new Font("Lucida", Font.PLAIN, MainJframe.scaleWidth(14)));
		lblHandling.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblHandling.setBounds(MainJframe.scaleWidth(90), MainJframe.scaleHeight(476), MainJframe.scaleWidth(1186), MainJframe.scaleHeight(100));
		add(lblHandling);
		
		
		lblValg1.setFont(values);
		lblValg1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblValg1.setBounds(MainJframe.scaleWidth(349), MainJframe.scaleHeight(586), MainJframe.scaleWidth(668), MainJframe.scaleHeight(120));
		add(lblValg1);

		
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
		setPlayerHealth();
		setMonsterHealth();
		setMonsterLook();
		setHandling();
		setValgMeny1();
	}


	public void setPlayerHealth(){
		lblHealth.setText("Health: " + mainJframe.getKontroll().getPlayerHealth());
	}
	public void setMonsterHealth(){
		try{
			int health = Integer.parseInt(mainJframe.getKontroll().getCombatMonsterhealth());
			if(health <= 0){
				lblHealth_1.setText(" Enemy health: DEAD");
				Sound.sound_win.play();
			}else{
				lblHealth_1.setText("  Enemy health: " + mainJframe.getKontroll().getCombatMonsterhealth());
			}
		}catch (Exception e) {
			lblHealth_1.setText("  Enemy health: " + mainJframe.getKontroll().getCombatMonsterhealth());
		}
	}
	
	public void setMonsterLook(){
		String path = "Textures/Monster/"+mainJframe.getKontroll().getMonsterLook()+"1.png"; 
		Label.addImage(monster, path, 200, 0, 966, 520);
	}
	
	public void setHandling(){
		String labelText = String.format("<html><div WIDTH=%d style=\"text-align: center;padding:10;\">%s</div><html>", 1184, mainJframe.getKontroll().getHandlingtxt());
		if (mainJframe.getKontroll().getHandlingtxt()==null){	labelText=String.format("<html><div  WIDTH=%d style=\"text-align: center;padding:10;\">%s</div><html>", 1340, "");}
		lblHandling.setText(labelText);
	}

	public void setValgMeny1(){
		String labelText = String.format("<html><div WIDTH=%d style=\"text-align: center;padding-left:10;\">%s</div><html>", 668, mainJframe.getKontroll().getValgMeny1());
		lblValg1.setText(labelText);
	}

	
	public void setBackground(){
		String path = "Textures/Background/" + mainJframe.getKontroll().getLook() + ".png";
		Label.addImage(background, path, 0, 63, 1366, 705);
	}
	
	public void addTopBar(){
		int health = mainJframe.getKontroll().getPlayerHealthINT();	
		Label.addImage(topBar, "Textures/TopBar.png", 0, 0, 1366, 63);
		if(health > 0){	Label.addImage(healthGreen, "Textures/HealthBar.png", 282, 6, (int)(health / (100.0 / 802.0)), 50);
		}else{healthGreen.setVisible(false);}
		Label.addImage(healthRed, "Textures/RedBar.png", 281, 6, 804, 50);
	}
	
	
	public void playerAttacks(){
		String path = mainJframe.getKontroll().getMonsterLook();
		
		String soundPath = "Sound/Monster/" + path + "Attacking.wav";
		String imgPath =  "Textures/Monster/" + path + "1.png";
		Sound attack1 = new Sound(soundPath);
		attack1.play();
		
		Label.addImage(monster, imgPath, 250, 30, 866, 460);
		Label.sleep(attack, 400);
	}
	public void monsterAttacks(){
		String path = mainJframe.getKontroll().getMonsterLook();
		
		String soundPath2 = "Sound/Monster/" + path + "Hurt.wav";
		String imgPath2 =  "Textures/Monster/" + path + "2.png";
		Sound attack2 = new Sound(soundPath2);
		attack2.play();
		
		Label.addImage(monster, imgPath2, 0, -10, 1366, 768);
		Label.sleep(attack, 400);
	}
	
	private void resetAnim(){
		String path = mainJframe.getKontroll().getMonsterLook();
		String imgPath =  "Textures/Monster/" + path + "1.png";
		Label.addImage(monster, imgPath, 200, 0, 966, 520);
	}
	
	private Action attack = new AbstractAction() {
		private static final long serialVersionUID = 7892201122490351698L;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			resetAnim();
		}
	};
}
