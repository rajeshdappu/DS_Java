import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
import java.lang.*;
class binaryTree {
    public static void main(String args[]){
        System.out.println("Hello");

        Node head = createSampleTree();

        // preOrder(head);

        // levelOrder(head);

        zigzagOrder(head);
    }

    static Node createSampleTree(){
        Node n4 = new Node(4,null,null);
        Node n5 = new Node(5,null,null);
        Node n6 = new Node(6,null,null);
        Node n7 = new Node(7,null,null);
        Node n2 = new Node(2,n4,n5);
        Node n3 = new Node(3,n6,n7);
        return new Node(1,n2,n3);
    }

    static void levelOrder(Node head){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(head);
        while(queue.size()>0){
            Node root = queue.remove();
            System.out.println(root.data);
            if(root.left !=null)
                queue.add(root.left);
            if(root.right !=null)
                queue.add(root.right);    
       }
    }

    static void zigzagOrder(Node head){
        
        Stack<Node> curentLevelStack =  new Stack<Node>();
        Stack<Node> nextLevelStack =  new Stack<Node>();
        curentLevelStack.push(head);

        int leftToRight = 1 ;

        while(curentLevelStack.size()>0){
            Node temp = curentLevelStack.pop();
            if(temp!=null){
                System.out.println(temp.data);
                if(leftToRight == 1){
                    nextLevelStack.push(temp.left);
                    nextLevelStack.push(temp.right);
                }else{
                    nextLevelStack.push(temp.right);
                    nextLevelStack.push(temp.left);
                }
            }
            if(curentLevelStack.size()==0){
                leftToRight = 1- leftToRight;
                Stack tempStack = curentLevelStack;
                curentLevelStack = nextLevelStack;
                nextLevelStack = tempStack;
            }
        }
    }

    static void preOrder(Node head){
        if(head!=null){
            System.out.println(head.data);
            preOrder(head.left);
            preOrder(head.right);
        }
    }
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}