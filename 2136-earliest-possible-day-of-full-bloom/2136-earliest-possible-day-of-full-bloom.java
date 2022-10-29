class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        Pair[] flowerTime = new Pair[n];
        for (int i = 0; i < n; i++) {
            flowerTime[i] = new Pair(plantTime[i], growTime[i]);
        }
        // Sort the 'growTime' in descending order.
        // The 'plantTime' is not important as flowers with same 'growTime' but different 'plantTime' results in same total time.
        Arrays.sort(flowerTime, (a, b) -> b.growTime - a.growTime);

        // 'plantingDay' is the total days used for planting up to now,
        // which together with the current flower's 'plantTime' and 'growTime' result in a total time up to this flower.
        // This then is checked if we have a greater 'totalDays',
        // as it is possible for the previous flower 'totalDays' to be greatest.
        // For Example: flowerA with 'plantTime' 1 and 'growTime' 10, and flowerB with 'plantTime' 1 and 'growTime' 1.
        int plantingDay = 0;
        int totalDays = 0;
        for (Pair current : flowerTime) {
            // Check if we have found a greater 'totalDays', and update the days already used for previous plantings.
            totalDays = Math.max(totalDays, plantingDay + current.plantTime + current.growTime);
            plantingDay += current.plantTime;
        }
        // As we start at Day 0 (-1 Day from totalDays), and we need to include an extra day to bloom (+1 Day for totalDays),
        // they cancel out each other (totalDays + 1 - 1 == totalDays).
        return totalDays;
    }

    // Class Pair for sorting and readability.
    class Pair {
        public int plantTime;
        public int growTime;

        Pair(int plantTime, int growTime) {
            this.plantTime = plantTime;
            this.growTime = growTime;
        }
    }
}