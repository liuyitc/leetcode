package org.leetcode.helper;

import java.util.List;

public class GraphNode {
	
	private int id;
	private List<GraphNode> neighbors;
	
	public GraphNode() {
		id = -1;
		neighbors = null;
	}
	
	public GraphNode(int id) {
		this.id = id;
		neighbors = null;
	}
	
	public GraphNode(int id, List<GraphNode> neighbors) {
		this.id = id;
		this.neighbors = neighbors;
	}

	public List<GraphNode> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(List<GraphNode> neighbors) {
		this.neighbors = neighbors;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
