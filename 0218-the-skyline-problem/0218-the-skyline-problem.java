/*
1. break the buildings start and end into a single array with height
2. sort the above structure in asc order of x and then by height in desc order
3. start iterating from beginning maintain a treemap for add, delete ops 
*/
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> buildingPoints = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        for(int[] building : buildings){
            buildingPoints.add(new ArrayList<>(Arrays.asList(building[0], -building[2])));
            buildingPoints.add(new ArrayList<>(Arrays.asList(building[1],  building[2])));
        }
        Collections.sort(buildingPoints, (A,B)->{
            if(A.get(0)==B.get(0))
                return A.get(1)-B.get(1);
            else
                return A.get(0)-B.get(0);
            }
        );
        
        TreeMap<Integer,Integer> tMap = new TreeMap<>(Collections.reverseOrder());
        tMap.put(0,1);
        int prevHeight = -1;
        for(List<Integer> point : buildingPoints){
            int x = point.get(0);
            int ht = point.get(1);
            if(ht < 0){//start point
                ht *= -1;
                tMap.put(ht, tMap.getOrDefault(ht,0)+1);
            }else {//end point
                tMap.put(ht, tMap.getOrDefault(ht,0)-1);
                if(tMap.get(ht) == 0)
                    tMap.remove(ht);
                
            }
            int currHeight = tMap.firstKey();
            if(currHeight != prevHeight){                
                result.add(new ArrayList<>(Arrays.asList(x, currHeight)));
                prevHeight = currHeight;
            }
        }
        
        int prevX = -1;
        List<List<Integer>> finalResult = new ArrayList<>();
        for(int i = 0; i < result.size(); i++){
            List<Integer> res = result.get(i);
            if(prevX == -1 || prevX != res.get(0)){
                prevX = res.get(0);
                finalResult.add(res);
            }
            else {
                if(res.get(1) < finalResult.get(finalResult.size()-1).get(1))
                    finalResult.set(finalResult.size()-1, res);
            }
        }
        return finalResult;
    }
}