import java.util.*;

class MSTPrims{


    void primsAlgo(int[][]graph){
        int V = graph.length;
        int[] keys = new int[V];
        boolean mSet[] = new boolean[V];
        int[] parents = new int[V];
        int res=0;

        Arrays.fill(keys, Integer.MAX_VALUE);
        keys[0] = 0;
        Arrays.fill(parents, -1);
        for(int i=0;i<V;i++){
            int min = Integer.MAX_VALUE;
            int u = 0;
            if(mSet[i]==false &&  keys[i]<min){
                min = keys[i];
                u = i;
            }


            mSet[u]=true;
            res+=keys[u];
            for(int v=0;v<V;v++){
                if(graph[u][v]!=0 && mSet[v]==false && graph[u][v]<keys[v]){
                    parents[v] = u;
                    keys[v] = graph[u][v];
                }
            }
            }

            System.out.println("Edge \tWeight");
		for (int i =1;i<V;i++){
			System.out.println(parents[i] + " - " + i + " \t"+ graph[i][parents[i]]);
			
		}	

		System.out.println("Final Answer for PRIMS MST is : "+res);


        }
        
}




public class A3f {
    public static void main(String[] args){
        int[][] graph = {
            {0,2,0,5,0},
            {2,0,3,4,5},
            {0,3,0,0,7},
            {5,4,0,0,0},
            {0,5,7,0,0}
        };
        MSTPrims pt = new MSTPrims();
        pt.primsAlgo(graph);
    }
}


// We have discussed Kruskal’s algorithm for Minimum Spanning Tree. Like Kruskal’s algorithm, Prim’s algorithm is also a Greedy algorithm. It starts with an empty spanning tree. The idea is to maintain two sets of vertices. The first set contains the vertices already included in the MST, the other set contains the vertices not yet included. At every step, it considers all the edges that connect the two sets, and picks the minimum weight edge from these edges. After picking the edge, it moves the other endpoint of the edge to the set containing MST. 
// A group of edges that connects two set of vertices in a graph is called cut in graph theory. So, at every step of Prim’s algorithm, we find a cut (of two sets, one contains the vertices already included in MST and other contains rest of the vertices), pick the minimum weight edge from the cut and include this vertex to MST Set (the set that contains already included vertices).

// How does Prim’s Algorithm Work? The idea behind Prim’s algorithm is simple, a spanning tree means all vertices must be connected. So the two disjoint subsets (discussed above) of vertices must be connected to make a Spanning Tree. And they must be connected with the minimum weight edge to make it a Minimum Spanning Tree.

// Algorithm 
// 1) Create a set mstSet that keeps track of vertices already included in MST. 
// 2) Assign a key value to all vertices in the input graph. Initialize all key values as INFINITE. Assign key value as 0 for the first vertex so that it is picked first. 
// 3) While mstSet doesn’t include all vertices 
// ….a) Pick a vertex u which is not there in mstSet and has minimum key value. 
// ….b) Include u to mstSet. 
// ….c) Update key value of all adjacent vertices of u. To update the key values, iterate through all adjacent vertices. For every adjacent vertex v, if weight of edge u-v is less than the previous key value of v, update the key value as weight of u-v
// The idea of using key values is to pick the minimum weight edge from cut. The key values are used only for vertices which are not yet included in MST, the key value for these vertices indicate the minimum weight edges connecting them to the set of vertices included in MST. 