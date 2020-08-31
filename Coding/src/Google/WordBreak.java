package Google;

import java.util.HashSet;
import java.util.List;

public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] syllablePoint = new boolean[len + 1];
        syllablePoint[0] = true;//if s is empty
        HashSet<String> dict = new HashSet<String>(wordDict);//O(1) lookup time
        for(int i = 1; i <= len; i++){//to find syllable points for the whole string
            for(int j = i-1; j >= 0; j--){//to find if string at pos i is a syllable             
                syllablePoint[i] = syllablePoint[j] && dict.contains(s.substring(j ,i));
                if(syllablePoint[i]) break;//break, if found
            }
        }
        return syllablePoint[len];
    }
}
