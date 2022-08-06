class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int periods = minutesToTest/minutesToDie;
        return (int)Math.ceil(Math.log10(buckets)/Math.log10(periods+1));
    }
}