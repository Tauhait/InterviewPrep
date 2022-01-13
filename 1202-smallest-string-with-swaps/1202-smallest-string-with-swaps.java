class Solution {
     public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int slen = s.length();
        UnionFind uf = new UnionFind(slen);
        /*
        we can build connected components where each component is a list of indices that 
        can be exchanged with any of them. 
        In Union find terms, we simply iterate through each pair, and 
        do a union on the indices in the pair. 
        At the end of the union of all the pairs, 
        we have built connected component of indices that can be exchanged with each other.
        */
        for(List<Integer> pair : pairs){
            uf.union(pair.get(0), pair.get(1));
        }        
        /*
        Then we build a sorted list of characters for every connected component.
        Map stores the component id and the lexicographicaly sorted list of characters 
        */
        Map<Integer, Queue<Character>> componentCharMap = new HashMap<Integer, Queue<Character>>();
        for(int idx = 0; idx < slen; idx++){
            int component = uf.find(idx);
            componentCharMap.putIfAbsent(component, new PriorityQueue<Character>());
            /*
            we iterate through all the indices, and 
            for each index we locate its component id and 
            find the sorted list correspondng to that component and 
            grab the next lowest character from that list.
            */
            componentCharMap.get(component).add(s.charAt(idx));
        }
        StringBuilder smallestLexStr = new StringBuilder();
        for(int idx = 0; idx < slen; idx++){
            /*
            This way for every index, we find the lowest possible character that can be exchanged and 
            fitted there.
            */
            smallestLexStr.append(componentCharMap.get(uf.find(idx)).poll());
        }
        return smallestLexStr.toString();
    }
    class UnionFind {
        private int[] root;
        private int[] rank;
        public UnionFind(int nodes){
            root = new int[nodes];
            rank = new int[nodes];
            for(int idx = 0; idx < nodes; idx++) {
            	root[idx] = idx;
            	rank[idx] = 1;
            }
        }
        public int find(int x){
            if(root[x] == x){
                return x;
            }
            return root[x] = find(root[x]);
        }
        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX != rootY){
                if(rank[rootX] > rank[rootY]){
                    root[rootX] = rootY;
                }else if(rank[rootY] > rank[rootX]){
                    root[rootY] = rootX;
                }else {
                    root[rootX] = rootY;
                    rank[rootX]++;
                }
            }
        }
    }
}