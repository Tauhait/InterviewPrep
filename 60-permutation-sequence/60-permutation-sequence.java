class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int fact = 1;
        for(int i = 1; i < n; i++){
            fact *= i;
            numbers.add(i);
        }
        k -= 1;
        numbers.add(n);
        String ans = new String();
        while(true){
            ans = ans + numbers.get(k/fact);
            numbers.remove(k/fact);
            if(numbers.size() == 0){
                break;
            }
            k %= fact;
            fact /= numbers.size();
        }
        return ans;
    }
}