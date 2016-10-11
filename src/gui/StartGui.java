package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class StartGui extends Gui{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5667677232567429839L;
	private boolean started = false;
	private int selectedReward,selectedGarden,selectedPot;
	public StartGui(){
		 super();

		 mainPanel.setBackground(Color.DARK_GRAY);
	 		mainPanel.setForeground(Color.WHITE);
	 		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	 		setContentPane(mainPanel);
	 		mainPanel.setLayout(null);
			Vendor[] garden = {new Vendor("Winter", 0)
	                , new Vendor("Spring", 1)
	                , new Vendor("Autumn",2)};
			JLabel lblSelectGarden = new JLabel("Select Garden");
			lblSelectGarden.setForeground(Color.WHITE);
			lblSelectGarden.setBounds(10, 11, 84, 14);
			mainPanel.add(lblSelectGarden);
			
			JComboBox<Object> cBGarden = new JComboBox<Object>(garden);
			cBGarden.setBounds(93, 8, 124, 20);
			cBGarden.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                Vendor item = (Vendor) cBGarden.getSelectedItem();
		                selectedGarden = item.ID;
		            }
		        });
			mainPanel.add(cBGarden);
			 Vendor[] reward = {new Vendor("Sq'irk fruit", 0)
		                , new Vendor("Herbs", 1)};
		     
			JLabel lblSelectReward = new JLabel("Select reward");
			lblSelectReward.setForeground(Color.WHITE);
			lblSelectReward.setBounds(10, 36, 73, 14);
			mainPanel.add(lblSelectReward);
			
			JComboBox<Object> cBReward = new JComboBox<Object>(reward);
			cBReward.setBounds(93, 33, 124, 20);
	        cBReward.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                Vendor item = (Vendor) cBReward.getSelectedItem();
	                selectedReward = item.ID;
	            }
	        });
			mainPanel.add(cBReward);
			
			 Vendor[] pot = {new Vendor("None", 0)
		                , new Vendor("Energy potion", 1), new Vendor("Stamina Potion", 2)};
		     
			JLabel lblSelectPots = new JLabel("Select Pots");
			lblSelectPots.setForeground(Color.WHITE);
			lblSelectPots.setBounds(10, 61, 84, 14);
			mainPanel.add(lblSelectPots);
			
			JComboBox<Object> cBPots = new JComboBox<Object>(pot);
			cBPots.setBounds(93, 58, 124, 20);
	        cBPots.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                Vendor item = (Vendor) cBPots.getSelectedItem();
	                selectedPot = item.ID;
	            }
	        });
			mainPanel.add(cBPots);
			
			JButton btnStartBot = new JButton("Start Bot");
			btnStartBot.setBounds(75, 105, 89, 23);
			btnStartBot.addActionListener(e -> {
                  
	              started = true;
	              setVisible(false);
	                  
	            });
			mainPanel.add(btnStartBot);
			
	    
	            setVisible(true);
	 
	 }
	
	public boolean isStarted(){
		return started;
	}
	
	public int selectedPot(){
		return selectedPot;
	}
	
	public int selectedReward(){
		return selectedReward;
	}
	
	public int selectedGarden(){
		return selectedGarden;
	}

}
