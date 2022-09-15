class Solution {
    public int[] findOriginalArray(int[] changed) {
        // It can't be doubled array, if the size is odd
        if (changed.length % 2 == 1) {
            return new int[0];
        }
        
        // Sort in ascending order
        Arrays.sort(changed);
        Map<Integer, Integer> freq = new HashMap<>();
        // Store the frequency in the map
        for (int num : changed) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        int[] original= new int[changed.length / 2];
        int index = 0;
        for (int num : changed) {
            // If element exists
            if (freq.get(num) > 0) {
				freq.put(num, freq.get(num) - 1);
                int twiceNum = num * 2;
                if (freq.containsKey(twiceNum) && freq.get(twiceNum) > 0) {
                    // Pair up the elements, decrement the count
                    freq.put(twiceNum, freq.get(twiceNum) - 1);
                    // Add the original number to answer
                    original[index++] = num;
                } else {
                    return new int[0];
                }
            }
        }
        
        return original;
    }
}