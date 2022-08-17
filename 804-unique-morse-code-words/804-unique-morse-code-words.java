class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> uniqTransforms = new HashSet();
        final String[] morseCodes = {".-","-...","-.-.","-..",".","..-.",
                                     "--.","....","..",".---","-.-",".-..",
                                     "--","-.","---",".--.","--.-",".-.","...",
                                     "-","..-","...-",".--","-..-","-.--","--.."};
        
        for(String word : words){
            StringBuilder transformation = new StringBuilder();
            for(char c : word.toCharArray()){
                transformation.append(morseCodes[c-'a']);
            }
            uniqTransforms.add(transformation.toString());
        }
        return uniqTransforms.size();
    }
}