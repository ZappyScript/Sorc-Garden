package bank;

import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;
import org.osbot.rs07.api.model.NPC;
import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.utility.ConditionalSleep;

import bot.Run;
import consumables.Potions;
import data.Data;
import gui.StartGui;

public class Bank {
	
	private final Run S;
	private static final Area BANK_AREA = new Area(3309, 3119, 3301, 3126);
	private static final Area ENTER_AREA = new Area(3316,3143,3324,3137);
	private final StartGui gD;
	private final Potions P;
	
	public Bank(Run s, StartGui gd ){
		S = s;
		gD = gd;
		P = new Potions(s,gD);
		
		//S.log(gD.isStarted());
		if (shouldBank() && !inBank()) goBank();
		else if (shouldBank() && inBank() && !S.bank.isOpen())
			openBank();
		else if (S.bank.isOpen())
			deposit();
		
		else if (BANK_AREA.contains(S.myPlayer()) && S.settings.getRunEnergy() < 90 ){
			while(S.settings.getRunEnergy() < 90){
				P.drink(90);
			}
			openBank();
		}
		
		else if(ENTER_AREA.contains(S.myPlayer()))
			enterGarden();
		
	}
	private void deposit(){
        	if(S.bank.depositAll()){
        		if(P.potionBanker()){
        			S.bank.close();
        		}
        		if(S.settings.getRunEnergy() > 90)
        			walkBank(false);
        	}
        	
	}
	private boolean shouldBank(){
		return S.inventory.isFull() ? true:false;
	}
	
	public void goBank(){
		if (Data.gardenArea.contains(S.myPlayer()))  
			exitGarden();
		else 
			walkBank(shouldBank());
	}
	
	private void exitGarden(){
		  S.settings.setRunning(false);
		  RS2Object fountain = S.objects.closest("Fountain");
          if (fountain != null && !S.myPlayer().isAnimating()){
                  fountain.interact("Drink-from");
                  new ConditionalSleep(5000) {
                  	@Override
                  	public boolean condition() throws InterruptedException {
                  		return ENTER_AREA.contains(S.myPlayer());
                  	}
                  }.sleep();
          }
         
        
	}
	
	private void walkBank(boolean g){
		if(g) 
			S.walking.webWalk(new Position(3308,3120,0));
		else if(!Data.gardenArea.contains(S.myPlayer()))
			S.walking.webWalk(new Position(3321,3139,0));
	}
	
	private void openBank(){
		 RS2Object bankBooth = S.objects.closest("Bank chest");
         if (bankBooth != null) {
         bankBooth.interact("Use");
                
         } 
     }
	
	 private boolean inBank(){
		return  BANK_AREA.contains(S.myPlayer())? true : false; 
	}
	 
	private void enterGarden(){
		S.settings.setRunning(true);
		 NPC apprentice = S.npcs.closest("Apprentice");
         if(!S.myPlayer().isMoving() || !S.myPlayer().isAnimating())
             apprentice.interact("Teleport");
        
	}
	


}
