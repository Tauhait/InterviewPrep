package faang;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
	public int firstUniqChar(String s) {
        Map<Integer,Integer> charFreq = new HashMap<Integer,Integer>();
        for(char ch : s.toCharArray()){
            Integer c=(int)ch;
            if(charFreq.containsKey(c))
                charFreq.replace(c,charFreq.get(c)+1);
            else
                charFreq.put(c,1);
        }        
        int leastUniqIndex=-1;
        for(Integer key : charFreq.keySet()){
            if(charFreq.get(key) == 1){                
                int t=s.indexOf(key);
                if(leastUniqIndex==-1 || t < leastUniqIndex)
                    leastUniqIndex=t;
            }
            
        }
        return leastUniqIndex;            
    }

}
