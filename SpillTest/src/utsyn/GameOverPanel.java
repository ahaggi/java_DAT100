package utsyn;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class GameOverPanel extends JPanel {
	private static final long serialVersionUID = 4160415168184929730L;

	
	private JLabel info;

	private MainJframe mainJframe;

	/**
	 * Create the frame.
	 */
	public GameOverPanel(MainJframe mainJframe) {
		this.mainJframe = mainJframe;
		
	    setBounds(0, 0, MainJframe.scaleWidth(1366), MainJframe.scaleHeight(768));
	    setOpaque(true);
		setBorder(new EmptyBorder(MainJframe.scaleWidth(5), MainJframe.scaleHeight(5), MainJframe.scaleWidth(5), MainJframe.scaleHeight(5)));
		setLayout(null);
		setBackground(Color.BLACK);


		
		info = new JLabel();
		info.setBackground(new Color(0, 0, 0));
		info.setForeground(Color.WHITE);
		info.setFont(new Font("Tahoma", Font.BOLD, MainJframe.scaleWidth(24)));
		info.setHorizontalAlignment(SwingConstants.CENTER);
		info.setHorizontalTextPosition(SwingConstants.CENTER);
		info.setAlignmentX(Component.CENTER_ALIGNMENT);
		info.setText("Game Over!");
		info.setBorder(new LineBorder(new Color(0, 0, 0)));
		info.setBounds(MainJframe.scaleWidth(416), MainJframe.scaleHeight(320), MainJframe.scaleWidth(518), MainJframe.scaleHeight(35));
		add(info);
		Sound.sound_fail.play();
				
		setVisible(true);
		Label.sleep(close, 3435);
		

	}
	
	public void setInfo(String labelText){
		info.setText(labelText);
	}
	public String  getInfo(){
		return info.getText();
	}

	Action close = new AbstractAction() {
		private static final long serialVersionUID = 7892207124490351698L;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			mainJframe.addSaveloadPanel();
		}
	};
	

		
	
}
