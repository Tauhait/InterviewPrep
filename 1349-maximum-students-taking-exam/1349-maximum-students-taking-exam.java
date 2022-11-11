class Solution {
    int m, n;
    Map<String, Integer> memo;
    public int maxStudents(char[][] seats) {
        m=seats.length;
        if(m==0) return 0;
        n = seats[0].length;
        
        memo = new HashMap<String, Integer>();
        StringBuilder sb = new StringBuilder();
        for(char[] row: seats){
            sb.append(row);
        }
        
        return dfs(sb.toString());
    }
	
	/* dfs returns the max student we can place if start with the given state */

    public int dfs(String state){
        if(memo.containsKey(state)) return memo.get(state);
        int max = 0;
        char[] C = state.toCharArray();
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
			//we see an empty seat, there are two choices, place a student here or leave it empty.
                if(C[i*n+j]== '.'){
                    //choice (1): we choose not to place a student, but we place a x to mark this seat as unanvailable
					// so we don't repeatedly search this state again. 
					
                    C[i*n+j] = 'x';
                    max = Math.max(max, dfs(new String(C)));
     
					 //choice (2): we place a student, but this makes left, right, bottom left, bottom right seat unavailable. 
                    if(j+1<n){
                        if(i<m-1 && C[(i+1)*n+j+1] == '.') C[(i+1)*n+j+1] = 'x';
                        if(C[i*n+j+1] == '.') C[i*n+j+1] = 'x';
                    }
                    if(j-1>=0){
                        if(i<m-1 && C[(i+1)*n+j-1] == '.') C[(i+1)*n+j-1]= 'x';
                        if(C[i*n+j-1] == '.') C[i*n+j-1] = 'x';
                    }
                    max = Math.max(max, 1+dfs(new String(C)));
                }
            }
        }
        memo.put(state, max);
        return max; 
    }
}