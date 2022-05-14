class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {

        int m = mat.length;
        int n = mat[0].length;

        // Calculate all the strengths and put them into a HashMap.
        Map<Integer, List<Integer>> strengths = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int strength = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) break;
                strength++;
            }
            if (!strengths.containsKey(strength)) {
                strengths.put(strength, new ArrayList<>());
            }
            strengths.get(strength).add(i);
        }

        // Note that if we'd used a TreeMap instead of HashMap, the keys would
        // have already been sorted.
        List<Integer> sortedStrengths = new ArrayList<>(strengths.keySet());
        Collections.sort(sortedStrengths);

        // Pull out indexes for the k smallest strengths.
        int[] indexes = new int[k];
        int i = 0;
        for (int key : sortedStrengths) {
            for (int index : strengths.get(key)) {
                indexes[i] = index;
                i++;
                if (i == k) break;
            }
            if (i == k) break;
        }
        return indexes;
    }
}