class ValidWordAbbr {
    Map<String, String> abbrFreq;
    
    public ValidWordAbbr(String[] dictionary) {
        abbrFreq = new HashMap<String, String>();
        for(String word : dictionary) {
            String key = getKey(word);
            if(abbrFreq.containsKey(key) && !abbrFreq.get(key).equals(word)) 
                abbrFreq.put(key, "");//invalid
            else 
                abbrFreq.put(key, word);
        }       
    }
    public boolean isUnique(String word) {
        String abbr = getKey(word);
        return !abbrFreq.containsKey(abbr) || abbrFreq.get(abbr).equals(word);
    }
    private String getKey(String word){
        if(word.length() <= 2) return word;
        
        return  word.charAt(0)+
                String.valueOf(word.length()-2)+
                word.charAt(word.length()-1);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */