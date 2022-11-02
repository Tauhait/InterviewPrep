class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Deque<String> q = new LinkedList<String>();
        Set<String> banksVisited = new HashSet<String>();
        Set<String> banks = new HashSet<String>();
        for(String b : bank)
            banks.add(b);
        final char[] genes = {'A','C','G','T'};
        q.add(start);
        banks.add(start);
        int steps = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                String current = q.pollFirst();
                if(current.equals(end))
                    return steps;
                for(int i = 0; i < 8; i++){
                    for(char gene : genes){
                        String mutation = current.substring(0,i) + gene + current.substring(i+1);
                        if(!banksVisited.contains(mutation) && banks.contains(mutation)){
                            banksVisited.add(mutation);
                            q.add(mutation);
                        }
                    }
                }
            }
            ++steps;
        }
        return -1;
    }
}