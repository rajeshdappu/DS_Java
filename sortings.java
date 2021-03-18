public class sortings{
    public static void main(String args[]){
        int[] a = {10,3,4,1,2,4,3,6,2,5,66};
         bubbleSort(a);
         selectionSort(a);
//        insertionSort(a);
    }

    static void bubbleSort(int a[]){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length-1-i;j++){
                if(a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j]=a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        print(a);
    }

    static void selectionSort(int a[]){

        for(int i=0;i<a.length;i++){
            int minIndex = i;
            for(int j=i+1;j<a.length;j++){
                if(a[j]<a[minIndex]){
                    minIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }

        print(a);
    }

     static void insertionSort(int a[]){
         for(int i=1;i<a.length;i++){
             int j = i-1;
             while(j>0 && a[j] > a[j-1]);
         }
         print(a);
     }

    static void print(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}