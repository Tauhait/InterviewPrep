class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> uniqVals = new HashSet();
        for(int elem : arr){            
            if(uniqVals.contains(2*elem) || (elem % 2 == 0 && uniqVals.contains(elem/2))) 
                return true;
            uniqVals.add(elem);
        }
        return false;
    }
}