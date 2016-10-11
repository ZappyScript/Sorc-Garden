package Solver;


import org.osbot.rs07.api.model.NPC;

import bot.Run;
import data.Data;

public class LoadNPC {
	
	private Run S;
	private int GardenId;
	private NPC[] npcs;
	
	public LoadNPC(Run s, int gardenId){
		S = s;
		GardenId = gardenId;
		npcs = loadNPC(gardenId);
		
	}
	
	
	private NPC[] loadNPC(int gardenId){
		/*List<NPC> npc = new ArrayList<NPC>();
		for(int i =0; i<Data.npcId[GardenId].length; i++){
			npc.add(S.npcs.closest(Data.npcId[GardenId][i]));
		}
		return npc.toArray();
		*/
		NPC[] GardenNpc = null;
		if(gardenId == 0){
			 NPC[] gardenNpc= { //winter Npc's
	                  S.npcs.closest(5798),
	                  S.npcs.closest(5799),
	                  S.npcs.closest(5800),
	                  S.npcs.closest(5801)
	                      };
			 GardenNpc = gardenNpc;
		}
		
		if (gardenId == 1){
			 NPC[] gardenNpc= { //winter Npc's
					 S.npcs.closest(2956),
                     S.npcs.closest(2958),
                     S.npcs.closest(2957),
                     S.npcs.closest(2962),
                     S.npcs.closest(2961),
                     S.npcs.closest(2963),
	                      };
			 GardenNpc = gardenNpc;
			 
		}
		
		if(gardenId == 2){
			NPC[] gardenNpc ={
					S.npcs.closest(5802),
                    S.npcs.closest(5803),
                    S.npcs.closest(5804),
                    S.npcs.closest(5805),
                    S.npcs.closest(5806),
                    S.npcs.closest(5807)
					
			};
			GardenNpc = gardenNpc;
		}
		
		return GardenNpc;
	}
	
	
	public boolean npcArea(int npc, int step){
	
	        if(Data.NpcArea[GardenId][npc][step].contains(npcs[npc])){
	            return true;
	        }
	         
	        return false;
	    }
	
	public NPC returnNpc(int id){
		return npcs[id];
		
	}
	
}
