package WayNr2;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Kontroll.Kontroll;

public class AlleRomPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4160415168184929730L;
	private JTextField textInputField;
	private JTextArea lblHandling;
	
	private JTextArea lblValg1;
	private JTextArea lblValg2;
	
	private JTextArea lblPlayerInventory;
	private JTextArea lblRoomInventory;
	private JTextArea lblRoomDesc;
	private JTextArea lblHealth;
	private JTextArea textArea_1;


	private Kontroll kontroll;

	/**
	 * Create the frame.
	 */
	public AlleRomPanel(Kontroll kontroll) {
		this.kontroll = kontroll;
		
	    setBounds(0, 0,1366, 670);
	    setOpaque(true);
	    setBackground(Color.RED);

		
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		textInputField = new JTextField();
		textInputField.addActionListener(enter);
		textInputField.setBounds(450, 630, 400, 20);
		add(textInputField);
		textInputField.setColumns(10);
		
		lblValg1 = new JTextArea();
		lblValg1.setWrapStyleWord(true);
		lblValg1.setBackground(UIManager.getColor("ColorChooser.background"));
		lblValg1.setLineWrap(true);
		lblValg1.setBounds(10, 469, 623, 150);
		add(lblValg1);

		lblValg2 = new JTextArea();
		lblValg2.setWrapStyleWord(true);
		lblValg2.setBackground(UIManager.getColor("ColorChooser.background"));
		lblValg2.setLineWrap(true);
		lblValg2.setBounds(640, 469, 623, 150);
		add(lblValg2);
		
		lblHandling = new JTextArea();
		lblHandling.setBackground(UIManager.getColor("ColorChooser.background"));
		lblHandling.setLineWrap(true);
		lblHandling.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblHandling.setBounds(10, 338, 1264, 120);
		add(lblHandling);
		
		lblPlayerInventory = new JTextArea();
		lblPlayerInventory.setBackground(UIManager.getColor("ColorChooser.background"));
		lblPlayerInventory.setLineWrap(true);
		lblPlayerInventory.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblPlayerInventory.setBounds(1052, 94, 224, 233);
		add(lblPlayerInventory);
		
		lblRoomInventory = new JTextArea();
		lblRoomInventory.setBackground(UIManager.getColor("ColorChooser.background"));
		lblRoomInventory.setLineWrap(true);
		lblRoomInventory.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblRoomInventory.setBounds(10, 94, 224, 233);
		add(lblRoomInventory);
		
		lblRoomDesc = new JTextArea();
		lblRoomDesc.setFont(new Font("Lucida Handwriting", Font.PLAIN, 14));
		lblRoomDesc.setBackground(UIManager.getColor("ColorChooser.background"));
		lblRoomDesc.setLineWrap(true);
		lblRoomDesc.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblRoomDesc.setBounds(242, 67, 800, 260);
		add(lblRoomDesc);
		
		lblHealth = new JTextArea();
		lblHealth.setBackground(UIManager.getColor("ColorChooser.background"));
		lblHealth.setLineWrap(true);
		lblHealth.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblHealth.setBounds(1163, 17, 111, 33);
		add(lblHealth);
		
		textArea_1 = new JTextArea();
		textArea_1.setBackground(UIManager.getColor("ColorChooser.background"));
		textArea_1.setLineWrap(true);
		textArea_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea_1.setBounds(10, 17, 111, 33);
		add(textArea_1);
		
		
		
		setVisible(true);
		
		kontroll.startSpill();
		oppdater();

	}
	
	
	public void oppdater(){
		setTextInputField();
		setRoomInventory();
		setPlayerInventory();
		setPlayerHealth();
		setRoomDescription();
		setHandling();
		setValgMeny1();
		setValgMeny2();
	}

	public String getTextInputField(){
		return textInputField.getText();
	}
	public void setTextInputField(){
		 textInputField.setText("");
	}

		
	public void setRoomInventory(){
		lblRoomInventory.setText(kontroll.getRoomInventory());
	}
	
	public void setPlayerInventory(){
		lblPlayerInventory.setText(kontroll.getPlayerInventory());
		
	}

	public void setPlayerHealth(){
		lblHealth.setText(kontroll.getPlayerHealth());
	}
	
	public void setRoomDescription(){
		lblRoomDesc.setText(kontroll.getRoomDescription());
	}
	
	public void setHandling(){
		lblHandling.setText(kontroll.getHandlingtxt());
	}

	public void setValgMeny1(){
		lblValg1.setText(kontroll.getValgMeny1());
	}	
	public void setValgMeny2(){
		lblValg2.setText(kontroll.getValgMeny2());
	}	
	
	Action enter = new AbstractAction() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 4233786907480552811L;
				
		@Override
		public void actionPerformed(ActionEvent e) {
			kontroll.enter(getTextInputField());
			oppdater();

		}
	};


}
