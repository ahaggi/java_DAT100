package utsyn;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Kontroll.Kontroll;
import modell.Combat;
import modell.Memberstatus;

import javax.swing.JTextField;

public class MainJframe extends JFrame {
	private static final long serialVersionUID = 866770805351420122L;
	private JPanel contentPane;
	private GameOverPanel gameOverPanel;
	private SaveloadPanel saveloadPanel;
	private CombatPanel combatPanel;
	private AlleRomPanel alleRomPanel;
	private PrologueCreditsPanel prologueCreditsPanel;
	private Intro intro;
	private JPanel activePanel;
	private JTextField textInputField;
	private Kontroll kontroll;
	private MainJframe mainJframe;


/**
 * Create the frame.
 */
public MainJframe() {
	
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setExtendedState(JFrame.MAXIMIZED_BOTH);
	setTitle("Escape Asylum");
	setIconImage(Toolkit.getDefaultToolkit().getImage("Textures/Icon.png"));

	setUndecorated(true);
	setBounds(0, 0, 1366, 768);
	setVisible(true);
	
	contentPane = new JPanel();
	contentPane.setBackground(Color.WHITE);
	contentPane.setBorder(new EmptyBorder(scaleWidth(5), scaleHeight(5), scaleWidth(5), scaleHeight(5)));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	textInputField = new JTextField();
	textInputField.addActionListener(enter);
	textInputField.setBounds(scaleWidth(483), scaleHeight(720), scaleWidth(400), scaleHeight(20));
	contentPane.add(textInputField);
	textInputField.setColumns(scaleWidth(10));
	
	this.kontroll= null;

	intro = new Intro(this);
	saveloadPanel = new SaveloadPanel(this);


	activePanel=intro;
	contentPane.add(activePanel);
	visTextInputField(false);
	mainJframe=this;
}



public Kontroll getKontroll() {
	return kontroll;
}

public void setKontroll(Kontroll kontroll) {
	this.kontroll = kontroll;
}



public String getTextInputField(){
	return textInputField.getText();
}
public void setTextInputField(){
	 textInputField.setText("");
}
public  void visTextInputField(boolean b){
	 textInputField.setVisible(b);
	 textInputField.requestFocus();
}


public CombatPanel getCombatPanel() {
	return combatPanel;
}

public void setCombatPanel(CombatPanel combatPanel) {
	this.combatPanel = combatPanel;
}

public SaveloadPanel getSaveloadPanel() {
	return saveloadPanel;
}

public void setSaveloadPanel(SaveloadPanel saveloadPanel) {
	this.saveloadPanel = saveloadPanel;
}

public AlleRomPanel getAlleRomPanel() {
	return alleRomPanel;
}

public void setAlleRomPanel(AlleRomPanel alleRomPanel) {
	this.alleRomPanel = alleRomPanel;
}




public static int scaleWidth(double width){
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	int rescale = (int)(width * (double) toolkit.getScreenSize().getWidth()/ 1366);
	return rescale;
}
public static int scaleHeight(double height){
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	int rescale = (int)(height * (double) toolkit.getScreenSize().getHeight()/768);
	return rescale;
}



public GameOverPanel getGameOverPanel() {
	return gameOverPanel;
}

public void setGameOverPanel(GameOverPanel gameOverPanel) {
	this.gameOverPanel = gameOverPanel;
}

public JPanel getActivePanel() {
	return activePanel;
}

public void setActivePanel(JPanel activePanel) {
	this.activePanel = activePanel;
}

public void addGameoverPanel (){
	gameOverPanel=new GameOverPanel(this);
	contentPane.remove(activePanel);
    activePanel=gameOverPanel;
    contentPane.add(activePanel);
	contentPane.revalidate(); // For Java 1.7 or above.
	contentPane.repaint();
    visTextInputField(false);
}
public void addSaveloadPanel (){
	
	if (activePanel instanceof GameOverPanel || activePanel instanceof Intro|| activePanel instanceof PrologueCreditsPanel ) {
		saveloadPanel.setInfo("Typing in 1 or pressing Enter will start a new game...");
	}else{
		saveloadPanel.setInfo("Press Enter to Continue...");
	}

	contentPane.remove(activePanel);
	activePanel=saveloadPanel;
    contentPane.add(activePanel);
	contentPane.revalidate(); // For Java 1.7 or above.
	contentPane.repaint();
    visTextInputField(true);
	setTextInputField();


}

public void addpostActivePanel (){
	if (kontroll.getActiveRoom() instanceof Combat) {
		addCombatPanel();
		}else{
		addAlleRomPanel();
	}

}

public void addCombatPanel(){
	contentPane.remove(activePanel);
	activePanel=combatPanel;
    contentPane.add(activePanel);
	contentPane.revalidate(); // For Java 1.7 or above.
	contentPane.repaint();
    visTextInputField(true);
	combatPanel.updateValues();
	
}

public void addAlleRomPanel(){
	contentPane.remove(activePanel);
    activePanel=alleRomPanel;
    contentPane.add(alleRomPanel);
	contentPane.revalidate(); // For Java 1.7 or above.
	contentPane.repaint();
    visTextInputField(true);
	alleRomPanel.updateValues();
}

public void addProloguePanel(){
	prologueCreditsPanel=new PrologueCreditsPanel(this);
	contentPane.remove(activePanel);
    activePanel=prologueCreditsPanel;
    contentPane.add(prologueCreditsPanel);
	contentPane.revalidate(); // For Java 1.7 or above.
	contentPane.repaint();
    visTextInputField(false);
	prologueCreditsPanel.prologue();
}

public void addCreditsPanel(){
	prologueCreditsPanel=new PrologueCreditsPanel(this);

	contentPane.remove(activePanel);
    activePanel=prologueCreditsPanel;
    contentPane.add(prologueCreditsPanel);
	contentPane.revalidate(); // For Java 1.7 or above.
	contentPane.repaint();
    visTextInputField(false);
	prologueCreditsPanel.credits();
}

public void exit(){
	System.exit(getDefaultCloseOperation());

}

Action enter = new AbstractAction() {
	private static final long serialVersionUID = 4233786907480552811L;
			
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if ("x".compareToIgnoreCase(getTextInputField())==0) {//TODO mÃ¥ fjernes
			System.exit(getDefaultCloseOperation());
		}else if ("m".compareToIgnoreCase(getTextInputField())==0){//TODO mÃ¥ forandres
			addSaveloadPanel();
		}else 
			if (activePanel instanceof SaveloadPanel) {
				saveloadPanel.enter(getTextInputField());
	        	setTextInputField();
			}else if (activePanel instanceof PrologueCreditsPanel) {
		        	prologueCreditsPanel.skip();
					setKontroll(new Kontroll());
					getKontroll().start();
					setAlleRomPanel(new AlleRomPanel(mainJframe));
					setCombatPanel(new CombatPanel(mainJframe));

					addAlleRomPanel();
					setTextInputField();
		}else if (activePanel instanceof AlleRomPanel) {
        	alleRomPanel.stopSound();
        	alleRomPanel.enter(getTextInputField());
        	setTextInputField();
        	if (kontroll.getActiveRoom() instanceof Combat) {addCombatPanel();}
		}else if (activePanel instanceof CombatPanel){
			combatPanel.enter(getTextInputField());
			if (getTextInputField().equals("1")) {
				combatPanel.playerAttacks();
			}else if (getTextInputField().equals("2")) {
				combatPanel.monsterAttacks();
			}
			setTextInputField();

        	if (!( kontroll.getActiveRoom() instanceof Combat)) {addAlleRomPanel();}
		}

		if (kontroll!=null) {

			if (kontroll.checkPlayerIsdead()&&!(getActivePanel() instanceof SaveloadPanel)) {
			addGameoverPanel();
		}else if (kontroll.checkPlayerWon()&&(getActivePanel() instanceof AlleRomPanel)) {
			addCreditsPanel();
//			kontroll.setMemberStatus(Memberstatus.WOKEUP);
		}
		}
	}
};

	
}