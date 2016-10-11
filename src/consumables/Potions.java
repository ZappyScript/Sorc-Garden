package consumables;
import bot.Run;
import gui.StartGui;
public class Potions {
	private final Run S;
	private final StartGui gD;
	public Potions(Run s, StartGui gd){
		S = s;
		gD = gd;
		drink(15);
	
	}
	

    private int[] potionID ={
            3008,3010,3012,3014,12625,12627,12629,12631
    };
    private int bankPotAm = 10;
    
    private int potionChecker(boolean bankb, int start){
    	
        if (bankb){
        for (int i = start; i < start+4; i++){
            if (S.bank.contains(potionID[i])){
                if (S.bank.getItem(potionID[i]).getAmount() > bankPotAm-1){
                
                    if (i != start+4)
                        return potionID[i];
                }
            }
        }
        }
        
        else{
            if(gD.selectedPot() == 1)
                start = 3;
                else
                start = 7;
            
                for(int i=start; i > start-4; i--){
                    if (S.inventory.contains(potionID[i])){
                        
                        return potionID[i];
                    }
                }
                
            }
        return 0;
        }
    
        
        
    public void drink(int run){
        if(gD.selectedPot() != 0 && S.settings.getRunEnergy() < run){
 
            int potId = potionChecker(false,0);
            if(potId != 0 && S.inventory.contains(potId)){
                S.inventory.getItem(potId).interact("Drink");
            }
            
        }
        if (S.inventory.contains("Vial")){
            S.inventory.getItem("Vial").interact("Drop");
           
        }
        
    }
    public boolean potionBanker(){
        if(gD.selectedReward() == 1)
            bankPotAm = 4;
        
        if(gD.selectedPot() !=0 ){
            int potId = 0;
            if(gD.selectedPot() == 1)
                potId = potionChecker(true,0);
                else
                potId = potionChecker(true,4);
            
                if(potId != 0 ){
                    return S.bank.withdraw(potId,bankPotAm);
                }
            
        }
        return true;
    }
    
   
   
    
	
}
