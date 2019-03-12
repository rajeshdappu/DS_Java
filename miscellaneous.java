class miscellaneous {
    public static void main(String args[]){
        System.out.println(subtractWithoutArithmatic(10,10));
        System.out.println(addWithoutArithmatic(10,10));
    }

    static int  addWithoutArithmatic(int a,int b){
        while(b!=0){
            int carry = a&b;
            // System.out.println("c - "+carry);
            a = a^b;
            // System.out.println("s - "+a);
            b = carry<<1;
        }
        return a;
    }

    static int subtractWithoutArithmatic(int a,int b){
        return addWithoutArithmatic(a,~b+1); // ~b is the b's 1's complement, ~b+1 is b's 2's compliment which is equal to -b
    }
}