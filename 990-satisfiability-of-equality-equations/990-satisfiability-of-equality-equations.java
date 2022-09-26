class Solution {    
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        for(String equation : equations){
            int var1 = equation.charAt(0)-'a';
            int var2 = equation.charAt(3)-'a';
            if(equation.charAt(1) == '=')
                uf.union(var1, var2);
        }
        for(String equation : equations){
            int var1 = equation.charAt(0)-'a';
            int var2 = equation.charAt(3)-'a';
            if(equation.charAt(1) == '!'){
                if(uf.find(var1) == uf.find(var2))
                    return false;
            }
            // else {
            //     if(uf.find(var1) != uf.find(var2))
            //         return false;
            // }                
        }
        return true;
    }
}
class UnionFind {
    private int[] group;
    private int[] rank;
    
    public int[] getGroup(){
        return group;
    }
    public int[] getRank(){
        return rank;
    }
    public UnionFind(int size){
        group = new int[size];
        rank = new int[size];
        for(int i = 0; i < size; i++){
            group[i] = i;
            rank[i] = 0;
        }
    }
    
    public void union(int x, int y){
        int groupX = find(x);
        int groupY = find(y);
        if(groupX != groupY){
            if(rank[groupX] > rank[groupY]){
                group[groupY] = groupX;
            }else if(rank[groupX] < rank[groupY]){
                group[groupX] = groupY;
            }else {
                group[groupX] = groupY;
                rank[groupX]++;
            }
        }
    }
    
    public int find(int node){
        if(node == group[node]){
            return node;
        }
        return group[node] = find(group[node]);
    }
}