class Solution {
    private int[] hourDict = new int[]{ 8, 4, 2, 1};
    private int[] minuteDict = new int[]{ 32, 16, 8, 4, 2, 1};
    
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        if(turnedOn == 0){
            result.add("0:00");
            return result;
        }

        for(int i = 0; i <= turnedOn; i++){
            List<Integer> hours = getHours(i);
            List<Integer> minutes = getMinutes(turnedOn - i);

            for(Integer hour : hours){
                for(Integer minute : minutes){
                    result.add(String.format("%d:%02d", hour, minute));
                }
            }
        }
        return result;
    }

    private List<Integer> getHours(int turnedOn){
        List<Integer> list = new ArrayList<>();
        helper(hourDict, 0, 0, 0, turnedOn, list, 12);
        return list;
    }
    
    private List<Integer> getMinutes(int turnedOn){
        List<Integer> list = new ArrayList<>();
        helper(minuteDict, 0, 0, 0, turnedOn, list, 60);
        return list;
    }

    private void helper(int[] array, int curSum, int index, int level, int turnedOn, List<Integer> list, int max){
        if(level == turnedOn && curSum < max){
            list.add(curSum);
            return;
        }
        for(int i = index; i < array.length; i++){
            curSum += array[i];
            helper(array, curSum, i + 1, level + 1, turnedOn, list, max);
            curSum -= array[i];
        }
    }
}