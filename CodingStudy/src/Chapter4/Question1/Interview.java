package Chapter4.Question1;

import java.util.LinkedList;

import Chapter4.RefGraph.Graph;
import Chapter4.RefGraph.Node;
import Chapter4.RefGraph.Node.State;


/*
 * 4-1 노드 사이의 경로 : 방향 그래프가 주어졌을 때 두 노드 사이에 경로가 존재하는지
 * 확인하는 알고리즘을 작성하라.
 */

public class Interview {
	

	public static void main(String[] args) {
		Graph g = createGraph();
		Node[] n = g.getNodes();
		Node start = n[3];
		Node end = n[5];
		System.out.println(search(g,start,end));

		

	}
	
	public static Graph createGraph() {
		Graph g = new Graph();
		Node[] nodes = new Node[6];
		
		nodes[0] = new Node("a", 3);
		nodes[1] = new Node("b", 0);
		nodes[2] = new Node("c", 0);
		nodes[3] = new Node("d", 1);
		nodes[4] = new Node("e", 1);
		nodes[5] = new Node("f", 0);
		
		nodes[0].addAdjacent(nodes[1]);
		nodes[0].addAdjacent(nodes[2]);
		nodes[0].addAdjacent(nodes[3]);
		nodes[3].addAdjacent(nodes[4]);
		nodes[4].addAdjacent(nodes[5]);
		
		for(int i=0; i< 6 ; i++) {
			g.addNode(nodes[i]);
		}
		return g;
	}
	
	public static boolean search(Graph g,Node start, Node end) {
		
		LinkedList<Node> q = new LinkedList<Node>();
		for(Node u : g.getNodes()) {
			u.state = State.Unvisited;
		}
		start.state = State.Visiting;
		q.add(start);
		Node u;
		while(!q.isEmpty()) {
			u = q.removeFirst();
			if(u != null) {
				for(Node v : u.getAdjacent()) {
					if(v.state == State.Unvisited) {
						if(v == end) {
							return true;
						} else {
							v.state= State.Visiting;
							q.add(v);
						}
					}
				}
				u.state = State.Visited;
			}
		}
		return false;
	}

}
