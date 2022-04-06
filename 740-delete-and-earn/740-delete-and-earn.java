class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxNumber = 0;
        HashMap<Integer, Integer> points = new HashMap<>();
        
        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(maxNumber, num);
        }
        
        int twoBack = 0;
        int oneBack = 0;
        int n = points.size();
        
        if (maxNumber < n + n * Math.log(n) / Math.log(2)) {
            oneBack = points.getOrDefault(1, 0);
            for (int num = 2; num <= maxNumber; num++) {
                int temp = oneBack;
                oneBack = Math.max(oneBack, twoBack + points.getOrDefault(num, 0));
                twoBack = temp;
            }
        } else {
            List<Integer> elements = new ArrayList<Integer>(points.keySet());
            Collections.sort(elements);
            oneBack = points.get(elements.get(0));
        
            for (int i = 1; i < elements.size(); i++) {
                int currentElement = elements.get(i);
                int temp = oneBack;
                if (currentElement == elements.get(i - 1) + 1) {
                    oneBack = Math.max(oneBack, twoBack + points.get(currentElement));
                } else {
                    oneBack += points.get(currentElement);
                }

                twoBack = temp;
            }
        }
        
        return oneBack;
    }
}