package faang;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabel {
	public List<Integer> partitionLabels(String S) {
        int[] lastIndex = new int[26];
        int start = 0;
        // record the last index of the each char
        for(char c : S.toCharArray()) lastIndex[c - 'a'] = start++;
        int last = 0, i = 0;
        start = 0;
        // record the end index of the current sub string
        List<Integer> ans = new ArrayList<Integer>();
        for(char c : S.toCharArray()){
            // Max of all the last indexes in the current substring
            last = Math.max(last, lastIndex[c - 'a']);
            if(last == i){
                ans.add(last - start + 1);
                start = last + 1;
            }
            ++i;
        }
        return ans;
    }
}
