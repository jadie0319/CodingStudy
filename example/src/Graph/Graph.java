package Graph;

import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;


/**
 * Created by choijaeyong on 2016. 3. 22..
 */
public class Graph {

    private final int maxVertices=20;
    private Vertex vertexList[];
    private int adjMatrix[][];
    private int vertexCount;
    private Stack theStack;
    private Queue theQueue;

    public Graph() {
        vertexList = new Vertex[maxVertices];
        adjMatrix = new int[maxVertices][maxVertices];
        vertexCount=0;
        for(int y=0 ; y<maxVertices ; y++) {
            for(int x=0; x < maxVertices ; x++) {
                adjMatrix[x][y]=0;
            }
        }
        theStack= new Stack();
        theQueue= new LinkedList<Integer>();
    }

    public void addVertex(char lab) {
        vertexList[vertexCount++] = new Vertex(lab);
    }
    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }
    public void displayVertex(int v) {
        System.out.println(vertexList[v].label);
    }

    public void dfs() {
        vertexList[0].visited = true;
        System.out.println("vertexCount : " + vertexCount);
        displayVertex(0);
        theStack.push(0);
        while(!theStack.isEmpty()) {
            int v = getAdjUnvisitedVertex((int)theStack.peek());
            if(v==-1) {
                theStack.pop();

            }else{
                vertexList[v].visited = true; //a방문
                displayVertex(v); //a출력

                theStack.push(v);  //여기가 잘못됌
            }
        }

        for(int j=0; j<vertexCount ; j++) {
            vertexList[j].visited = false;
        }
    }

    public void bfs() {
        vertexList[0].visited = true;
        displayVertex(0);
        theQueue.offer(0);
        int v2=0;
        while(!theQueue.isEmpty()) {
            int v1= (Integer)theQueue.poll();
            while((v2=getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].visited = true;
                displayVertex(v2);
                theQueue.offer(v2);
            }
        }
        for(int j=0 ; j<vertexCount ; j++) {
            vertexList[j].visited = false;
        }

    }




    public int getAdjUnvisitedVertex(int v) {
        for(int j=0; j < vertexCount ; j++) {
            if(adjMatrix[v][j] ==1 && vertexList[j].visited==false) {
                return j;
            }
        }
        return -1;
    }



}
