/**
* The given problem asks us to compute the maximum possible variance between
* 2 characters in any substring of the given string. This value will be the 
* largest difference between the highest frequence element and the lowest frequency
* element. This problem can be broken down so that we compute the maximum possible
* variation between any 2 characters. By computing the maximum possible variation between
* all unique characters and then getting the maximum among those values we can compute
* the largest variance for String, s. We can start the problem by filling a hashmap with
* the characters in the string and their respective counts. We can then iterate through
* pairs of characters using a nested loop on the maps keyset. Once we have our primary
* character and secondary character we can compute the maximum variance for those characters
* using Kadane's algorithm. As we iterate through the characters in our string we can check
* whether any of those characters belong to our pair. We can update the frequencies for those
* characters. It is also important that we track the count of our secondary character. This
* is so we can reset our frequencies. For example, if the secondary frequency outweighs the primary
* frequency upto that point we know that the substring upto that point has already had its max variance
* computed and continuing to work with that part of the string is pointless since our variance is lower
* than 0 for the primary character. If we have more secondary characters we can simply, reset our string
* to start at this new index and continue to calculate new frequencies. Therefore we reset our primary
* and secondary frequencies that we might meet a better frequence later down the iteration of  our string.
* We can keep a global variable for the nested loops which we can compare with our current max frequency
* between 2 characters. At the end we can simply return our variance.
*
**/
class Solution {
    
    public int largestVariance(String s) {
        HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            charCount.put(s.charAt(i), charCount.getOrDefault(s.charAt(i), 0)+1);
        }
        int variance = 0;
        //Iterate through unique characters
        for (Character primaryChar: charCount.keySet()) {
            for  (Character secondaryChar: charCount.keySet()) {
                // We need a unique character  pair to compute variance
                if (primaryChar == secondaryChar) { continue; }
                int secondaryCharCount = charCount.get(secondaryChar);
                int primaryFreq = 0;
                int secondaryFreq = 0;              
                
                for (int i = 0; i < s.length(); i++) {
                    Character currChar = s.charAt(i);
                    if (currChar == primaryChar) {
                        primaryFreq++;  
                    }
                    if (currChar == secondaryChar) {
                        secondaryFreq++;
                        secondaryCharCount--;
                    }
                    // Variance only computed if we have already seen both a primary
                    // and a secondary character
                    if (primaryFreq > 0 && secondaryFreq > 0 && primaryFreq > secondaryFreq) {                    
                        variance  = Math.max(variance, (primaryFreq - secondaryFreq));
                    }
                    // We reset our index so we are ignoring the substring which will
                    // impact our variance negatively
                    if (primaryFreq < secondaryFreq && secondaryCharCount > 0) {                      
                        primaryFreq = 0;
                        secondaryFreq = 0;                       
                    }
                }
                
            }
        }
        return variance;
    }
}