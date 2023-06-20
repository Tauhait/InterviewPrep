public class KMP {
	private void computeLPSArray(String pat, int[] lps) {
		int len = 0;
		int i = 1;
		int m = pat.length();
		lps[0] = 0;
		while (i < m) {
			if (pat.charAt(i) == pat.charAt(len)) {
				lps[i] = len + 1;
				len++;
				i++;			
			} else {
				if (len != 0) {
					len = lps[len - 1];
				} else {
					lps[i] = 0;
					i++;			
				}
			}
		}
	}

	public List<Integer> kmpMatch(String pat, String str) {
		List<Integer> matchPoints = new ArrayList<>();
		int n = str.length();
		int m = pat.length();
		int[] lps = new int[m];
		computeLPSArray(pat, lps);
		int i = 0, j = 0;
		while (i < n) {
			if (str.charAt(i) == pat.charAt(j)) {
				i++;
				j++;
			} else {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i += 1;
				}
			}
			if (j == m) {
				matchPoints.add(i - j);
				j = lps[j - 1];
			}
		}
		if (matchPoints.isEmpty()) {
			matchPoints.add(-1);
		}
		return matchPoints;
	}
}
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) return -1;
        // RabinKarp rk = new RabinKarp(26, 997);
				KMP kmp = new KMP();		
        return kmp.kmpMatch(needle, haystack).get(0);
    }
}