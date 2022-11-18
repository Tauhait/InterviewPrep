class Solution {
    public boolean primeFactors(int n){
        Set<Integer> set = new HashSet<Integer>();
        while (n % 2 == 0){
            n /= 2;
            set.add(2);
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2){
            while (n % i == 0){
                if(i != 3 && i != 5)
                    return false;
                set.add(i);
                n /= i;
            }
        }
        for(int s : set)
            if(s != 2 && s != 3 && s != 5)
                return false;
        if(n > 5)
            return false;
        return true;
    }
    public boolean isUgly(int n) {
        if(n <= 0)
            return false;
        return primeFactors(n);
    }
}