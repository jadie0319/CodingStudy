package Chapter4.RefGraph;


public class Node {
	public enum State {
		Unvisited, Visited, Visiting;
	}
	
	private Node[] adjacent;
	private String vertex;
	
	public int adjacentCount;
	public State state;
	
	public Node(String vertex, int adjacentLength) {
		this.vertex = vertex;
		adjacentCount =0;
		adjacent = new Node[adjacentLength];
	}
	
	public void addAdjacent(Node x) {
		if(adjacentCount < adjacent.length) {
			this.adjacent[adjacentCount] = x;
			adjacentCount++;
		}else {
			System.out.println("No more adjacent can be added");
		}
	}
	
	public Node[] getAdjacent() {
		return adjacent;
	}
	
	public String getVertex() {
		return vertex;
	}
	
	
	

}
