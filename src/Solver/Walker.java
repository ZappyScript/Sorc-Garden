package Solver;
import org.osbot.rs07.api.model.NPC;
import org.osbot.rs07.input.mouse.MiniMapTileDestination;
import org.osbot.rs07.script.MethodProvider;

import bot.Run;
import data.Data;

public class Walker {
	private Run S;
	private int GardenId;

	public Walker(Run s,int gardenId){
		S = s;
		GardenId = gardenId;
	}
	
	public boolean npcArea(NPC npc, int step, int npcId){
	       
        if(Data.NpcArea[GardenId][npcId][step].contains(npc) && (!S.myPlayer().isMoving() || !S.myPlayer().isAnimating())){
            return true;
        }
           
        return false;
    }
	
	  public void pWalk(int p,boolean run) throws InterruptedException{
	      
	        if (!S.myPlayer().isMoving()){
	           // startRun(run);
	        	if(Data.walkPath[GardenId][p].isVisible(S.bot))
	        		Data.walkPath[GardenId][p].interact(S.bot, "Walk here");
	        	else{
	            S.mouse.click(new MiniMapTileDestination(S.bot, Data.walkPath[GardenId][p], true), false);
	            S.mouse.move(new MiniMapTileDestination(S.bot, Data.walkPath[GardenId][p+1], true));
	        	}
	            
	        }else if(S.map.getDestination() != null){
	        	if (!S.map.getDestination().equals(Data.walkPath[GardenId][p]))
	        		Data.walkPath[GardenId][p].interact(S.bot, "Walk here");
	        }
	    }
	  private int[][] cameraPitch={
			  {
				  46,55,52,67,59,48 
			  },
			  
			  {
	            67,67,67,38,55,55,57}
	    };
	   
	    private int[][] cameraYaw={
	    		{
	    			104,306,510,338,264,192
	    		},{
	            173,223,291,24,10,64,272
	    		}};
	    
	    public void mvCam(int i){
	        if (S.myPlayer().isMoving()){
	        int mod = MethodProvider.random(3,10);
	        int dice = MethodProvider.random(1,6);
	        int a = 0;
	            if (dice > 3)
	                a = MethodProvider.random(cameraPitch[GardenId][i]-mod,cameraPitch[GardenId][i]);
	            else
	                a = MethodProvider.random(cameraPitch[GardenId][i],(cameraPitch[GardenId][i]+mod));
	        
	        mod = MethodProvider.random(3,15);
	        dice = MethodProvider.random(10,20);
	        int b = 0;
	            if (dice > 15)
	                b = MethodProvider.random(cameraYaw[GardenId][i]-mod,cameraYaw[GardenId][i]);
	            else
	                b = MethodProvider.random(cameraYaw[GardenId][i],cameraYaw[GardenId][i]+mod);
	        
	        S.camera.movePitch(a);
	        S.camera.moveYaw(b);
	        }
	    }
	    public void camToReward(){
	    	
	    }
	  
	  	
}
