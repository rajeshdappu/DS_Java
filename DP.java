import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.lang.Integer;
import java.util.Comparator;
class DP{
    public static void main(String args[]){
        System.out.println(LongestCommonSubsequence("rajesh".toCharArray(),"ramesh".toCharArray()));
    }

    static int LongestCommonSubsequence(char a[],char b[]){
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

     public String LongestPolyndromicSubString(char a[]){
        if(a.length==0) return null;
        if(a.length ==1)return a[0]+"";
        int l = a.length;
        boolean L[][] = new boolean[l][l];
        for(int i=0;i<l;i++){
            L[i][i] = true;
        }
        
        for(int i=0;i<l-1;i++){
            if(a[i]==a[i+1]) L[i][i+1] = true;
        }
        
        for(int i=0;i<l;i++){
            for(int j=i;j<l;j++){
                if(j-i > 2){
                     if(a[i] == a[j] && L[i+1][j-1]==true){
                        L[i][j] = true;
                    }
                }
            }
        }
        
        int max = 0;
        int start=0;
        int end = 0;
        
        for(int i=0;i<l;i++){
            for(int j=i;j<l;j++){
                if(L[i][j] && max < j-i){
                    max = j-i;
                    start=i;
                    end = j;
                }
            }
        }
        
        return String.valueOf(a).substring(start,end+1);
    }


    
}