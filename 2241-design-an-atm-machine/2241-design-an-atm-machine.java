class ATM {
    private long[] notes;
    private int[] withdrawNotes;
    private final int[] values = { 20, 50, 100, 200, 500};
    public ATM() {
        notes = new long[5];
    }
    
    public void deposit(int[] banknotesCount) {        
        for(int i = 0; i < 5; i++){
            notes[i] += banknotesCount[i];
        }
    }
    
    public int[] withdraw(int amount) {        
        withdrawNotes = new int[5];
        
        for(int index = 4; index >= 0; index--){
            int numNotes = (int)Math.min(amount / values[index], notes[index]);
            withdrawNotes[index] = numNotes;
            amount -= numNotes * values[index];
        }
        if(amount != 0){
            return new int[]{-1};
        }
        for(int i = 0; i < 5; i++){
            notes[i] -= withdrawNotes[i];
        }
        return withdrawNotes;
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */