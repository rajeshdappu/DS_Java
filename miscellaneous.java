class miscellaneous {
    public static void main(String args[]){
        // System.out.println(subtractWithoutArithmatic(10,10));
        // System.out.println(addWithoutArithmatic(10,10));
        int a[] = {0,0,1,1,0,0,0,0,0,0,1,1,0,0,0};
        seggregate0s1s(a);
    }

    // static int  addWithoutArithmatic(int a,int b){
    //     while(b!=0){
    //         int carry = a&b;
    //         // System.out.println("c - "+carry);
    //         a = a^b;
    //         // System.out.println("s - "+a);
    //         b = carry<<1;
    //     }
    //     return a;
    // }

    // static int subtractWithoutArithmatic(int a,int b){
    //     return addWithoutArithmatic(a,~b+1); // ~b is the b's 1's complement, ~b+1 is b's 2's compliment which is equal to -b
    // }

    static void seggregate0s1s(int a[]){

        print(a);
        int start =0;
        int end = a.length - 1;
        while(start!=end){
            while(a[start]==0 && start<end )start++;
            while(a[end]==1 && start<end )end--;
            int temp = a[start];
            a[start]=a[end];
            a[end]=temp;
        }

        print(a);
    }

    static void print(int a[]){
        System.out.println();
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+",");
        }
        System.out.println();
    }
}