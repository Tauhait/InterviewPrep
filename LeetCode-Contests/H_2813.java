// https://leetcode.com/problems/maximum-elegance-of-a-k-length-subsequence/description/

class H_2813 {
    class Item {
        int profit;
        int category;
    }
    public long findMaximumElegance(int[][] items, int k) {
        Arrays.sort(items, (A, B) -> B[0] - A[0]);
        int n = items.length;
        Set<Integer> seenCategory = new HashSet<>();
        long totalProfit = 0l, maxProfit = 0l;
        List<Integer> duplicates = new ArrayList<>();

        for(int i = 0; i < n; i++){
            Item item = new Item();
            item.profit = items[i][0];
            item.category = items[i][1];
            if(i < k){
                if(seenCategory.contains(item.category)) {
                    duplicates.add(item.profit);
                }
                totalProfit += item.profit;
            } else if(!seenCategory.contains(item.category)){
                if(duplicates.isEmpty()) break;
                totalProfit += item.profit - duplicates.remove(duplicates.size() - 1);
            }
            seenCategory.add(item.category);
            long distinctCategory = seenCategory.size();
            maxProfit = Math.max(maxProfit, totalProfit + distinctCategory * distinctCategory);
        }
        return maxProfit;
    }
}