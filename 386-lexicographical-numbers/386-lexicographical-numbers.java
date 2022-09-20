class Solution {
    Node root = new Node();
    public List<Integer> lexicalOrder(int n) {
        insert(n);
        List<Integer> res = new ArrayList<>();
        add(root, res, 0, n);
        return res;
    }
    
    public void insert(int n) {
        for (int i = 1; i <= n; i++) {
            Node node = root;
            String s = "" + i;
            for (char ch : s.toCharArray()){
                int key = ch - '0';
                if (!node.containsKey(key)) 
                    node.put(key, new Node());
                node = node.get(key);
            }
            node.setEnd();
        }
    }
    
    public void add(Node node, List<Integer> res, int ans, int n) {
        if (ans > n) 
            return;
        for (int i = 0; i < 10; i++) {
            if (ans * 10 + i > n) return;
            if (node.containsKey(i)) {
                Node temp = node;
                res.add(ans * 10 + i);
                temp = temp.get(i);
                add(temp, res, ans * 10 + i, n);
            }
        }
    }
    
}

class Node {
    Node[] node;
    boolean flag;
    
    Node() {
        node = new Node[10];
        flag = false;
    }
    
    boolean containsKey(int n) {
        return node[n] != null;
    }
    
    Node get(int n) {
        return node[n];
    }
    
    void put(int n, Node newNode) {
        node[n] = newNode;
    }
    
    boolean isEnd() {
        return flag;
    }
    
    void setEnd() {
        flag = true;
    }
}