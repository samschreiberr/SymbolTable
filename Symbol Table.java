public class SymbolTable <Key extends Comparable<Key>, Value>{
    public static void main(String[] args){

    }
    private class Node{
        private Node(Key k, Value v){
            Key key = k;
            Value value = v;
            Node left = left();
            Node right = right();
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
    public int size(Value v){

    }
    public Key select(Value v){

    }
    public Value rank(Key k){

    }
    public void delete(Key k){
        Node root = delete(root(k));
    }
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
            if(x.right == null) return x.left;
            if(x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
    }
}