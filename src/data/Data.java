package data;

import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;

public class Data {
	public final static int[][] npcId ={
			
					{ //winter
						 5798,
		                 5799,
		                 5800,
		                 5801
					},
					{ //spring
						 2956,
		                 2958,
		                 2957,
		                 2962,
		                 2961,
		                 2963
					}
					
	};

	public final static Area[] gardenZones = {new Area(2902,5465,2887,5485)};
	
	public final static Area gardenArea = new Area(2903, 5480, 2920, 5463);


	 public final static Position[][] walkPath = {
             //winter path
    		{
            new Position(2903,5470,0),
            new Position(2900,5476,0),
            new Position(2898,5481,0),
            new Position(2892,5481,0),
            new Position(2892,5484,0),
            new Position(2891,5478,0)
            
    		},
    		
    		//spring Path
    		{
                new Position(2920,5473,0),
                new Position(2923,5471,0),
                new Position(2923,5466,0),
                new Position(2923,5459,0),
                new Position(2924,5468,0),
                new Position(2928,5470,0),
                new Position(2930,5470,0),
                new Position(2931,5466,0),
                new Position(2934,5472,0)
                
    		},
    		{ //autumn path
    			new Position(2908,5461,0),
    			new Position(2904,5459,0),
    			new Position(2901,5455,0),
    			new Position(2901,5451,0),
    			new Position(2903,5450,0),
    			new Position(2902,5453,0),
    			new Position(2908,5456,0)
    		}
    
    };
  
    public final static Area[][][] NpcArea ={
    		{
            //Winter NpcArea.
                {
                    new Area(2899,5476,2897,5475),
                    new Area(2897, 5478, 2897, 5472)
                    }, 
                { 
                    new Area(2899,5480,2896,5483),
                    new Area(2896,5482,2900,5483)
                    },
                 
                { 
                    new Area(2893,5481,2891,5483),
                    new Area(2896,5481,2894,5481)
                    },
                { 
                    new Area(2893, 5485, 2897, 5485)
                }
    		},
    		{
    			//spring NpcArea
                {
                    new Area(2922,5468,2922,5459),
                    new Area(2922,5466,2922,5471),
                    new Area(2922,5471,2922,5467)
                },
                { 
                    new Area(2925,5461,2926,5459)
                },
                { 
                    new Area(2925,5463,2928,5462)
                },
                { 
                    new Area(2925,5464,2925,5468),
                    new Area(2925,5467,2925,5464),
                    new Area(2925,5465,2925,5464),
                    new Area(2925,5469,2925,5474),
                    new Area(2925,5475,2925,5474)
                },
                {
                    new Area(2929,5469,2935,5469),
                    new Area(2931,5469,2933,5469),
                    new Area(2930,5469,2930,5469)
	            },
                {
                    new Area(2931,5477,2931,5473)
                }
	            
    		},
    		{ //Autumn npc area
    			{
    				new Area(2906,5460,2899,5460), //west
    				new Area(2904,5460,2908,5460) //east
    			},
    			{
    				new Area(2900,5453,2900,5454), //south
    				new Area(2900,5451,2900,5454) // north + with next npc
    				
    			},
    			{
    				new Area(2899,5449,2902,5449) //east
    				
    			},
    			{
    				new Area(2903,5453,2903,5455),
    				new Area(2904,5455,2905,5452),
    				new Area(2904,5454,2905,5454) // or south + next one
    			},
    			{
    				new Area(2904,5457,2914,5457), // and east
    				new Area(2908,5457,2903,5457) // west + for herb tree
    				
    			},
    			{
    				new Area(2911,5455,2915,5455) //and east
    			}
    			
    		}
               
            };
    	public final static Area[][][] playerArea ={
    		
            //Winter garden 
    		{
    			{new Area(2902,5470,2901,5470)},
    			{new Area(2901,5476,2899,5476),new Area(2899,5478,2899,5475)},
    			{new Area(2896,5479,2900,5483)},
    			{new Area(2895,5481,2891,5483),new Area(2894,5485,2891,5485)},
    			{new Area(2888,5979,2895,5472),new Area(2888,5484,2889,5481)}
    		},
    		{
    		//Spring garden
    	        {new Area(2921,5473,2922,5473)},
    	        {new Area(2923,5471,2923,5473)},
    	        {new Area(2923,5466,2923,5465)},
    	        {new Area(2922,5459,2924,5459),new Area(2923,5459,2923,5458)},
    	        {new Area(2924,5468,2926,5468), new Area(2925,5470,2925,5466)},
    	        {new Area(2926,5470,2928,5470), new Area(2928,5470,2928,5468)},
    	        {new Area(2930,5470,2931,5469)}
    	        
    		},
    		
    		{
    			{new Area(2913,5462,2913,5461)},
    			{new Area(2908,5460,2910,5461)},
    			{new Area(2904,5459,2904,5460)},
    			{new Area(2901,5455,2899,5459)},
    			{new Area(2901,5451,2900,5451)},
    			{new Area(2903,5449,2903,5451)},
    			{new Area(2902,5453,2903,5453)},
    		 	{new Area(2908,5457,2908,5455)},
    		 	{new Area(2917,5453,2909,5448)}
    			
    		}
            };
    public final static int[] doorID={12617,12719,12639};
	
	 
	  final public static Position doorWalk = new Position(2920,5473,0);//door
	  
	  
}
