// binary search solution: O(nlogn)
// width is increasing, but if two widths are the same, the height is decreasing
// after sorting, all envolopes are valid 'based on width', so we just binary search based on 'heights'
// to choose 'some of them' to meet the requirement
// Ex. after sorting: (1,3), (3,5), (6,8), (6,7), (8,4), (9,5)
// transform to question find LIS: [3,5,8,7,4,5] => like '300. Longest Increasing Subsequence'
public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length < 2) return envelopes.length;
        
        Arrays.sort(envelopes, new EnvelopeComparator());
        int[] dp = new int[envelopes.length];
        int size = 0;
        
        for(int[] envelope: envelopes) {
            // binary search
            int left = 0, right = size, middle = 0;     // right = size
            while(left < right) {
                middle = left + (right - left) / 2;
                if(dp[middle] < envelope[1]) left = middle + 1;
                else right = middle;
            }
            
            // left is the right position to 'replace' in dp array
            dp[left] = envelope[1];
            if(left == size) size++;
        }
        return size;
    }
    
    class EnvelopeComparator implements Comparator<int[]> {
        public int compare(int[] e1, int[] e2) {
            return e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0];
        }
    }
}