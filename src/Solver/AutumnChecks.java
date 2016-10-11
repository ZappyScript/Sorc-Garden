package Solver;
import bot.Run;
import gui.StartGui;

public class AutumnChecks {

	private Run S;
	private int east = 1536;
	private int north = 1024;
	private int south = 0;
	private int west = 512;
	private int Reward;
	private LoadNPC LNPC;
	private Walker W;
	private Reward Rw;
	
	public AutumnChecks(Run s,int step, StartGui sT) throws InterruptedException{
		S=s;
		W = new Walker(S,sT.selectedGarden());
		LNPC = new LoadNPC(S,sT.selectedGarden());
		Rw = new Reward(s, sT);
		Reward = sT.selectedReward();
		run(step);
	
	}
	
	private boolean moveCam;
	public boolean startRewardCam(){
		return moveCam;
	}
	 
	
	
	private void run(int step) throws InterruptedException{
		S.log(step);
		 switch (step){
	       
	         case 0:
	                 W.pWalk(0,false);
	             break;
	            
	         case 1:
	               if (LNPC.npcArea(0,0) && LNPC.returnNpc(0).getRotation() == west )
	                   W.pWalk(1,true);
	               break;
	               
	         case 2:
	                 if(LNPC.npcArea(0,1)&& LNPC.returnNpc(0).getRotation()==east)
	                 W.pWalk(2,true);
	               break;
	         
	         case 3: 
	        	 	if(LNPC.npcArea(1, 0) &&LNPC.returnNpc(1).getRotation()==south )
	        	 	W.pWalk(3, true);
	        	
	        	 break;
	       
	         case 4:
	        	 if(LNPC.npcArea(1, 1) && LNPC.returnNpc(1).getRotation() == north && LNPC.npcArea(2, 0) && LNPC.returnNpc(2).getRotation() == east)
	        			 W.pWalk(4, true);
	        		 
	        	break;
	         case 5:
	        		
	        		 if(LNPC.npcArea(3, 0) || LNPC.npcArea(3, 1)){
	        			 W.pWalk(5, true);
	        	 }
	        		 
	        	 break;
	        	 
	         case 6:
	        	 if((LNPC.npcArea(3, 2)||LNPC.returnNpc(3).getRotation() == south) && LNPC.npcArea(4, 0) && LNPC.returnNpc(4).getRotation()==east)
	        		W.pWalk(6, true);
	        		 break;
	        		 
	         case 7:
	        	 Rw.camToReward();
	        	 switch (Reward){
	        	 case 0:
	        		 if(LNPC.npcArea(5, 0) && LNPC.returnNpc(5).getRotation() == east){
	        			
	        			 Rw.attempRewardGrab();
	        		 }
	        			 break;
	        	 case 1:
	        		 if(LNPC.npcArea(4, 1) && LNPC.returnNpc(4).getRotation() == west)
	        			 Rw.attempRewardGrab();
	        			 break;
	        	
	        	 }
	        	 break;
	        	 
	         case 8:
	        	 Rw.attempRewardGrab();
	        	 
		 }
	
	}
	
}
