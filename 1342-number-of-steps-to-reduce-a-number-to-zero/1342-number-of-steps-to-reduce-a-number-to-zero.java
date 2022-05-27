class Solution {
    public int numberOfSteps(int num) {
        int totalSteps = 0;

        while (num > 0) {
            if ((num & 1) == 0) 
                num = num >> 1;
            else 
                num = num ^ 1;//for odd values this exclusive XOR op removes last 1 and make it even

            totalSteps++;
        }

        return totalSteps;
    }
}