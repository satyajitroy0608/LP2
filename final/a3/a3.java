import java.util.*;

class DijsktraSP{
	void dijsktraAlgo1(int graph[][]){
		int V = graph.length;
		int dist[] = new int[V];
		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[0] = 0;
		boolean mSet[] = new boolean[V];

		for(int count=0;count<V;count++){

			int minIndex = -1;
			for(int x = 0; x<V;x++){
				if(!mSet[x] && (minIndex ==-1 || dist[x] < dist[minIndex])){
					minIndex =  x;
				}
			}

			mSet[minIndex] = true;

			for(int v = 0 ; v <V ; v++){

				if(!mSet[v] && graph[minIndex][v]!=0 && dist[minIndex]+graph[minIndex][v] < dist[v]){
					dist[v] = dist[minIndex]+graph[minIndex][v];
				}
			}

			


		}

		System.out.println("Vertex \t\t Distance from Source");
        	for (int i = 0; i < V; i++){
            System.out.println(i + " \t\t " + dist[i]);
			}




	}
}


class PrimsMST{
	
	void primsAlgo2(int graph [][]){
		int V = graph.length;
		int keys [] = new int [V];
		int res = 0;
		int parents[]  = new int [V];
		Arrays.fill(keys, Integer.MAX_VALUE);
		keys[0] = 0;
		Arrays.fill(parents, -1);
		boolean mSet[] = new boolean[V];

		for(int count =0 ; count <V;count ++){
			int u = -1;
			for (int i =0;i<V;i++){
				if(!mSet[i] && (u==-1 || keys[i]<keys[u])){
					u = i;
				}
			}
			mSet[u] = true;
			res += keys[u];

			for(int v = 0; v<V;v++){
				if(!mSet[v]&& graph[u][v] != 0 && graph[u][v] < keys[v]){
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
class SelectionSort{

	void swap(int [] arr,int a , int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b]=temp;
	}

	void SelectionSortFunc(int[] arr){
		for(int i=0;i<arr.length;i++){
			int minIndex = i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[minIndex]){
					minIndex = j;
				}
			}
			swap(arr, minIndex, i);
		}
	}

}


public class a3 {
	
	
	
	public static void main(String args[]) {
		
		boolean run = true;
        Scanner sc = new Scanner(System.in);
        while(run){

            int input;
            System.out.println("***MENU*** \n1.Selection Sort\n2.Prims\n3.Dijsktra\n4.Exit");  
            
            input = sc.nextInt();

            switch(input){
                case 1:
					
					System.out.print("Enter No. of Elements : ");
					int count = sc.nextInt();
					int arr[] = new int [count];
					System.out.println("Enter the Nos. : ");
					for(int i=0;i<count;i++){
						arr[i] = sc.nextInt();
					}

					System.out.println("Array before Sorting : ");
					System.out.println(Arrays.toString(arr));					
					SelectionSort t = new SelectionSort();
					t.SelectionSortFunc(arr);
					System.out.println("Array after Sorting :");
					System.out.println(Arrays.toString(arr));


                    break;

                case 2:


					int [][] graph = { { 0, 2, 0, 6, 0 },
									   { 2, 0, 3, 8, 5 },
									   { 0, 3, 0, 0, 7 },
									   { 6, 8, 0, 0, 9 },
									   { 0, 5, 7, 9, 0 } };

					PrimsMST pt = new PrimsMST();
					pt.primsAlgo2(graph);

					
                    break;
                
				case 3:


				int graph1[][] = { { 0, 2, 0, 6, 0 },
				{ 2, 0, 3, 8, 5 },
				{ 0, 3, 0, 0, 7 },
				{ 6, 8, 0, 0, 9 },
				{ 0, 5, 7, 9, 0 } };

				DijsktraSP spt = new DijsktraSP();
				spt.dijsktraAlgo1(graph1);
                    break;

                case 4:
                    run = false;
                    break;
            }
            

        }
        sc.close();
		
		
		
	}

}
