class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums){
            if(!numSet.contains(num)) numSet.add(num);
        }

        int longestStreak = 0;
        for(int num : nums){
            if(!numSet.contains(num-1)){//if num is seq start
                int currNum = num;
                int currSteak = 1;
                while(numSet.contains(currNum+1)){
                    currNum++;
                    currSteak++;
                }
                longestStreak = Math.max(longestStreak, currSteak);
            }
        }
        return longestStreak;
    }
}