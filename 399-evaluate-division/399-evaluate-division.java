class Solution {
    Map<String, Pair<String, Double>> gidWeightMap = new HashMap<String, Pair<String, Double>>();
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int len = equations.size();  
        
        for(int i = 0; i < len; i++){
            List<String> equation = equations.get(i);
            String dividend = equation.get(0), divisor = equation.get(1);
            double quotient = values[i]; 
            
            union(dividend, divisor, quotient);
        }
        
        double[] results = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            List<String> query = queries.get(i);
            String dividend = query.get(0), divisor = query.get(1);
            if(!gidWeightMap.containsKey(dividend) || !gidWeightMap.containsKey(divisor)){
                results[i] = -1.0;
            }else {
                Pair<String, Double> dividendEntry = find(dividend);
                Pair<String, Double> divisorEntry = find(divisor);
                
                String dividendGid = dividendEntry.getKey();
                String divisorGid = divisorEntry.getKey();
                
                Double dividendWeight = dividendEntry.getValue();
                Double divisorWeight = divisorEntry.getValue();
                
                if(!dividendGid.equals(divisorGid)){
                    results[i] = -1.0;
                }else {
                    results[i] = dividendWeight / divisorWeight;
                }
            }
        }
        return results;
    }
    private Pair<String, Double> find(String nodeId){
        if(!gidWeightMap.containsKey(nodeId)){
            gidWeightMap.put(nodeId, new Pair<String, Double>(nodeId, 1.0));
        }
        Pair<String, Double> entry = gidWeightMap.get(nodeId);
        
        if(!entry.getKey().equals(nodeId)){
            Pair<String, Double> newEntry = find(entry.getKey());
            gidWeightMap.put(nodeId, 
                             new Pair<String, Double>(newEntry.getKey(), entry.getValue() * newEntry.getValue()));
        }
        return gidWeightMap.get(nodeId);
    }
    private void union(String dividend, String divisor, Double value){
        Pair<String, Double> dividendEntry = find(dividend);
        Pair<String, Double> divisorEntry = find(divisor);
                
        String dividendGid = dividendEntry.getKey();
        String divisorGid = divisorEntry.getKey();
                
        Double dividendWeight = dividendEntry.getValue();
        Double divisorWeight = divisorEntry.getValue();
        if(!dividendGid.equals(divisorGid)){
            gidWeightMap.put(dividendGid, 
                             new Pair<String, Double>(divisorGid, divisorWeight * value / dividendWeight));
        }
    }
}
