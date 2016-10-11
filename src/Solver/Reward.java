package Solver;

import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.event.InteractionEvent;
import org.osbot.rs07.utility.ConditionalSleep;

import bot.Run;
import consumables.Potions;
import gui.StartGui;

public class Reward {
	private Run S;
	private int GardenId,picked;
	public final Area[] rewardArea =  {new Area(2888,5479,2894,5466),new Area(2933,5470,2935,5477),new Area(2933,5470,2935,5477)};
	private boolean hasPicked = false;
	private int Reward;
	private Potions Pot;
	public Reward(Run s, StartGui st){
		S=s;
		GardenId = st.selectedGarden();
		Reward=st.selectedReward();
		Pot = new Potions(S,st);
		
		
	}
	
	public void camToReward(){
		
		Pot.drink(20);
		
switch (Reward){
		
		case 0:
			RS2Object tree = S.objects.closest("Sq'irk tree");
			if(tree != null){
	            S.camera.toEntity(tree);
	           
	           
			}
			break;
		case 1:
			 RS2Object herb = S.objects.closest("Herbs");
			 	if(herb != null){
			 		S.camera.toEntity(herb);
			 	
			 	}
			break;
		
		}
rewardHover();
	}
	
	public boolean attempRewardGrab() throws InterruptedException{
		
		switch (Reward){
		
		case 0:
			RS2Object tree = S.objects.closest("Sq'irk tree");
			if(tree != null){
	            pickReward(true);
	            return true;
			}
			break;
		case 1:
			 RS2Object herb = S.objects.closest("Herbs");
			 	if(herb != null){
			 		pickReward(true);
			 		return true;
			 	}
			break;
		
		}
		return false;
	}
	private boolean inRewardZone(){
		if(rewardArea[GardenId].contains(S.myPlayer())){
			return true;
		}
		//hasPicked = false;
		return false;
	}
	
	private boolean interact(RS2Object r, String i) throws InterruptedException{
	if (r!=null){
		InteractionEvent IE = new InteractionEvent(r,i);
	IE.setOperateCamera(false);
	IE.execute();
	 new ConditionalSleep(700) {
     	@Override
     	public boolean condition() throws InterruptedException {
     		return IE.hasFinished();
     	}
     }.sleep();
	
     if (IE.hasFinished() && IE.hasFailed()){
    	 interact(r,i);
     }
     
     if(IE.hasFinished())
    	 return true;
	}
     return false;
	}
	
	 private void pickReward(boolean bypass) throws InterruptedException{
		 if(inRewardZone()  || bypass){
	            switch(Reward){
	       
	            case 0:
	                    RS2Object tree = S.objects.closest("Sq'irk tree");
	                    
	                    if(tree.interact("Pick-Fruit")){
	                    	setPicked(getPicked() + 1);
	                    	//hasPicked = true;
	                    	
	                    }
	                   
	                    break;
	                case 1:
	                   
	                    RS2Object herb = S.objects.closest("Herbs");
	                    
	                   
	                    if(herb.interact("Pick")){
	                        setPicked(getPicked() + 2);
	                       // hasPicked = true;
	                       
	                    }
	                    break;
	        }
		 }
	  
	    }
	public void rewardHover(){
		RS2Object reward = null;
		switch(Reward){
			case 0:
				reward =  S.objects.closest("Sq'irk tree");
				break;
			case 1:
				reward = S.objects.closest("Herbs");
				break;
		}
		if(reward != null){
			if(!S.mouse.equals(reward))
			reward.hover();
		}
	}
	public int getPicked() {
		return picked;
	}

	public void setPicked(int picked) {
		this.picked = picked;
	}
	 
	 
		
}
