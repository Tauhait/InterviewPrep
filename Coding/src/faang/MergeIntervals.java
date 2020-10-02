package faang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return new int[0][];
        List<int[]> mergedInt = new ArrayList<int[]>();
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]) == 0 ? a[1] - b[1] : a[0] - b[0] );
        // Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // for(int[] i : intervals) System.out.print("["+i[0]+","+i[1]+"], ");
        // System.out.println();
        int start = intervals[0][0], end = intervals[0][1];
        for(int[] i : intervals){
            if(i[0] <= end) end = Math.max(end, i[1]);
            else { 
                mergedInt.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }            
        }
        mergedInt.add(new int[]{start, end});
        return mergedInt.toArray(new int[0][]);
    }
}
