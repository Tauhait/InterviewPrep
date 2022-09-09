class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        // Sort in ascending order of attack, 
        // If attack is same sort in descending order of defense
        Arrays.sort(properties, (a, b) -> (a[0] == b[0]) ? (b[1] - a[1]) : a[0] - b[0]);
        
        int weakCharacters = 0;
        int maxDefense = 0;
        for (int i = properties.length - 1; i >= 0; i--) {
            // Compare the current defense with the maximum achieved so far
            if (properties[i][1] < maxDefense) {
                weakCharacters++;
            }
            maxDefense = Math.max(maxDefense, properties[i][1]);
        }
        
        return weakCharacters;
    }
}