class Solution {
    //generalized for n arrays approach
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        return kSumCount(new int[][]{A, B, C, D});
    }
    
    public int kSumCount(int[][] lists) {
        Map<Integer, Integer> m = new HashMap<>();
        addToHash(lists, m, 0, 0);
        return countComplements(lists, m, lists.length / 2, 0);
    }
    
    private void addToHash(int[][] lists, Map<Integer, Integer> m, int i, int sum) {
        if (i == lists.length / 2) {
            m.put(sum, m.getOrDefault(sum, 0) + 1);
        } else {
            for (int a : lists[i]) {
                addToHash(lists, m, i + 1, sum + a);
            }
        }
    }
    
    private int countComplements(int[][] lists, Map<Integer, Integer> m, int i, int complement) {
        if (i == lists.length) {
            return m.getOrDefault(complement, 0);
        }
        int cnt = 0;
        for (int a : lists[i]) {
            cnt += countComplements(lists, m, i + 1, complement - a);
        }
        return cnt;
    }
}
/*
take any comb of 
num1-2 & num3-4 
or
num1-3 & nume2-4 
or
num1-4 & num2-3
or 
etc...
try to find the reverse of first two sum.
O(n^2)
*/
