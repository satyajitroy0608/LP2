import java.io.IOException;
import java.util.*;

class Graph{
    int v,e;

    ArrayList<ArrayList<Integer>> adjList;
    Graph(int v,int e){
        this.v = v;
        this.e=e;
        adjList = new ArrayList<>(v);
        for(int i=0;i<v;i++){
            adjList.add(new ArrayList<Integer>());
        }

    }
    void addEdge(int source,int destination){
        adjList.get(source).add(destination);
        adjList.get(destination).add(source);
    }

    void sortAdjList(){
        for(int i=0;i<adjList.size();i++){
            Collections.sort(adjList.get(i));
        }
    }

    void bfs(boolean[] visited,Queue<Integer>q,int sourceVertex,ArrayList<Integer> res){

        while(!q.isEmpty()){
            int currentVertex = q.poll();
            res.add(currentVertex);
            for(int v : adjList.get(currentVertex)){
                if(visited[v]==false){
                    visited[v]=true;
                    q.add(v);
                }
            }

        }
        



    }

    void bfsHelper(){
        boolean visited[] = new boolean[v];
        Arrays.fill(visited,false);
        Queue<Integer> q = new LinkedList<>();
        this.sortAdjList();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<v;i++){
            if(visited[i]==false){
                visited[i]=true;
                q.add(i);
                bfs(visited,q,i,res);
            }
        }

        System.out.println("BFS Traversal: ");

        for(int v : res){
            System.out.print(v+"  ");
        }
    }

    void dfs(boolean[] visited, int sourceVertex, ArrayList<Integer> res){
        visited[sourceVertex]= true;
        res.add(sourceVertex);
        for(int v : adjList.get(sourceVertex)){
            if(visited[v]==false){
                dfs(visited,v,res);
            }
        }
    }

    
    void dfsHelper(){

        boolean[] visited = new boolean[v];
        Arrays.fill(visited,false);
        this.sortAdjList();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<v;i++){
            if(visited[i]==false){
                dfs(visited,i,res);
            }
        }

        System.out.println("DFS Traversal: ");
        for(int v: res){
            System.out.print(v+"  ");
        }


    }



}






public class a1 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter total Vertices : ");
        int v = sc.nextInt();
        System.out.println("Enter total Edges : ");
        int e = sc.nextInt();

        Graph G1 = new Graph(v,e);
        for(int i=0;i<G1.e;i++) {
            System.out.println("Enter Source :");
            int source = sc.nextInt();
            System.out.println("Enter Destination");
            int destination = sc.nextInt();
            G1.addEdge(source,destination);
        }
        G1.bfsHelper();
        System.out.println();
        G1.dfsHelper();
        

    }
}

// Breadth-first search (BFS) is an algorithm for searching a tree data structure for a node that satisfies a given property. It starts at the tree root and explores all nodes at the present depth prior to moving on to the nodes at the next depth level. Extra memory, usually a queue, is needed to keep track of the child nodes that were encountered but not yet explored.


// The algorithm works as follows:

// Start by putting any one of the graph's vertices at the back of a queue.
// Take the front item of the queue and add it to the visited list.
// Create a list of that vertex's adjacent nodes. Add the ones which aren't in the visited list to the back of the queue.
// Keep repeating steps 2 and 3 until the queue is empty.





// Depth-first search (DFS) is an algorithm for traversing or searching tree or graph data structures. The algorithm starts at the root node (selecting some arbitrary node as the root node in the case of a graph) and explores as far as possible along each branch before backtracking.

// Create a recursive function that takes the index of the node and a visited array.

// Mark the current node as visited and print the node.
// Traverse all the adjacent and unmarked nodes and call the recursive function with the index of the adjacent node.