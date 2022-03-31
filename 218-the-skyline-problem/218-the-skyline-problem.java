class Solution {
    /**
    There are two implementations 
    1. Using Priority Queue which in worst case takes O(n^2) time (https://leetcode.com/problems/the-skyline-problem/discuss/61192/Once-for-all-explanation-with-clean-Java-code(O(n2)time-O(n)-space))
    2. Divide and Conquer using merge sort technique which takes O(n log n)
    */
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        
        if(n == 0){
            return output;
        }
        if(n == 1){
            int xStart = buildings[0][0];
            int xEnd = buildings[0][1];
            int height = buildings[0][2];
            
            ArrayList<Integer> front = new ArrayList<Integer>();
            front.add(xStart);
            front.add(height);
            
            ArrayList<Integer> end = new ArrayList<Integer>();
            end.add(xEnd);
            end.add(0);
            
            output.add(front);
            output.add(end);
            
            return output;
        }
        
        List<List<Integer>> leftSkyline, rightSkyline;
        leftSkyline = getSkyline(Arrays.copyOfRange(buildings, 0, n/2));
        rightSkyline = getSkyline(Arrays.copyOfRange(buildings, n/2, n));
        
        return mergeSkylines(leftSkyline, rightSkyline);
    }
    
    private List<List<Integer>> mergeSkylines(List<List<Integer>> leftSkyline, List<List<Integer>> rightSkyline){
        int nL = leftSkyline.size();
        int nR = rightSkyline.size();
        int pL = 0, pR = 0;
        int currY = 0, leftY = 0, rightY = 0;
        int outputX, outputY;
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        
        while((pL < nL) && (pR < nR)){
            List<Integer> pointL = leftSkyline.get(pL);
            List<Integer> pointR = rightSkyline.get(pR);
            
            int xIndex = 0;
            int htIndex = 1;
            
            if(pointL.get(xIndex) < pointR.get(xIndex)){
                outputX = pointL.get(xIndex);
                leftY = pointL.get(htIndex);
                pL++;
            }else {
                outputX = pointR.get(xIndex);
                rightY = pointR.get(htIndex);
                pR++;
            }
            
            outputY = Math.max(leftY, rightY);
            if(currY != outputY){
                currY = outputY;
                updateOutput(output, outputX, outputY);
            }
        }
        appendSkyLine(output, leftSkyline, pL, nL, currY);
        appendSkyLine(output, rightSkyline, pR, nR, currY);
        return output;
    }
    
    private void appendSkyLine(List<List<Integer>> output, List<List<Integer>> skyline, int p, int n, int currY){
        while(p < n){
            List<Integer> point = skyline.get(p);
            int xCoordIndex = 0;
            int htIndex = 1;
            int x = point.get(xCoordIndex);
            int y = point.get(htIndex);
            p++;
            
            if(currY != y){
                currY = y;
                updateOutput(output, x, y);
            }
        }
    }
    
    private void updateOutput(List<List<Integer>> output, int x, int y){
        int lastIndex = output.size() - 1;
        int xIndex = 0;
        
        if(output.isEmpty() || output.get(lastIndex).get(xIndex) != x){
            output.add(new ArrayList<Integer>(){
                {
                    add(x); 
                    add(y);
                }
            });
        }else {
            int htIndex = 1;
            output.get(lastIndex).set(htIndex, y);
        }
    }
    
    
}