class Solution {
    public String pushDominoes(String dominoes) {
        int len = dominoes.length();
        Queue<Pair<Integer,Character>> bfsQ = new LinkedList<>();
        for(int i = 0; i < len; i++){
            char c = dominoes.charAt(i);
            if(c != '.'){
                Pair<Integer,Character> action = new Pair<>(i,c);
                bfsQ.offer(action);
            }            
        }
        StringBuilder newDominoes = new StringBuilder(dominoes);
        while(!bfsQ.isEmpty()){
            int size = bfsQ.size();            
            while(size-- > 0){
                Pair<Integer,Character> push = bfsQ.poll();
                if(push.getValue() == 'L'){
                    if(push.getKey() - 1 >= 0 && dominoes.charAt(push.getKey()-1) == '.'){
                        if(push.getKey() - 2 >= 0) {
                            if(dominoes.charAt(push.getKey()-2) != 'R'){ 
                                newDominoes.setCharAt(push.getKey()-1, 'L');
                                Pair<Integer,Character> action = new Pair<>(push.getKey()-1,'L');
                                bfsQ.offer(action);
                            }
                        }else {
                            newDominoes.setCharAt(push.getKey()-1,'L');
                        }
                    }
                }else {
                    if(push.getKey() + 1 < len && dominoes.charAt(push.getKey()+1) == '.'){
                        if(push.getKey() + 2 < len){
                            if(dominoes.charAt(push.getKey()+2) != 'L'){ 
                                newDominoes.setCharAt(push.getKey()+1,'R');
                                Pair<Integer,Character> action = new Pair<>(push.getKey()+1,'R');
                                bfsQ.offer(action);
                            }
                        }else {
                            newDominoes.setCharAt(push.getKey()+1,'R');
                        }
                    }
                }
            }
            dominoes = newDominoes.toString();
        }
        return dominoes;
    }
}