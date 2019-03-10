class avl {
    public static void main(String args[]){
        Node root = null ;

        root = insert(root,2);
        root = insert(root,4);
        root = insert(root,5);
        root = insert(root,6);
        root = insert(root,7);
        root = insert(root,8);
        // root = insert(root,7);
        // root = insert(root,8);
        // root = insert(root,9);
        // root = insert(root,10);
        // root = insert(root,11);
        // root = insert(root,12);

        inorder(root);

        System.out.println("Height : "+height(root));
        
        postorder(root);
        

    }

    static Node insert(Node root,int data){
        if(root == null){
            root = new Node(data);
            root.left = null;
            root.right = null;
            root.height = 0;
        }else if(data < root.data){
            root.left = insert(root.left,data);
            if(height(root.left) - height(root.right) == 2){
                if(data < root.left.data){
                    root = LL(root);
                }else{
                    root = LR(root);
                }
            }
        }else if(data > root.data){
            root.right = insert(root.right,data);
            if(height(root.right) - height(root.left) == 2){
               if(data > root.height){
                   root = RR(root);
               }else{
                   root = RL(root);
               }
            }
        }

        int lHeight = height(root.left);
        int rHeight = height(root.right);
        root.height = (lHeight > rHeight ? lHeight : rHeight)+1;
        return root;
    }

    static int height(Node root){
        if(root == null) return 0;
        else {
            int lHeight = height(root.left);
            int rHeight = height(root.right);

            if(lHeight > rHeight) return lHeight+1;
            else return rHeight + 1;
        }
    }

    static Node LL(Node root){
        if(root == null) return root;
        else {
            Node w = root.left;
            root.left = w.right;
            w.right = root;
            return w;
        }    
    }

    static Node RR(Node root){
        if(root == null) return root;
        else {
            Node x = root.right;
            root.right = x.left;
            x.left = root;
            return x;
        }
    }

    static Node LR(Node root){
        if(root == null) return null;
        root = LL(root);
        root = RR(root);
        return root;
    }

    static Node RL(Node root){
        if(root == null) return null;
        root = RR(root);
        root = LL(root);
        return root;
    }

    static void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
    }

    static void postorder(Node root){
        if(root!=null){
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.data);
        }
    }


    static class Node{
        int data;
        Node left,right;
        int height = 0;
        Node(int data){
            this.data = data;
        }
    }
}