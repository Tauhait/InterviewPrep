class TrieNode {
  HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
  List<Integer> wordList = new ArrayList<Integer>();

  public TrieNode() {}
}


class Solution {
      int N = 0;
      String[] words = null;
      TrieNode trie = null;

        public List<List<String>> wordSquares(String[] words) {
            this.words = words;
            this.N = words[0].length();

            List<List<String>> results = new ArrayList<List<String>>();
            this.buildTrie(words);

            for (String word : words) {
              LinkedList<String> wordSquares = new LinkedList<String>();
              wordSquares.addLast(word);
              this.backtracking(1, wordSquares, results);
            }
            return results;
        }

      protected void backtracking(int step, LinkedList<String> wordSquares,
                                  List<List<String>> results) {
            if (step == N) {
              results.add((List<String>) wordSquares.clone());
              return;
            }

            StringBuilder prefix = new StringBuilder();
            for (String word : wordSquares) {
              prefix.append(word.charAt(step));
            }

            for (Integer wordIndex : this.getWordsWithPrefix(prefix.toString())) {
              wordSquares.addLast(this.words[wordIndex]);
              this.backtracking(step + 1, wordSquares, results);
              wordSquares.removeLast();
            }
      }

      protected void buildTrie(String[] words) {
            this.trie = new TrieNode();

            for (int wordIndex = 0; wordIndex < words.length; ++wordIndex) {
              String word = words[wordIndex];

              TrieNode node = this.trie;
              for (Character letter : word.toCharArray()) {
                if (node.children.containsKey(letter)) {
                  node = node.children.get(letter);
                } else {
                  TrieNode newNode = new TrieNode();
                  node.children.put(letter, newNode);
                  node = newNode;
                }
                node.wordList.add(wordIndex);
              }
            }
      }

      protected List<Integer> getWordsWithPrefix(String prefix) {
            TrieNode node = this.trie;
            for (Character letter : prefix.toCharArray()) {
              if (node.children.containsKey(letter)) {
                node = node.children.get(letter);
              } else {
                // return an empty list.
                return new ArrayList<Integer>();
              }
            }
            return node.wordList;
      }
}