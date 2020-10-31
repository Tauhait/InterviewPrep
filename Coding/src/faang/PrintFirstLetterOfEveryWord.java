package faang;

public class PrintFirstLetterOfEveryWord {
	public String firstAlphabet(String S) {
        StringBuilder sb = new StringBuilder();
        S = S.trim();
        sb.append(S.charAt(0));
        for(int i = 1; i < S.length() - 1; i++){
            char c = S.charAt(i);
            if(c == ' ') sb.append(S.charAt(i+1));
        }
        return sb.toString();
    }

}
