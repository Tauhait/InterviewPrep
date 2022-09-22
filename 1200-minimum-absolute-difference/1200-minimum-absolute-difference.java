class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minAbsDiff = Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < arr.length-1; i++){
            int j = i + 1;
            int absDiff = Math.abs(arr[i]-arr[j]);
            if(absDiff < minAbsDiff){
                minAbsDiff = absDiff;
                List<Integer> pair = new ArrayList<Integer>();
                pair.add(arr[i]);
                pair.add(arr[j]);
                ans = new ArrayList<List<Integer>>();
                ans.add(pair);
            }else if(absDiff == minAbsDiff){
                List<Integer> pair = new ArrayList<Integer>();
                pair.add(arr[i]);
                pair.add(arr[j]);
                ans.add(pair);
            }
        }
        return ans;
    }
}