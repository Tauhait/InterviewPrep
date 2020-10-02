package faang;

public class BullsAndCows {
	public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i<secret.length(); i++) {
            char secret_Ch = secret.charAt(i);
            char guess_Ch = guess.charAt(i);
            //same char and pos
            if (secret_Ch == guess_Ch) bulls++;
            else {
                //if already negative then the secret char is already seen in guess string previously thus they are both present but out of place
                if (numbers[secret_Ch-'0']++ < 0) cows++;
                //if already positive then the guess char is already seen in secret string previously thus they are both present but out of place
                if (numbers[guess_Ch-'0']-- > 0) cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }

}
