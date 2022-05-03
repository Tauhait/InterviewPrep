class Solution {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> monoStack = new Stack<Integer>();
        for(int i = 0; i < heights.length; i++){
            while(!monoStack.isEmpty() && heights[monoStack.peek()] <= heights[i]){
                monoStack.pop();
            }
            monoStack.push(i);
        }
        int[] result = new int[monoStack.size()];
        Iterator<Integer> iter = monoStack.iterator();
        int index = 0;
        while(iter.hasNext()){
            result[index++] = iter.next();
        }        
        return result;
    }
}