public class TrieNode {
    private Character key;
    private boolean isWord;
    private Map<Character, TrieNode> children;//contains children of TrieNode key
    
    public TrieNode(Character c){
        this(c, false);
    }
    public TrieNode(Character c, boolean b){
        setKey(c);
        setChildren();
        setIsAWord(b);
    }    
    public Map<Character, TrieNode> getChildren(){
        return children;
    }
    public boolean getIsAWord(){
        return isWord;
    }
    public Character getKey(){
        return key;
    }
    public void setKey(Character c){
        key = c;
    }
    public void setChildren(){
        children = new HashMap<Character, TrieNode>();
    }
    public void setIsAWord(boolean b){
        isWord = b;
    }
}

class Trie {    
    private TrieNode root;
    public Trie() {
        root = new TrieNode(' ');
    }    
    public void insert(String word) {
        TrieNode node = root;
        for(Character c : word.toCharArray()){
            if(!node.getChildren().containsKey(c)){
                TrieNode newNode = new TrieNode(c);
                node.getChildren().put(c, newNode);
            }
            node = node.getChildren().get(c);
        }
        node.setIsAWord(true);
    }    
    public boolean search(String word) {
        TrieNode node = root;
        for(Character c : word.toCharArray()){
            if(!node.getChildren().containsKey(c)){
                return false;
            }
            node = node.getChildren().get(c);
        }
        return node.getIsAWord();
    }    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(Character c : prefix.toCharArray()){
            if(!node.getChildren().containsKey(c)){
                return false;
            }
            node = node.getChildren().get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */