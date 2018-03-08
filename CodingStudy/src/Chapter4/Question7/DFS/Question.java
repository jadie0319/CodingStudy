package Chapter4.Question7.DFS;

import java.util.ArrayList;
import java.util.Stack;

/*
 *  4-7 순서 정하기 : 프로젝트의 리스트와 프로젝트들 간의 종속 관계(즉, 프로젝트
 *  쌍이 리스트로 주어지면 각 프로젝트 쌍에서 두 번째 프로젝트가 첫 번째 프로젝트에
 *  종속되어 있다는 뜻)가 주어졌을 때, 프로젝트를 수행해 나가는 순서를 찾으라.
 *  유효한 순서가 존재하지 않으면 에러를 반환한다.
 *  (앞의 알파벳이 먼저 실행되어야 한다.)
 *  
 *  input:
 *  프로젝트 : a,b,c,d,e,f
 *  종속관계 : (a,d), (f,b), (b,d), (f,a), (d,c)
 *  출력 : f,e,a,b,d,c
 *  
 */

public class Question {
	
	public static Graph buildGraph(String projects[], String dependencies[][]) {
		Graph graph = new Graph();
		
		for(String project : projects) {
			graph.getOrCreateNode(project);
		}
		
		for(String dependency[] : dependencies) {
			String first = dependency[0];
			String second = dependency[1];
			graph.addEdge(first, second);
		}
		
		return graph;
	}
	
	public static boolean doDFS(Project project, Stack<Project> stack) {
		if(project.getState() == Project.State.PARTIAL) {
			System.out.println("   ========  project is cycle");
			return false; // Cycle
		}
		
		if(project.getState() == Project.State.BLANK) {
			project.setState(Project.State.PARTIAL);
			ArrayList<Project> children = project.getChildren();
			
			// 노드의 자식들.
			for(Project child : children) {
				System.out.println(">>> child : " + child.getName());
				if(!doDFS(child,stack)) {
					return false;
				}
			}
			
			project.setState(Project.State.COMPLETE);
			System.out.println(project.getName() + " is complete and push stack");
			stack.push(project);
		}
		return true;
		
	}
	
	public static Stack<Project> orderProjects(ArrayList<Project> projects) {
		Stack<Project> stack = new Stack<Project>();
		
		// 그래프의 맨 위에노드.
		for(Project project : projects) {
			System.out.println("----------orderProjects method : " + project.getName() + "    " + project.getChildren().size());
			if(project.getState() == Project.State.BLANK) {
				if(!doDFS(project, stack)) {
					return null;
				}
			}
		}
		return stack;
	}
	
	
	
	public static Stack<Project> findBuildOrder(String projects[], String[][] dependencies) {
		Graph graph = buildGraph(projects,dependencies);
//		System.out.println("Graph : " + graph);
//		ArrayList<Project> arr = graph.getNodes();
//		for(Project pro : arr) {			
//			ArrayList<Project> child = pro.getChildren();
//			for(Project pp : child) {
//				System.out.println("graph : " + pro.getName() + " children : " + pro.getChildren().size() + " ******  child : " + pp.getName());
//			}
//		}
		return orderProjects(graph.getNodes());
	}
	
	public static String[] buildOrderWrapper(String projects[], String[][] dependencies) {
		Stack<Project> buildOrder = findBuildOrder(projects, dependencies);
		if(buildOrder == null) {
			System.out.println("buildOrder가 null 이다.");
			return null;
		}
		String[] buildOrderString = convertToStringList(buildOrder);
		return buildOrderString;
	}
	
	
	
	public static String[] convertToStringList(Stack<Project> projects) {
		String buildOrder[] = new String[projects.size()];
		System.out.println("convert : " + buildOrder.length);
		for(int i=0; i < buildOrder.length ; i++) {
			buildOrder[i] = projects.pop().getName();
		}
		return buildOrder;
	}

	public static void main(String[] args) {
		String[] projects = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
//		String[] projects = {"a", "b", "c"};
		String[][] dependencies = {
				{"a", "b"},  // [0][0] -> a
				{"b", "c"},
				{"a", "c"},
				{"d", "e"},
				{"b", "d"},
				{"e", "f"},
				{"a", "f"},
				{"h", "i"},
				{"h", "j"},
//				{"i", "j"}, //
				{"g", "j"}
				};
		String buildOrder[] = buildOrderWrapper(projects, dependencies);
		System.out.println();System.out.println();
		if(buildOrder == null) {
			System.out.println("Circular Dependency");
		} else {
			for(String s : buildOrder) {
				System.out.print(s + " -> ");
			}
		}
		
		

	}

}
