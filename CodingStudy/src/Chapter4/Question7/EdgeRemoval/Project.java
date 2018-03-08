package Chapter4.Question7.EdgeRemoval;

import java.util.ArrayList;
import java.util.HashMap;

public class Project {
	private ArrayList<Project> children = new ArrayList<Project>();
	private HashMap<String,Project> map = new HashMap<String,Project>();
	private String name;
	private int dependencies = 0;
	
	public Project(String n) {
		name = n;
	}
	
	public String getName() {
		return name;
	}
	
	public void addNeighbor(Project node) {
		if(!map.containsKey(node.getName())) {
			children.add(node);
			map.put(node.getName(), node);
			
			/* DFS와 다른점. second에 dependency++  */
			node.incrementDependencies();
		}
	}
	
	public void incrementDependencies() {
		dependencies++;
	}
	public void decrementDependencies() {
		dependencies--;
	}
	public ArrayList<Project> getChildren() {
		return children;
	}
	public int getNumberDependencies() {
		return dependencies;
	}

	
	
}
