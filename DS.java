import java.util.Scanner;
import java.util.Stack;
class DS {
    public static void main(String args[]){
        Stack st = new Stack();
        st.push(10);
        st.pop(); //Returns the element on the top of the stack, removing it in the process.
        st.seach(10); // Returns the element on the top of the stack, but does not remove it.
        st.peek(); //returns top element
        st.empty();//Tests if this stack is empty. Returns true if the stack is empty, and returns false if the stack contains elements.

        System.out.println(st.pop());
        try{
             st.pop();
        }catch(Exception e){
            e.printStackTrace();
        }
    }   
}