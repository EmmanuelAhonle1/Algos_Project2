/*
 * Name: Emmanuel Ahonle
 * EID: eva278
 */

// Implement your algorithms here
// Methods may be added to this file, but don't remove anything
// Include this file in your final submission

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Program2 {

    /**
     * findMinimumLength()
     * @param problem  - contains the regions of the graph.
     * 
     * @return The sum of all of the edges of the MST.
     * 
     * @function Should track the edges in the MST using region.mst_neighbors and region.mst_weights
     *  This function will not modify the mst_lists when run Gradescope if called in calculateDiameter()
     */
    public int findMinimumLength(Problem problem) {
    //For each u ∈ G.V 
        problem.getRegions().get(0).setMinDist(0);
        Queue<Region> heap = new PriorityQueue<>(problem.getRegions());

        // TODO: implement this function
        
//        for(Region u : problem.getRegions()) {
//        	u.resetMinDist();
//        	u.setIndex(0);
//        	
//        }
//        
//        Region r = heap.remove();
//        r.setMinDist(0);
//        heap.add(r);
        
        /*
        MST-Prim(G,w) 
        For each u ∈ G.V 
            do u.key ← ∞ 
                  u.π ← nil 
        r.key ← 0 
        Q ← G.V 
        While Q ≠ ∅ 
            Do u ← Extract-Min(Q) 
                  For each v ∈ Adj[u] 
                      Do if v ∈ Q and w(u,v) < v.key 
                            Then v.π ← u 
                                      v.key ← w(u,v)
                                      */
        ArrayList<Integer> parentsNum = new ArrayList<Integer>();
        ArrayList<Region> parents = new ArrayList<Region>();

        for(Region i : problem.getRegions()) {
        	parentsNum.add(null);
        	parents.add(null);
        }
        
        while(!heap.isEmpty()) {
        	Region u = heap.remove();
        	for(Region v : u.getNeighbors()) {
        		int pos = u.getNeighbors().lastIndexOf(v);
        		int weightOfUtoV = u.getWeights().get(pos);
        		if(heap.contains(v) && weightOfUtoV < v.getMinDist()) {
        			//parents.set(u, u);
        		}
        	}
        	
        	
        	
        	
        }
        
        int MSTlength = 0;
        
      
        
        
        for(int i=1; i < parents.size();i++) {
        	
        	if(parents.get(i) != null) {
        		MSTlength += parents.get(i).getMinDist();
        	}

        	
        	
        	
        	 
        	
        	
        }
        
        



        
        return MSTlength;
    }
    
    
    public Region findNodeByName(int name, Problem problem) {
    	
    	for(Region i : problem.getRegions()) {
    		if(i.getName() == name) {
    			return i;
    		}
    	}
    	
    	return null;
    }
    		
    	

    

    /* calculateDiameter(Problem problem)
     * 
     * @param problem  - contains the regions of the problem. Each region has an adjacency list
     * defined by mst_neighbors and mst_weights, which defines the provided MST.
     * 
     */
    public int calculateDiameter(Problem problem) {
        
        // Call findMinimumLength in your code to get MST. In gradescope, we will provide the mst in each regions mst_neighbors nad mst_weights list
        int length = findMinimumLength(problem);
        
        // TODO: Implement this function



        
        return 0;
    }
    
    
    /*
     *         	for(Region v : u.getNeighbors()) {
        		int indexOfVinUAdj = u.getNeighbors().lastIndexOf(v);
        		int weightOfUtoV = u.getWeights().get(indexOfVinUAdj);
        		int vKey = v.getMinDist();
        		if(heap.contains(v) && vKey > weightOfUtoV) {
        			
        			Region vTemp = heap.remove();
        			vTemp.setMinDist(weightOfUtoV);

        			
        			vTemp.getMST_Neighbors().add(u);
        			vTemp.getMST_Weights().add(weightOfUtoV);
        			
        			parentsNum.set(v.getIndex(),u.getName());
        			parents.set(v.getIndex(), u);
        			
        			heap.add(vTemp);
        		}
        	}
        	
        	
        	
        	int x =5;
        	
     */

    
}
