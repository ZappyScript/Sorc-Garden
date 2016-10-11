package gui;

import javax.swing.*;

import java.awt.*;

@SuppressWarnings("serial")
public class Gui extends JFrame{

  
	protected final GridBagConstraints c = new GridBagConstraints();
    protected final JPanel mainPanel = new JPanel(new GridBagLayout());

    public Gui(){

    	setTitle("Garden Solver");
 		setBackground(Color.DARK_GRAY);
 		setResizable(false);
 		setBounds(100, 100, 241, 168);

        add(mainPanel);
        
    }

    public void close(){
        setVisible(false);
        dispose();
    }
}
