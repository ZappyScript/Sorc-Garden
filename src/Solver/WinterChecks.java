package Solver;

import org.osbot.rs07.api.map.Position;
import org.osbot.rs07.input.mouse.MiniMapTileDestination;

import bot.Run;
import data.Data;
import gui.StartGui;

public class WinterChecks {
	private Run S;
	private int east = 1536;
	private LoadNPC LNPC;
	private Walker W;
	private Reward Rw;
	private int Reward;
	
	public WinterChecks(Run s,int step, StartGui sT) throws InterruptedException{
		S=s;
		W = new Walker(S,0);
		LNPC = new LoadNPC(S,0);
		Reward = sT.selectedGarden();
		Rw = new Reward(s, sT);
		
		run(step);
	
	}
	
	private void run(int step) throws InterruptedException{
		
		 switch (step){
	       
	         case 0:
	             if (LNPC.npcArea(0,0))
	                 W.pWalk(1,true);
	             
	             break;
	            
	         case 1:
	               if (LNPC.npcArea(0,1) && LNPC.npcArea(1,0))
	                   W.pWalk(2,true);
	               break;
	               
	         case 2:
	                 if(LNPC.npcArea(2,1) && LNPC.npcArea(1,1)){
	                 W.pWalk(4,true);
	                 }else
	                 if(LNPC.npcArea(2,0) && LNPC.npcArea(1,1)){
	                   W.pWalk(3,true);
	                   }
	               break;
	               
	     case 3:
	                 
	          S.mouse.click(new MiniMapTileDestination(S.bot, Data.walkPath[0][4], true), false);
	                 
	          break;
	         case 4:
	             int finalx = Run.random(2888,2890);
	             int finaly = Run.random(5472,5479);
	            
	             if (LNPC.npcArea(3,0) && LNPC.returnNpc(3).getRotation() == east){
	                 if(!Rw.attempRewardGrab()&& Reward != 1){
	                 Data.walkPath[0][5] = new Position(finalx,finaly,0);
	                 W.pWalk(5,true);
	                 }
	             }
	             
	             if(!S.myPlayer().getPosition().equals(new Position(2892,5484,0)) )
	            	 Data.walkPath[0][4].interact(S.bot, "Walk here");
	            
	             break;
	         }
	    
		
	}
	
	
	
}
