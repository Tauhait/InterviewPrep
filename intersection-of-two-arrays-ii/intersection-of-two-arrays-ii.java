class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null){
            return new int[]{};
        }
        
        Map<Integer, Integer> intersectMap;
        List<Integer> ansList;
        
        intersectMap = getSmallArrMap(nums1);
        ansList = intersectList(nums2, intersectMap);
        return buildAns(ansList);
    }
    private int[] buildAns(List<Integer> ansList){
        int len = ansList.size();
        int[] ans = new int[len];
        for(int idx = 0; idx < len; idx++){
            ans[idx] = ansList.get(idx);
        }
        return ans;
    }
    private List<Integer> intersectList(int[] nums, Map<Integer, Integer> intersectMap){
        List<Integer> ansList = new LinkedList<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(intersectMap.containsKey(nums[i])){
                ansList.add(nums[i]);
                intersectMap.put(nums[i], intersectMap.get(nums[i]) - 1);
                if(intersectMap.get(nums[i]) == 0){
                     intersectMap.remove(nums[i]);
                }
            }
        }
        return ansList;
    }
    private Map<Integer, Integer> getSmallArrMap(int[] nums){
        Map<Integer, Integer> intersectMap = new HashMap<Integer, Integer>();
        for(int idx = 0; idx < nums.length; idx++){
            intersectMap.put(nums[idx], intersectMap.getOrDefault(nums[idx], 0) + 1);
        }
        return intersectMap;
    }
}