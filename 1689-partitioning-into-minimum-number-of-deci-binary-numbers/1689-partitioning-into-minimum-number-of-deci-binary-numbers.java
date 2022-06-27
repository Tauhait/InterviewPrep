class Solution {
    public int minPartitions(String n) {
        int max = 0;
        for(char c : n.toCharArray()) {
            if(c-'0' == 9) return 9;
            if(c-'0' > max) max = c-'0';
        }
        return max;
    }
}
/**
10000
10100
10100
10100
10101
10111
11111
11111
*/