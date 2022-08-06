class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int periods = minutesToTest/minutesToDie;
        return (int)Math.ceil(Math.log(buckets)/Math.log(periods+1));
    }
}