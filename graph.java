import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.lang.Integer;
import java.util.Comparator;
class graph{
    public static void main(String args[]){
        System.out.println("Hello");
        char nodes[] = {'A','B','C','D','E'}; 
        int a[][]  = { //adjacency matrix of graph nodes A,B,C,D,E
            {1,1,1,0,0},
            {0,1,0,0,1},
            {0,1,1,1,0},
            {0,0,0,1,1},
            {0,0,0,0,1}
        };

        // DFSTraversal(nodes,a);
        // BFSTraversal(nodes,a);
        // topologicalSort(a,nodes);

        

        // unweightedShortestPaths(a,nodes,0);


        int weights[][] = {
            {0,4,1,0,0},
            {0,0,0,0,4},
            {0,2,0,4,0},
            {0,0,0,0,4},
            {0,0,0,0,0}
        };

        // Node[] nodesWithPriority  = {new Node('A',0),new Node('B',0),new Node('C',0),new Node('D',0),new Node('E',0)};

        weightedShortestPaths(a,nodes,0,weights);

    }

    static void DFSTraversal(char nodes[],int a[][]){
        int visited[] = new int[nodes.length];
        for(int i=0;i<visited.length;i++){
            if(visited[i]==0){
                DFS(a,nodes,i,visited);
            }
        }

        for(int i=0;i<visited.length;i++){
            System.out.println(nodes[i]+" "+visited[i]);
        }
    }

    static void BFSTraversal(char nodes[],int a[][]){
        int visited[] = new int[nodes.length];
        for(int i=0;i<visited.length;i++){
            if(visited[i]==0){
                BFS(a,nodes,i,visited);
            }
        }

        // for(int i=0;i<visited.length;i++){
        //     System.out.println(nodes[i]+" "+visited[i]);
        // }
    }

    static void DFS(int a[][],char nodes[],int nodeIndex,int visited[]){
        visited[nodeIndex] = 1;
        System.out.println("Visited : "+nodes[nodeIndex]);
        for(int i=0;i<nodes.length;i++){
            if(a[nodeIndex][i]==1){
                if(visited[i]==0)DFS(a,nodes,i,visited);
            }
        }

    }

    static void BFS(int a[][],char nodes[],int nodeIndex,int visited[]){
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.add(nodeIndex);
            while(queue.size()>0){
                int currentNodeIndex = queue.remove();
                visited[currentNodeIndex] = 1;
                System.out.println("Visited : "+nodes[currentNodeIndex]);
                for(int i=0;i<nodes.length;i++){
                    if(a[currentNodeIndex][i] == 1 && visited[i]==0){
                        queue.add(i);
                    }
                }
            }
    }


    static void topologicalSort(int a[][],char nodes[]){
        int[] inDegree = new int[nodes.length];
        int[] topologicalOrder = new int[nodes.length];
        int counter=0;
        for(int i=0;i<nodes.length;i++){
            for(int j=0;j<nodes.length;j++){
                if((a[i][j] == 1) && (i!=j)) inDegree[j]++;
            }
        }
        for(int i=0;i<nodes.length;i++){
            System.out.println("In degree : "+nodes[i] +" - "+ inDegree[i]);
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0;i<nodes.length;i++){
            if(inDegree[i]==0)queue.add(i);
        };
        while(queue.size()>0){
            int node = queue.remove();
            topologicalOrder[node] = counter++;
            for(int i=0;i<nodes.length;i++){
                if(a[node][i] == 1){
                    if(--inDegree[i]==0){
                        queue.add(i);
                    }
                }
            }
        }
        for(int i=0;i<nodes.length;i++){
            System.out.println("Topological order of  : "+nodes[i] +" - "+ topologicalOrder[i]);
        }
    }

    static void unweightedShortestPaths(int a[][],char nodes[],int fromNodeIndex){
        int[] distance = new int[nodes.length];
        int[] path = new int[nodes.length];
        for(int i=0;i<nodes.length;i++)distance[i]=-1;
        distance[fromNodeIndex]=0;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(fromNodeIndex);
        while(queue.size()>0){
            int node = queue.remove();
            for(int i=0;i<nodes.length;i++){
                if(a[node][i] == 1){
                    if(distance[i] == -1){
                        distance[i] = distance[node]+1;
                        path[i] = node;
                        queue.add(i);
                    }
                }
            }
        }

        for(int i=0;i<nodes.length;i++){
            System.out.println("Path of  : "+nodes[i] +" - "+ nodes[path[i]]);
        }

         for(int i=0;i<nodes.length;i++){
            System.out.println("Distance of  : "+nodes[i] +" - "+ distance[i]);
        }
    }


      static void weightedShortestPaths(int a[][],char nodes[],int fromNodeIndex,int weights[][]){ //Dijkstra's Alogrithm using distance and paths array , without using priority queues
//        int[] path = new int[nodes.length];
//        int[] distance = new int[nodes.length];
//        int[] visited = new int[nodes.length];
//        for(int i=0;i<distance.length;i++)distance[i] = Integer.MAX_VALUE;
//        PriorityQueue<Node> queue  = new PriorityQueue<Queue>(new Node());
//        queue.add(new Node(fromNodeIndex,0));
//        while(queue.size()>0){
//
//        }
      }

      static class Node implements Comparator<Node>{
          int index;
          int cost;
          Node(int value,int cost){
              this.index = value;
              this.cost = cost;
          }

        @Override
        public int compare(Node node1, Node node2) 
        { 
            if (node1.cost < node2.cost) 
                return -1; 
            if (node1.cost > node2.cost) 
                return 1; 
            return 0; 
        } 
      }
    
}