class Solution {
    public int longestConsecutive(int[] nums) {
        UF uf = new UF(nums.length);
        // Map val to index in nums
        Map<Integer, Integer> valToIndex = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (valToIndex.containsKey(nums[i])) {
                continue;
            }
            
            if (valToIndex.containsKey(nums[i] - 1)) {
                uf.union(i, valToIndex.get(nums[i] - 1));
            }
            
            if (valToIndex.containsKey(nums[i] + 1)) {
                uf.union(i, valToIndex.get(nums[i] + 1));
            }
            
            valToIndex.put(nums[i], i);
        }
        
        return uf.getLargetComponentSize();
    }
    
    class UF {
        private int[] parent;
        private int[] size;
        
        public UF(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        
        public void union(int x, int y) { // connected if consecutive
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            }
        };
        
        private int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            
            return parent[x] = find(parent[x]);
        };
        
        public int getLargetComponentSize() {
            int maxSize = 0;
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] == i && size[i] > maxSize) {
                    maxSize = size[i];
                }
            }
            
            return maxSize;
        }
    }
}