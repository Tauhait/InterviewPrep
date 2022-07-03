class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        Map<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
        for(int a : nums1){
            for(int b : nums4){
                int posSum = a + b;
                sumMap.put(posSum, sumMap.getOrDefault(posSum, 0) + 1);
            }
        }
        for(int c : nums2){
            for(int d : nums3){
                int negSum = -(c + d);
                count += sumMap.getOrDefault(negSum, 0);
            }
        }
        return count;
    }
}
/*
put any of nums1/2/3/4 into hasset and solve in O(n^3)

*/
