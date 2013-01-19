package org.leetcode.clonegraph.part1;

import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import org.leetcode.helper.GraphNode;

public class CloneGraph {
	
	public GraphNode clone(GraphNode root) throws Exception {
		
		HashMap<GraphNode, Boolean> visitedMap = new HashMap<GraphNode, Boolean>();
		HashMap<Integer, GraphNode> clonedMap = new HashMap<Integer, GraphNode>();

		GraphNode newRoot = new GraphNode(root.getId());
		clonedMap.put(root.getId(), newRoot);

		Queue<GraphNode> queue = new LinkedBlockingQueue<GraphNode>();
		queue.add(root);
		while( !queue.isEmpty() ){
			GraphNode node = queue.remove();
			// mark the node as visited
			GraphNode newNode;
			int nodeId = node.getId();
			if ( clonedMap.containsKey(nodeId)) {
				newNode = clonedMap.get(nodeId);
			} else {
				newNode = new GraphNode(nodeId);
			}
			
			visitedMap.put(node, null);
			if( node.getNeighbors() == null) {
				// report error
				throw new Exception("neighbors are null");
			}
			
			for (GraphNode neighbor : node.getNeighbors()) {
				GraphNode newNeighbor = null;
				if( visitedMap.containsKey(neighbor) ) {
					// link the new neighbor as a existing cloned node
					newNeighbor = clonedMap.get(neighbor.getId());
				} else {
					int id = neighbor.getId();
					newNeighbor = new GraphNode(id );
					clonedMap.put(id, newNeighbor);
				}
				
				queue.add(neighbor);
				newNode.getNeighbors().add(newNeighbor);
			}
			clonedMap.put(nodeId, newNode);
		}
		
		return newRoot;
	}

}
