
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.*;
import java.util.Random;

class priorityQueue{
    public static void main(String args[]){

//        Queue<Integer> q = new PriorityQueue<Integer>(7,new CustomerComparator());
//        Random rand = new Random();
//		for(int i=0;i<7;i++){
//			q.add(new Integer(rand.nextInt(100)));
//		}
//
//        for(int i=0;i<7;i++){
//			System.out.println(q.remove());
//		}

    }


   


    public static class Customer {
        
        private int id;
        private String name;
        
        public Customer(int i, String n){
            this.id=i;
            this.name=n;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
        
    }

    static class CustomerComparator implements Comparator<Customer>{
            @Override
            public int compare(Customer a, Customer b){
                return (int) (a.getId() - b.getId());
            }
    }


}