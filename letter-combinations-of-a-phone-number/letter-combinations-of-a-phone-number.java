class Solution {
    /**
    In an interview, asking your interviewer about the constraints will also show your attention to detail -
    on top of giving you information.
    Whenever you have a problem where you need to generate all combinations/permutations 
    of some group of letters/numbers, the first thought you should have is backtracking. 
    If you're new to backtracking, check out our backtracking explore card. 
    Backtracking algorithms can often keep the space complexity linear with the input size.
    */
    private Map<Integer, LinkedList<Character>> digitLetterMap = new HashMap();
    private LinkedList<String> output;
    private int last = 97;;
    public List<String> letterCombinations(String digits) {
        output = new LinkedList<String>();
        if(digits.length() == 0){
            return output;
        }

        for(int number = 2; number <= 9; number++){            
            digitLetterMap.put(number, new LinkedList<Character>());
            if(number == 7 || number == 9){
                addLetters(number, 4);
            }else {
                addLetters(number, 3);
            }
        }
        char []digitArr = digits.toCharArray();
        backtrack(new StringBuilder(), 0, digitArr);
        return output;
    }
    private void addLetters(int number, int size){
        for(int len = 1; len <= size; len++){
            digitLetterMap.get(number).add((char)(last++));
        }
    }
             
    private void backtrack(StringBuilder letterComb, int currIndex, char []digitArr){
        if(letterComb.length() == digitArr.length){
            String combination = letterComb.toString();
            output.add(combination);
            return;
        }
        int digit = Character.getNumericValue(digitArr[currIndex]);
        for(Character l : digitLetterMap.get(digit)){
            letterComb.append(l);
            backtrack(letterComb, currIndex + 1, digitArr);
            int len = letterComb.length();
            letterComb.deleteCharAt(len - 1);
        }
        return;
    }
}