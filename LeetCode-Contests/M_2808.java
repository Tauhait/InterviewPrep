//  MinimumSeconds to Equalize a Circular Array
//  https://leetcode.com/problems/minimum-seconds-to-equalize-a-circular-array/description/
class M_2808 {

    private int n;

    public int minimumSeconds(List<Integer> nums) {
        n = nums.size();
        Map<Integer, List<Integer>> positions = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Integer v = nums.get(i);
            positions.computeIfAbsent(v, _k -> new ArrayList<>()).add(i);
        }

        int min = Integer.MAX_VALUE;

        for (List<Integer> value : positions.values()) {
            min = Math.min(getMaxGap(value), min);
        }

        return min/2;

    }

    public int getMaxGap(List<Integer> positions){
        int max = 0;
        int prev = positions.get(positions.size()-1)-n; // first gap is between first position and last position
        for (int p : positions) {
            max = Math.max(p - prev, max);
            prev = p;
        }

        return max;
    }
}
