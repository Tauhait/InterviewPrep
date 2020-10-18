package faang;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
public class SortCharactersByFrequency {
	public String frequencySort(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<Character, Integer>();
        char[] strChars = s.toCharArray();
        StringBuilder str = new StringBuilder();
        for(char c : strChars){
        	freqMap.put(c, freqMap .getOrDefault(c, 0) + 1);
        }
        LinkedHashMap<Character, Integer> reverseSortedMap = new LinkedHashMap<Character, Integer>();
        freqMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered(x->reverseSortedMap.put(x.getKey(), x.getValue()));
        Set<Entry<Character, Integer>> entrySetMap = reverseSortedMap.entrySet();
        Iterator<Entry<Character, Integer>> mapIter = entrySetMap.iterator();
        while(mapIter.hasNext()) {        	
        	Entry<Character, Integer> entry = mapIter.next();
        	int iter = 1;
        	while(iter <= entry.getValue()) {
        		str.append(entry.getKey());
        		iter++;
        	}
        }
        return str.toString();
    }
}
