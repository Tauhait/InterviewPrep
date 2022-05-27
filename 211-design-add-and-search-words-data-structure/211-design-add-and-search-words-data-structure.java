class WordDictionary {
    private class TrieNode {
        Map<Character, TrieNode> charMap;
        boolean isWord;
        public TrieNode(){
            charMap = new HashMap<Character, TrieNode>();
            isWord = false;
        }
    }
    
    TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode currNode = root;
        for(Character c : word.toCharArray()){
            if(!currNode.charMap.containsKey(c)){
                currNode.charMap.put(c, new TrieNode());
            }
            currNode = currNode.charMap.get(c);
        }
        currNode.isWord = true;
    }
    
    /** Returns if the word is in the node. */
    public boolean searchInNode(String word, TrieNode node) {
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if (!node.charMap.containsKey(ch)) {
                // if the current character is '.'
                // check all possible nodes at this level
                if (ch == '.') {
                    for (char x : node.charMap.keySet()) {
                        TrieNode child = node.charMap.get(x);
                        if (searchInNode(word.substring(i + 1), child)) {//recursive search
                            return true;
                        }
                    }
                }
                // if no nodes lead to answer
                // or the current character != '.'
                return false;
            } else {
                // if the character is found
                // go down to the next level in trie
                node = node.charMap.get(ch);
            }
        }
        return node.isWord;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchInNode(word, root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */