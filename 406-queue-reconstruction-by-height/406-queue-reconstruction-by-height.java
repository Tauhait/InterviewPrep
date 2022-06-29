class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(null == people || people.length == 0 || people[0].length == 0)
            return new int[0][0];
        //Sort by height decending and count of persons having height greater in ascending order
        Arrays.sort(people, new Comparator<int[]>(){
           @Override
            public int compare(int[] a, int[] b){
                return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
            }
        });
        // for(int[] p : people) System.out.print("["+p[0]+","+p[1]+"]\t");
        // System.out.println();
        // System.out.println();
        //insert persons into list at relative positions which ultimately preserves the actual order
        List<int[]> ans = new ArrayList<int[]>();
        for(int [] p : people){
            ans.add(p[1],p);
            // for(int[] l : ans){
            //     System.out.print("["+l[0]+","+l[1]+"]\t");
            // }
            // System.out.println();
        }
        return ans.toArray(new int[people.length][2]);
    }
}
/**
1. max people array len?
2. upper limit in height?
3. do i need to check for the case when it is not possible to construct the queue?
*/
/*
revere sort the array first by height desc and then by pos in asc
[7,0],[7,1],[6,1],[5,0],[5,2],[4,4]
insert the sorted array by position which will insert at right positions and push every entry to its correct position finally.
*/