class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> times = new ArrayList<>();
        int shift = 1 << 6;
        for (int h = 0; h < 12; h++){ 
            for (int m = 0; m < 60; m++){ 
                if (Integer.bitCount(h * shift + m) == turnedOn){
                    times.add(String.format("%d:%02d", h, m));
                }                    
            }                
        }
            
        return times;  
    }
}