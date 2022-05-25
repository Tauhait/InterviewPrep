public class AutocompleteSystem {
    private class TrieNode {
        Map<Character, TrieNode> children;
        Map<String, Integer> counts;

    public TrieNode() {
          children = new HashMap<>();
          counts = new HashMap<>();
        }
    }

    private TrieNode root;
    private String prefix;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";
        for (int i = 0; i < sentences.length; i++) {
            addToTrie(sentences[i], times[i]);
        }
    }

    private void addToTrie(String sentence, int count) {
        TrieNode curr = root;
        for (char c : sentence.toCharArray()) {
          if (!curr.children.containsKey(c)) {
            curr.children.put(c, new TrieNode());
          }
          curr = curr.children.get(c);
          curr.counts.put(sentence, curr.counts.getOrDefault(sentence, 0) + count);
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
          addToTrie(prefix, 1);
          prefix = "";
          return new ArrayList<>();
        }
        prefix += c;
        TrieNode curr = root;
        for (char ch : prefix.toCharArray()) {
          if (!curr.children.containsKey(ch)) {
            return new ArrayList<>();
          }
          curr = curr.children.get(ch);
        }
        Map<String, Integer> temp = curr.counts;
        PriorityQueue<String> minHeap =
            new PriorityQueue<>(
                (a, b) -> (temp.get(a) == temp.get(b) ? 
                           b.compareTo(a) : 
                           temp.get(a) - temp.get(b)));
        
        for (String key : temp.keySet()) {
          minHeap.offer(key);
          if (minHeap.size() > 3) {
            minHeap.remove();
          }
        }
        List<String> res = new ArrayList<>();
        while (minHeap.size() > 0) {
          res.add(0, minHeap.poll());
        }
        return res;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */