class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        // Calculate all the strengths and put strength/ index pairs into an array.
        int[][] pairs = new int[m][2];

        for (int i = 0; i < m; i++) {
            int strength = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) break;
                strength++;
            }
            pairs[i][0] = strength;
            pairs[i][1] = i;
        }

        /* Sort the pairs, firstly on strength and secondly on index. We'll need
         * to implement a comparator to do this. */
        Arrays.sort(pairs, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            else return a[0] - b[0];
        });

        // Pull out the first k indexes of the sorted array to return.
        int[] indexes = new int[k];
        for (int i = 0; i < k; i++) {
            indexes[i] = pairs[i][1];
        }
        return indexes;

    }
}