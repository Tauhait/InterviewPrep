class Solution {

    private int binarySearch(int[] row) {
        int low = 0;
        int high = row.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (row[mid] == 1) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public int[] kWeakestRows(int[][] mat, int k) {

        // Calculate all the strengths using Binary Search and
        // put them into a TreeMap.
        Map<Integer, List<Integer>> strengths = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            int strength = binarySearch(mat[i]);
            if (!strengths.containsKey(strength)) {
                strengths.put(strength, new ArrayList<>());
            }
            strengths.get(strength).add(i);
        }

        // Note that if we'd used a TreeMap instead of HashMap, the keys would
        // have already been sorted.
        List<Integer> sortedStrengths = new ArrayList<>(strengths.keySet());
        Collections.sort(sortedStrengths);

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