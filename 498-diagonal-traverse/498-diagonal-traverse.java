class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        Deque<int[]> deque = new ArrayDeque<int[]>();
        int elements = mat.length * mat[0].length;
        int[] ans = new int[elements];
        int index = 0;
        
        deque.add(new int[]{0, 0});
        
        for(int i = 1; i < (rows+cols); i++){
            int size = deque.size();
            while(size-- > 0){
                int[] indexes;
                if(i % 2 == 1) {
                    indexes = deque.pollFirst();
                    // System.out.println("inside if "+indexes[0]+","+indexes[1]+"="+mat[indexes[0]][indexes[1]]);
                    ans[index++] = mat[indexes[0]][indexes[1]];
                    if(indexes[0]+1 < rows){
                        if(deque.isEmpty()) deque.addLast(new int[]{indexes[0]+1, indexes[1]});//down
                        else {
                            int[] lastInsert = deque.peekLast();
                            if(lastInsert[0] != indexes[0]+1) 
                                deque.addLast(new int[]{indexes[0]+1, indexes[1]});//down
                        }
                    }
                    if(indexes[1]+1 < cols){
                        if(deque.isEmpty()) deque.addLast(new int[]{indexes[0], indexes[1]+1});//right
                        else {
                            int[] lastInsert = deque.peekLast();
                            if(lastInsert[1] != indexes[1]+1) 
                                deque.addLast(new int[]{indexes[0], indexes[1]+1});//right
                        }
                    }
                }
                else {
                    indexes = deque.pollLast();
                    // System.out.println("inside else "+indexes[0]+","+indexes[1]+"="+mat[indexes[0]][indexes[1]]);
                    ans[index++] = mat[indexes[0]][indexes[1]];
                    
                   if(indexes[1]+1 < cols){
                        if(deque.isEmpty()) deque.addFirst(new int[]{indexes[0], indexes[1]+1});//right
                        else {
                            int[] lastInsert = deque.peekLast();
                            if(lastInsert[1] != indexes[1]+1) 
                                deque.addFirst(new int[]{indexes[0], indexes[1]+1});//right
                        }
                    }
                    if(indexes[0]+1 < rows){
                        if(deque.isEmpty()) deque.addFirst(new int[]{indexes[0]+1, indexes[1]});//down
                        else {
                            int[] lastInsert = deque.peekLast();
                            if(lastInsert[0] != indexes[0]+1) 
                                deque.addFirst(new int[]{indexes[0]+1, indexes[1]});//down
                        }
                    }
                }
            }
        }
        return ans;
    }
}
//BFS
/*
1
4 2
7 5 3
[[1,2],[3,4],[5,6]]

*/