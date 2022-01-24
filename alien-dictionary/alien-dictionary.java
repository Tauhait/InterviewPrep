class Solution {
    private Map<Character, List<Character>> dependencyMap;
    private Map<Character, Integer> inDegCountMap;
    private boolean buildDependencyMap(String[] words){
        int len = words.length;
        dependencyMap = new HashMap();
        inDegCountMap = new HashMap();
        //set space for every character present in the words
        for (String word : words) {
            for (char c : word.toCharArray()) {
                inDegCountMap.put(c, 0);
                dependencyMap.put(c, new ArrayList<>());
            }
        }
        
        for(int i = 0; i < len - 1; i++){
            String thisWord = words[i];
            String nextWord = words[i + 1];
            int thisWordLen = thisWord.length();
            int nextWordLen = nextWord.length();
            
            int index = 0;
            while(index < thisWordLen && index < nextWordLen){
                // Check that word2 is not a prefix of word1.
                if (thisWord.length() > nextWord.length() && thisWord.startsWith(nextWord)) {
                    return false;
                }
                if(thisWord.charAt(index) != nextWord.charAt(index)){
                    dependencyMap.get(thisWord.charAt(index)).add(nextWord.charAt(index));
                    inDegCountMap.put(nextWord.charAt(index), 
                                      inDegCountMap.get(nextWord.charAt(index)) + 1);
                    break;
                }
                index++;
            }
        }
        return true;        
    }
    private Queue<Character> formInitQueueWithZeroInDeg(){
        //queue to store nodes with no incoming edges or dependencies
        Queue<Character> queue = new LinkedList();
        for(Character c : inDegCountMap.keySet()){
            if(inDegCountMap.get(c).equals(0)){
                queue.offer(c);
            }
        }
        return queue;
    }
    private String formLexAlienStrUsingBFS(Queue<Character> queue){
        StringBuilder sb = new StringBuilder();
        //BFS
        while(!queue.isEmpty()){
            Character c = queue.remove();
            sb.append(c);
            for (Character next : dependencyMap.get(c)) {
                inDegCountMap.put(next, inDegCountMap.get(next) - 1);
                if (inDegCountMap.get(next).equals(0)) {
                    //adding to queue if all dependencies are resolved/absorbed/taken
                    queue.add(next);
                }
            }            
        }
        if(sb.length() < inDegCountMap.size()){
            return "";
        }else {
            return sb.toString();
        }
    }
    public String alienOrder(String[] words) {        
        if(!buildDependencyMap(words)){
            return "";
        }            
        Queue<Character> queue = formInitQueueWithZeroInDeg();
        String uniqueAlienStr = formLexAlienStrUsingBFS(queue);
        return uniqueAlienStr;
    }
}