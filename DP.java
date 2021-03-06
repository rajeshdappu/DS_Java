import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.lang.Integer;
import java.util.Comparator;
class DP{
    public static void main(String args[]){

        // System.out.println(LpngestPolindromicSubsequence("ccc".toCharArray()));
        // int[] a ={40, 20, 30, 10, 30}  ; //
        // System.out.println(matrixProductParanthesization(a));

       int  val[] = {10, 40, 50, 70};
       int wt[]  = {1, 3, 4, 5} ;


    //    System.out.println(unBoundedKnapsack(wt,val,8));

    int[] a = {5,6,2,3,4,1,9,9,8,9,5};
    //    System.out.println(longestIncreasingSubsequence(a));

       System.out.println(longestValidParentheses(")()())"));
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

     static String LongestPolyndromicSubString(char a[]){
         if(a.length==0) return "";
        if(a.length ==1)return a[0]+"";
        int l = a.length;
        boolean L[][] = new boolean[l][l];
        for(int i=0;i<l;i++){
            L[i][i] = true;
        }
        
        for(int i=0;i<l-1;i++){
            if(a[i]==a[i+1]) L[i][i+1] = true;
        }
        
        for(int j=3;j<l;j++){
            for(int i=0;i<j;i++){
                if(j-i >= 2){
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

    static int matrixProductParanthesization(int p[]){

        int n = p.length-1;

        int[][] M = new int[n+1][n+1];

        int[][] paranthesis = new int[n+1][n+1];

        
        for(int l=2;l<=n;l++){
            for(int i=1;i<=n-l+1;i++){
                int j=i+l-1;
                System.out.println(i+"  "+j);
                M[i][j]  = Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int cost = M[i][k]+M[k+1][j]+(p[i-1]*p[k]*p[j]);
                    if(cost<M[i][j]){
                        M[i][j] = cost;
                        paranthesis[i][j] = k ;
                    } 
                }
            }
        }

        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(paranthesis[i][j]>0){
                    System.out.println("Paranthesis of "+i+","+j+" is "+paranthesis[i][j]);
                }
            }
        }

        
        return M[0+1][n];
    }

    public static  String LpngestPolindromicSubsequence(char a[]){
        if(a.length==0) return "";
        if(a.length ==1)return a[0]+"";
        int l = a.length;
        boolean L[][] = new boolean[l][l];
        for(int i=0;i<l;i++){
            L[i][i] = true;
        }
        
        for(int i=0;i<l-1;i++){
            if(a[i]==a[i+1]) L[i][i+1] = true;
        }
        
        for(int p=2;p<=l;p++){
            for(int q=0;q<l-p+1;q++){
                int i=q,j=q+p-1;
                if(j-i >= 2){
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
                if(L[i][j]==true  && (max < j-i)){
                    max = j-i;
                    start = i;
                    end = j;
                }
            }
        }
        
        return String.valueOf(a).substring(start,end+1);
    }
    
    static int max(int a, int b){
        return a>b ?a:b;
    }

    static int longestIncreasingSubsequence(int a[]){
        if(a.length < 2) return a.length;
        int[] lengths = new int[a.length];
        for(int i=0;i<lengths.length;i++)lengths[i]=1;
        for(int i=1;i<lengths.length;i++){
            for(int j=0;j<i;j++){
                if(a[i]>a[j] && lengths[i]<lengths[j]+1){
                    lengths[i] = lengths[j]+1;
                }
            }
        }
        int max=0;
        for(int i=1;i<lengths.length;i++){
            System.out.print(lengths[i] +" ");
            if(max<lengths[i])max=lengths[i];
        }

        for(int i=1;i<lengths.length;i++){
          if(lengths[i] == max){
              int maxTillNow = i;
              System.out.println(a[i]);
              for(int j=i;j>=0;j--){
                  if(a[j]<a[maxTillNow]){
                      maxTillNow = j;
                      System.out.println(a[j]);
                  }
              }
          }
        }
        return max;
    }


    static int longestValidParentheses(String s){
        char[] a = s.toCharArray();
        return 0;
    }
}