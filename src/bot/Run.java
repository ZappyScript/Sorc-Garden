package bot;
import org.osbot.rs07.script.Script;
import data.Data;
import gui.StartGui;

import org.osbot.rs07.script.ScriptManifest;
import org.osbot.rs07.utility.ConditionalSleep;

import Solver.AutumnChecks;
import Solver.Reward;
import Solver.WinterChecks;
import bank.Bank;
import Solver.SpringChecks;
import Solver.Walker;



@ScriptManifest(name = "Sorc garden full", author = "Zappster", version = 1.0, info = "", logo = "") 
public class Run extends Script {
	
	private StartGui startGui;
	private Walker Wlk;
	private SpringChecks SC;
	
	
	@Override
	public void onStart(){
		log(myPlayer().getRotation());
		startGui = new StartGui();
		
	}
	
	@Override
    public int onLoop() throws InterruptedException {
		if(startGui.isStarted() ){
			new Bank(this,startGui);
			if(map.getDestination() != null)
				log(map.getDestination().getX());
				if(Data.gardenArea.contains(myPlayer())&& !inventory.isFull())
					openGate();
				switch(startGui.selectedGarden()){
					case 0: //winter
							/*
							 * TODO:
							 * Add walking to bank if energy is low
							 * Get camera to lock onto prize
							 * Fix the few spring catches
							 * Add paint stuff ( can wait until last)
							 */
						/*
						 * My crazy algo to solve these puzzles
						 * it loops to 4 as that's the max steps it can reach.
						 * cases cause I dont know java nodes yet
						 * 
						*/
							for (int i=0; i<= 4; i++){ 
							if (imIn(i)){
							new WinterChecks(this,i,startGui);
							}
						}
							
					break;
				
					case 1: //spring
						for (int i=0; i<= 6; i++){ 
							if (imIn(i)){
							SC = new SpringChecks(this,i,startGui);
							}
						}
					break;
					
					case 2:
						for (int i=0; i<=8; i++){
							if (imIn(i)){
								new AutumnChecks(this,i,startGui);
							}
						}
						
						break;
					
				}
				new Reward(this,startGui);
			}
		 if (startGui.isStarted() && myPlayer().isAnimating()){
			switch(startGui.selectedGarden()){
			case 1:
				if (SC.startRewardCam())
					Wlk.camToReward();
				break;
			
			}
		}
        return 600; 
       
	}
	 private boolean imIn(int id){
	   
	        if (!myPlayer().isMoving() && !myPlayer().isAnimating()){
	            for (int i = 0; i < Data.playerArea[startGui.selectedGarden()][id].length; i++){
	                if(Data.playerArea[startGui.selectedGarden()][id][i].contains(myPlayer())){
	                	if (i > 0){
	                    if(!myPlayer().getPosition().equals(Data.walkPath[startGui.selectedGarden()][id])){
	                        Data.walkPath[startGui.selectedGarden()][id].interact(bot, "Walk here");
	                    }
	                	}
	                    return true;
	                }
	                   
	            }
	            }
	            return false;
	 }
	private void openGate(){
		if (Wlk == null){
			Wlk = new Walker(this,startGui.selectedGarden());
		}
		Wlk.mvCam(0);
		  objects.closest(Data.doorID[startGui.selectedGarden()]).interact("Open");
        new ConditionalSleep(4800) {
        	@Override
        	public boolean condition() throws InterruptedException {
        		return Data.playerArea[startGui.selectedGarden()][0][0].contains(myPlayer());
        	}
        }.sleep();
	}
	

	
}
