import java.util.Queue;
import java.util.LinkedList;
class graph{
    public static void main(String args[]){
        System.out.println("Hello");
        char nodes[] = {'A','B','C','D','E'}; 
        int a[][]  = { //adjacency matrix of graph nodes A,B,C,D,E
            {1,0,1,0,0},
            {0,1,0,0,0},
            {0,1,1,1,0},
            {0,0,0,1,1},
            {0,0,0,0,1}
        };

        // DFSTraversal(nodes,a);
        BFSTraversal(nodes,a);

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
}