class Trie {
    final char ROOTCHAR = '\0';
    class Node {
        char c;
        int prefixCount;
        boolean isWordEnd;
        int wordCount;
        Map<Character, Node> children;
        public Node(char ch){
            c = ch;
            prefixCount = 0;
            wordCount = 0;
            isWordEnd = false;
            children = new HashMap<>();
        }
        public void addChild(char c, Node node){
            children.put(c, node);
        }
    }
    Node root;

    public Trie() {
        root = new Node(ROOTCHAR);
    }
    
    public void insert(String word) {
        Node node = root;
        if(word == null) throw new IllegalArgumentException("Null not allowed");
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!node.children.containsKey(ch)){
                Node newNode = new Node(ch);
                node.addChild(ch, newNode);
            }
            node = node.children.get(ch);
            node.prefixCount++;
        }
        node.isWordEnd = true;
        node.wordCount++;
    }
    
    public int countWordsEqualTo(String word) {
        Node node = root;
        if(word == null) return 0;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!node.children.containsKey(ch)) return 0;
            node = node.children.get(ch);
        }
        return node.wordCount;
    }
    
    public int countWordsStartingWith(String prefix) {
        Node node = root;
        if(prefix == null) return 0;
        for(int i = 0; i < prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(!node.children.containsKey(ch)) return 0;
            node = node.children.get(ch);
        }
        return node.prefixCount;
    }
    
    public void erase(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            Node curNode = node.children.get(ch);
            curNode.prefixCount--;
            if(curNode.prefixCount == 0){
                node.children.remove(ch);
                curNode.children = null;
                curNode = null;
                return;
            }
            node = curNode;
        }
        node.wordCount--;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */