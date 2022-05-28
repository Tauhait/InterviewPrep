
class Solution {
  private class TrieNode {
      TrieNode[] children;
      public TrieNode() {
        children = new TrieNode[2];
      }
  }

  public int findMaximumXOR(int[] nums) {
    if (null == nums || 0 == nums.length)
      return 0;
    
    // get the longest binary representation.
    int maxLen = 0;
    for (int x : nums)
      maxLen = Math.max(maxLen, Integer.toBinaryString(x).length());
    
    // construct binary representation for each number.
    String[] strs = new String[nums.length];
    int padding = (1 << maxLen);
    for (int i = 0; i < nums.length; ++i)
      strs[i] = (Integer.toBinaryString(padding | nums[i]).substring(1));
    
    // construct trie first, and then get the max from the trie.
    TrieNode root = new TrieNode();
    for (String x : strs) {
      TrieNode curr = root;
      for (char c : x.toCharArray()) {
        int bit = c - '0';
        if (null == curr.children[bit])
          curr.children[bit] = new TrieNode();
        curr = curr.children[bit];
      }
    }
    
    int result = 0;
    for (String x : strs) {
      TrieNode curr = root;
      int currRes = 0;
      for (char c : x.toCharArray()) {
        int bit = c - '0';
        if (null != curr.children[1 - bit]) {
          currRes = (currRes << 1) | 1;
          curr = curr.children[1 - bit];
        } else {
          currRes <<= 1;
          curr = curr.children[bit];
        }
      }
      
      result = Math.max(result, currRes);
    }
    
    return result;
  }
}