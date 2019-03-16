import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.lang.Integer;
import java.util.Comparator;
class DP{
    public static void main(String args[]){
        System.out.println(LCS("rajesh".toCharArray(),"ramesh".toCharArray()));
    }

    static int LCS(char a[],char b[]){
        int lcs[][] = new int[a.length+1][b.length+1];
        for(int i=0;i<=a.length;i++){
            for(int j=0;j<=b.length;j++){
                if(i==0 || j==0) lcs[i][j] = 0;
                else if(a[i-1] == b[j-1]) lcs[i][j] = lcs[i-1][j-1]+1;
                else {
                    int a1 = lcs[i-1][j];
                    int b1= lcs[i][j-1];
                    if(a1>b1) lcs[i][j] = a1;
                    else lcs[i][j] = b1;
                }
            }
        }

        return lcs[a.length][b.length];
    }
    
}