package WayNr2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Kontroll.Kontroll;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Assignment2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 866770805351420122L;
	private JPanel contentPane;
	private FirstPanel firstPanel;
	private AlleRomPanel alleRomPanel;
	private JTextField textField;
	private Kontroll kontroll;


/**
 * Create the frame.
 */
public Assignment2(Kontroll kontroll) {
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setExtendedState(JFrame.MAXIMIZED_BOTH);
	setUndecorated(true);
	setBounds(0, 0, 1366, 768);
	
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	textField = new JTextField();
	textField.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
    		
    		if ("1".equals(textField.getText())) {
    			contentPane.remove(firstPanel);
    			contentPane.add(alleRomPanel);
    			contentPane.revalidate(); // For Java 1.7 or above.
    			contentPane.repaint();
    			System.out.println(textField.getText());
    			textField.setText("");
    		}else if ("2".equals(textField.getText())){
    			contentPane.remove(alleRomPanel);
    			contentPane.add(firstPanel);
    			contentPane.revalidate(); // For Java 1.7 or above.
    			contentPane.repaint();
    			textField.setText("");
        }
        }
    });
	textField.setBounds(scaleWidth(600), scaleHeight(700), scaleWidth(86), scaleHeight(20));
	contentPane.add(textField);
	textField.setColumns(10);


	firstPanel = new FirstPanel();
	firstPanel.setBounds(0, 0, scaleWidth(1366), scaleHeight(670));
    firstPanel.setOpaque(true);
    firstPanel.setBackground(Color.BLUE);

    

    alleRomPanel = new AlleRomPanel(kontroll);

    contentPane.add(alleRomPanel);

	
	
	
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

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				final Kontroll kontroll = new Kontroll();

				try {
					Assignment2 frame = new Assignment2(kontroll);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
