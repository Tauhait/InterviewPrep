class TrieNode {
    Map<Character, TrieNode> charMap = new HashMap<Character, TrieNode>();
    boolean isComplete = false;
}
class Solution {
    TrieNode root;
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        
        for(String s : dictionary){
            TrieNode currNode = root;
            for(Character c : s.toCharArray()){
                currNode.charMap.putIfAbsent(c, new TrieNode());
                currNode = currNode.charMap.get(c);
            }
            currNode.isComplete = true;
        }
        // printTrie(root);
        
        
        String[] words = sentence.split(" ");
        for(int i = 0; i < words.length; i++){
            StringBuilder sb = new StringBuilder();
            boolean isReplace = false;
            TrieNode currNode = root;
            for(Character c : words[i].toCharArray()){
                if(!currNode.charMap.containsKey(c)){
                    break;
                }else {
                    sb.append(c);                    
                    currNode = currNode.charMap.get(c);                    
                }
                if(currNode.isComplete){
                    isReplace = true;
                    break;
                }
            }
            
            // System.out.println(words[i] + ", " + isReplace);
            // System.out.println(sb.toString());
            if(isReplace){
                words[i] = sb.toString();
            }            
        }
        StringBuilder ans = new StringBuilder();
        for(String word : words){
            ans.append(word);
            ans.append(" ");
        }
        return ans.toString().trim();
    }
    // public void printTrie(TrieNode root){
    //     Queue<TrieNode> q = new LinkedList<TrieNode>();
    //     q.offer(root);
    //     while(!q.isEmpty()){
    //         TrieNode currNode = q.poll();
    //         for(Map.Entry e : currNode.charMap.entrySet()){
    //             System.out.print(e.getKey() + ",");
    //             q.offer((TrieNode)e.getValue());
    //         }
    //         System.out.print("\t");
    //     }
    //     System.out.println();
    // }
}