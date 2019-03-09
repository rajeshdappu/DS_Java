import java.util.Scanner;
class LinkedList {
    public static void main(String args[]){
        Node head = new Node(10);
        insert(head,10);

        insert(head,1);
        insert(head,10);
        insert(head,2);
        insert(head,40);
        insert(head,20);
        insert(head,50);
        insert(head,6);
        insert(head,9);

        // Scanner sc = new Scanner(System.in);
        // int i = sc.nextInt();
        // insert(head,i);

        // head = reverseList(head);
        head = reverseListRec(head,null);
                printList(head);

    }

    static void printList(Node head){
        while(head!=null){
            System.out.print(head.data +" -> ");
            head = head.next;
        }
        System.out.println();
    }


    static void insert(Node head,int data){
        Node newNode =  new Node(data);
        Node temp = head;
        if(temp == null)head = temp;
        else {
            while(temp.next != null) temp = temp.next;
            temp.next = new Node(data);
        }
    }


    static Node reverseList(Node head){

        // if(head == null)return null;
        // else {
        //     temp = head;
        //     head.next = head;
        //     head  = temp;
        //  head = reverseList(head.next);
        //  return head.next;
        // }

        Node reverseList = null;

        while(head!=null){
            Node nextNode = head.next;
            head.next = reverseList;
            reverseList = head;
            head = nextNode;            
        }

        return reverseList;
    }

    static Node reverseListRec(Node head,Node reverse){
        if(head.next == null){
            head.next = reverse;
            return head;
        }
            Node nextNode = head.next;
            head.next = reverse;
            reverse = head;
        return reverseListRec(nextNode,reverse);
            
        
    }

   static class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }
}