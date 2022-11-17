public class SymbolTable <Key extends Comparable<Key>, Value>{
    Node root;
    private class Node{
        private Node(Key k, Value v){
            Key key = k;
            Value value = v;
            Node left;
            Node right;
            int size = size();
        }
    }
    //returns array list of keys between some min and some max
    public Iterable<Key> keys(){
        return keys(min(),max());
    }
    public Iterable<Key> keys(Key min, Key max){
        Queue<Key> q = new Queue<Key>();
        keys(root, q, min, max);
        return q;
    }
    private void keys(Node x, ArrayList<Key> q, Key lo, Key hi){
        if(x == null) return;
        int cmplo = lo.compareTo(x.key);
        int comphi = hi.compareTo(x.key);
        if(cmplo < 0) keys(x.left);
        if(cmplo <= 0 && cmphi >= 0) q.add(x.key);
        if(cmphi > 0) keys(x.right, q, lo, hi);

    }
    public void put(Key k, Value v){
        root = put(root, k, v);
    }
    private Node put(Node n, Key k, Value v){
        if(n == null) return new Node(k, v);
        int cmp = k.compareTo(n.key);
        if(cmp > 0){
            n.right = put(n.right, k, v);
        }
        else if(cmp < 0){
            n.left = put(n.left, k, v);
        }
        else{
            n.value = v;
        }
        return n; //why do this?

    }
    public Value get(Key k){
        return get(root, k);
    }
    private Value get(Node n, Key k){ 
        if(n == null) return null;
        int cmp = k.compareTo(n.key);
        if(cmp > 0){
            return get(n.right, k);
        }
        else if(cmp < 0){
            return get(n.left, k);
        }
        return n.value;
    }
    public int size(Key k){
        
    }
    private int size(Node x){
        if(x ==null){
            return 0;
        }
        return size(x.right) + size(x.left) + 1;
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
    private Node delete(Node x, Key k){
    //t = "to delete"
    //x = "suXessor"
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
    public boolean contains(Value v){

    }
    public boolean isEmpty(){
        return (root == null);
    }
    public static void main(String[] args){

    }
}
//2-3 Search Tree:
    //2-Node (one key): two links: left, right 
    //3-Node (two keys): three links: left, right, middle

//                       M
//                    /     \
//                   EJ      R
//                  / | \   / \
//                AC  H  L R  SX
//               /|\ /\ /\ /\ /|\

// To insert K:
//                        M
//                    /       \
//                   EJ        R
//                  / | \     / \
//                AC  H  LK   R  SX
//               /|\ /\  /|\   /\ /|\

//Insert to 3 node by itself:
//
//         AE                        AES              E
//       / | \        insert S      /||\             / \
//                                                  A   S