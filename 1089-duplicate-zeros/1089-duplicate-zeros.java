class Solution {
    public void duplicateZeros(int[] a) {
        int i = 0, sh = 0;
        for (i = 0; sh + i < a.length; ++i) sh += a[i] == 0 ? 1 : 0;
        for (i = i - 1; sh > 0; --i) {
            if (i + sh < a.length) a[i + sh] = a[i];
            if (a[i] == 0) a[i + --sh] = a[i];
        }
    }
}