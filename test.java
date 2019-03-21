class test{


    public static void main(String args[]){




       System.out.println(multiply("222","444"));
    }

    static String multiply(String s1, String s2) {
        int tens = 0;
        String multSum = "";
        for(int i=s1.length()-1;i>=0;i--){
            String singleMult = singleDigitMult(s2,getInt(s1.charAt(i)));
            for(int t=0;t<tens;i++)singleMult=singleMult+"0";
            multSum = SUM(singleMult,multSum);
            tens+=1;
        }
        return multSum+"";
    }
    
   static int getInt(char c){
        return c - '0';
    }
    
    static String singleDigitMult(String s,int n){
        String sum="";
        int carry=0;
        int tens = 0;
        for(int i=s.length()-1;i>=0;i--){
            int val = n*getInt(s.charAt(i))+carry;

            String valueToAdd = (val%10)+"";
            for(int t=0;t<tens;t++)valueToAdd = valueToAdd+"0";
            sum = SUM(valueToAdd,sum);
            carry = val/10;
            tens+=1;
        }
        if(carry>0){
            String valueToAdd = carry+"";
            for(int i=0;i<tens;i++)valueToAdd = valueToAdd+"0";
            sum =  SUM(valueToAdd, sum);
        }
        return sum;
    }
    
    static String SUM(String s1,String s2){
        String sum = "";
        int ls1=s1.length()-1;
        int ls2=s2.length()-1;
        int carry=0;
        while(ls1>=0 || ls2>=0){
            int digitSum = 0;
            if(ls1>=0){
                digitSum = digitSum+(getInt(s1.charAt(ls1--)));
            }
            if(ls2>=0){
                digitSum = digitSum+(getInt(s2.charAt(ls2--)));
            }
            digitSum = digitSum + carry;
            sum = ((digitSum%10))+sum;
            carry = digitSum/10;
        }
        if(carry>0)return carry+sum;
        else return sum;
    }
}