import java.util.*;
class trie{
    public static void main(String args[]){
        System.out.println("Hello");

        TrieNode root = new TrieNode(' ');

        trie t = new trie();

        t.insert(root,"Hello");

        System.out.println(t.search(root,"Hell"));
        System.out.println(t.search(root,"Hello")); 
        t.remove(root,"Hello");
        System.out.println(t.search(root,"Hello"));        
               
        
    }

    boolean search(TrieNode root,String word){
        TrieNode current = root;
        for(char ch: word.toCharArray()){
            if(current.subNode(ch)==null) return false;
            else current = current.subNode(ch);
        }
        return current.isEnd;
    }

    void insert(TrieNode root, String data){
        TrieNode current = root;
        for(char ch: data.toCharArray()){
            TrieNode subNode = current.subNode(ch);
            if(subNode!=null){
                current =subNode;
            }else{
                current.childs.add(new TrieNode(ch));
                current = current.subNode(ch);
            }
            current.count++;
        }
        current.isEnd = true;
    }

    void remove(TrieNode root,String word){
        if(search(root,word) == false) return ;
        else {
            TrieNode current = root;
            for(char ch: word.toCharArray()){
                TrieNode subNode = current.subNode(ch);
                if(subNode.count==1){
                    current.childs.remove(subNode);
                    return;
                }else{
                    subNode.count--;
                    current = subNode;
                }
            }
            current.isEnd = false;
        }
    }



    static class TrieNode{
        char data;
        int count=0;
        List<TrieNode> childs ;
        boolean isEnd = false;
        TrieNode(char c){
            this.data = c;
            childs = new ArrayList();
        }
        TrieNode subNode(char c){
            for(TrieNode child: childs){
                if(child.data == c) return child;
            }
            return null;
        }
    }
}