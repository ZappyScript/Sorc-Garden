package Solver;
import bot.Run;
import gui.StartGui;

public class SpringChecks {

	private Run S;
	private int east = 1536;
	private int north = 1024;
	private int south = 0;
	private int west = 512;
	   
	private LoadNPC LNPC;
	private Walker W;
	private Reward Rw;
	
	public SpringChecks(Run s,int step, StartGui sT) throws InterruptedException{
		S=s;
		W = new Walker(S,1);
		LNPC = new LoadNPC(S,1);
		Rw = new Reward(s, sT);
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
	                 W.pWalk(1,true);
	             break;
	            
	         case 1:
	               if (LNPC.npcArea(0,0) && LNPC.returnNpc(0).getRotation() == south )
	                   W.pWalk(2,true);
	               break;
	               
	         case 2:
	                 if(LNPC.npcArea(0,2) || LNPC.npcArea(0, 1) && LNPC.returnNpc(0).getRotation()==north)
	                 W.pWalk(3,true);
	               break;
	         
	         case 3: 
	        	 	if(LNPC.returnNpc(3)!= null){
	        	 		if(LNPC.npcArea(1, 0) && LNPC.npcArea(2, 0)&&!LNPC.npcArea(3, 4)&&LNPC.returnNpc(3).getRotation()==north )
	        	 			W.pWalk(4, true);
	        	 	}
	        	 break;
	       
	         case 4:
	        	 if(((LNPC.npcArea(3, 1)&&LNPC.returnNpc(3).getRotation()==south)) || (LNPC.npcArea(3,2)) || (LNPC.npcArea(3, 3)&&LNPC.returnNpc(3).getRotation()==north))
	        		 W.pWalk(5, true);
	        		 
	        	break;
	         case 5:
	        	 if(LNPC.npcArea(4, 0)&& LNPC.returnNpc(4).getRotation() == east){
	        		 W.pWalk(6, true);
	        		moveCam = true;
	        	 }
	        		 
	        	 break;
	        	 
	         case 6:
	        	 Rw.camToReward();
	        	 if((LNPC.npcArea(5, 0) || LNPC.returnNpc(5).getRotation()==north)&&(LNPC.npcArea(4, 1)&&LNPC.returnNpc(4).getRotation()==east)||(LNPC.npcArea(4, 2)&&LNPC.returnNpc(4).getRotation() == west)){
	        		 Rw.attempRewardGrab();
	        		 S.log(LNPC.returnNpc(4).getRotation());
	        	 }
	        	 break;
		 }
	
	}
	
}
