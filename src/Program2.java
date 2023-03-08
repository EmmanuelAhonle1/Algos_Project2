/*
 * Name: Emmanuel Ahonle
 * EID: eva278
 */

// Implement your algorithms here
// Methods may be added to this file, but don't remove anything
// Include this file in your final submission

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
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
        
        Map<Region,Region> mstChildToParent = new HashMap<Region,Region>(); //<Child, Parent>

        // TODO: implement this function
        
        
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

        
        while(!heap.isEmpty()) {
        	Region u = heap.remove();
        	for(Region v : u.getNeighbors()) {
        		int pos = u.getNeighbors().lastIndexOf(v);
        		int weightOfUtoV = u.getWeights().get(pos);
        		if(heap.contains(v) && weightOfUtoV < v.getMinDist()) {
        			heap.remove(v);
        			
        			v.setMinDist(weightOfUtoV);

        			mstChildToParent.putIfAbsent(u, v);
        			heap.add(v);
        		}
        	}
        	
        	
        	
        	
        }
        
        int MSTlength = 0;
        
        
        for(Region child : mstChildToParent.keySet()) {
        	Region parent = mstChildToParent.get(child);
//        	parent.getMST_Neighbors().add(child);
//        	parent.getMST_Weights().add(child.getMinDist());
//        	child.getMST_Neighbors().add(parent);
//        	child.getMST_Weights().add(parent.getMinDist());

        	

        	parent.setMST_NeighborAndWeight(child, child.getMinDist());
        	child.setMST_NeighborAndWeight(parent, parent.getMinDist());
        	
        	
        }
        
        for(Region r : problem.getRegions()) {
        	
        	
        	MSTlength += r.getMinDist();
        }
        
      
        
        

        
        



        
        return MSTlength;
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
        int diameter = 0;
        

        
        
        
        //arraylist of layernumbers 
        
        
        
        for(Region startNode : problem.getRegions()) {
			Queue<Region> queue = new LinkedList<Region>();
	        boolean[] visited = new boolean[problem.getRegions().size()];
	        boolean[] pushed = new boolean[problem.getRegions().size()];
	        
	        ArrayList<Integer> layerNum = new ArrayList<Integer>(Collections.nCopies(problem.getRegions().size(), 0));
	        
	        visited[startNode.getIndex()] = true;
	        
			queue.add(startNode);
			
			while(!queue.isEmpty()) {
				Region node = queue.poll();
				for(Region neighbor : node.getMST_Neighbors()) {
					if(!visited[neighbor.getIndex()]) {
						visited[neighbor.getIndex()] = true;
						layerNum.set(neighbor.getIndex(), layerNum.get(node.getIndex()) + 1);
						queue.add(neighbor);
					}
				}
			}
			
			int val = max(layerNum);
			if(val > diameter) {
				diameter = val;
			}
			
			int x = 5;
        }
        
        // TODO: Implement this function



        
        return diameter;
    }
    
    public int max(ArrayList<Integer> val) {
    	int maxLayer=0;
		for(Integer i : val) {
			if(i > maxLayer) {
				maxLayer = i;
			}
		}
		return maxLayer;
    }
    
    
}
