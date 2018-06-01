package HW8;

import java.util.ArrayList;

public class DisjointSet {
    
    
    /**
     * make a set out of the cells in the maze
     * @param maze
     */
    public void makeSet(MazeCell[][] maze) {
    	for(int i = 0; i < maze.length; i++){
    		for(int j = 0; j < maze[0].length; j++){
    			MazeCell mc = maze[i][j];
    			mc.setParent(mc);
    			mc.setRank(0);
    		}
    	}
        
    }

    /**
     * Create the union of the sets that contain cell1 and cell2.
     * If the two cells are in the same set, nothing changes,
     * else create the new set as a union. 
     * Please see the union-find algorithm.
     * @param cell1
     * @param cell2
     */
    public void union(MazeCell cell1, MazeCell cell2){
    	MazeCell cell1f = find(cell1);
    	MazeCell cell2f = find(cell2);
        if(cell1f != cell2f){
        	if(cell1f.getRank() > cell2f.getRank()){
        		cell2.setParent(cell1f);
        	}else {
        		cell1f.setParent(cell2f);
        		if(cell1f.getRank() == cell2f.getRank()){
        			cell2f.setRank(cell2f.getRank()+1);
        		}
        	}
        	
        }
    }

    /**
     * Find the set that the cell is a part of.
     * While finding the set, do the path compression as well.
     * @param cell
     * @return
     */
    public MazeCell find(MazeCell cell){
    	ArrayList<MazeCell> mc = new ArrayList<MazeCell>();
    	while(cell.getParent() != cell){
    		mc.add(cell);
    		cell = cell.getParent();
    	}
    	for(int i = 0; i < mc.size(); i++){
    		mc.get(i).setParent(cell);
    	}
        return cell;
    }

}
