class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        Trie trie = new Trie();
        int minlen = 201;
        String minStr = "";
        for(String s : strs){
            int slen = s.length();
            if(slen < minlen){
                minlen = slen;
                minStr = s;
            }
            trie.insert(s);
        }
        return trie.lcp(minStr);
    }
}

public class Trie {  
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }

    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }    
    public void insert(String word) {
        TrieNode node = root;
        for(Character c : word.toCharArray()){
            if(!node.children.containsKey(c)){
                TrieNode newNode = new TrieNode();
                node.children.put(c, newNode);
            }
            node = node.children.get(c);
        }
    }    
    public String lcp(String prefix) {
        TrieNode node = root;
        int plen = prefix.length();
        for(int i = 0; i < plen; i++){
            char c = prefix.charAt(i);
            if(!node.children.containsKey(c) || 
               node.children.size() != 1) return prefix.substring(0,i);
            node = node.children.get(c);
        }
        return prefix;
    }
}