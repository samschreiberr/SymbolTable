public class SymbolTable <Key extends Comparable<Key>, Value>{
    Node root;
    public static void main(String[] args){

    }
    private class Node{
        private Node(Key k, Value v){
            Key key = k;
            Value value = v;
            Node left = left();
            Node right = right();
            int size = size();
        }
    }
    private Node left(Node x){

    }
    private Node right(Node x){

    }
    public void put(Value v){

    }
    private Node root(Node x, Key k){

    }
    private Node root(Node x){

    }
    public int size(Key k){

    }
    private int size(Node x){
        return x.size;
    }
    public Key select(Value v){

    }
    public Value rank(Key k){

    }
    public void delMin(){
        root = delMin(root);
    }
    private Node delMin(Node x){
        if(x == null) return null;
        if(x.left == null) return x.right;
        x.left = delmin(x.left);
        x.size = size(x.left) + size(x.right) +1;
        return x;
    }
    public void delete(Key k){
        root = delete(root, k);
    }
    //t = "to delete"
    //x = "suXessor"
    private Node delete(Node x, Key k){
        if(x == null) return null;
        int cmp = k.compareTo(x.key);
        if(cmp < 0){
            x.left = delete(x.left, k);
        }
        else if(cmp > 0){
            x.right = delete(x.right, k);
        }
        else{
            if(x.left == null) return x.right;
            if(x.right == null) return x.left;
            Node t = x;
            x = min(t.right);
            //sets right equal to thing you want and also deletes x and fixes order of right subtree
            x.right = delMin(t.right);
            x.left = t.left;
            x.size = size(x.left) + size(x.right) + 1;

        }
    }
}