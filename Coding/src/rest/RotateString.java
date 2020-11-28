package rest;

public class RotateString {
	public boolean rotateString(String A, String B) {
        int lenA = A.length();
        int lenB = B.length();
        if(lenA == 0 && lenB == 0){
            return true;
        }
        else if(lenA == lenB){
            A = A + A;
            return A.indexOf(B) >= 0;
        }
        else {
            return false;
        }              
    }
	public boolean rotateString_shorter(String A, String B) {
	    return A.length() == B.length() && (A + A).contains(B);
	}

	/*
	Boyer-Moore's approach is to try to match the last character of the pattern instead of the first one with the assumption that if there's not match at the end no need to try to match at the beginning. This allows for "big jumps" therefore BM works better when the pattern and the text you are searching resemble "natural text" (i.e. English)

	Knuth-Morris-Pratt searches for occurrences of a "word" W within a main "text string" S by employing the observation that when a mismatch occurs, the word itself embodies sufficient information to determine where the next match could begin, thus bypassing re-examination of previously matched characters. (Source: Wiki)

	This means KMP is better suited for small sets like DNA (ACTG)

	Boyer-Moore technique match the characters from right to left, works well on long patterns. knuth moris pratt match the characters from left to right, works fast on short patterns
	*/

}
