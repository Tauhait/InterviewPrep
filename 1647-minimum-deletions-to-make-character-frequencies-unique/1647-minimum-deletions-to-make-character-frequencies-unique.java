class Solution {    
    public int minDeletions(String s) {
        // Store the frequency of each character
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }
        
        int deleteCount = 0;
        // Use a set to store the frequencies we have already seen
        HashSet<Integer> seenFrequencies = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            // Keep decrementing the frequency until it is unique
            while (frequency[i] > 0 && seenFrequencies.contains(frequency[i])) {
                frequency[i]--;
                deleteCount++;
            }
            // Add the newly occupied frequency to the set
            seenFrequencies.add(frequency[i]);
        }
        
        return deleteCount;
    }
}