class StockSpanner {
    List<Pair<Integer,Integer>> ll;
    
    public StockSpanner() {
        ll = new ArrayList<Pair<Integer,Integer>>();
    }
    
    public int next(int price) {
        int sz = ll.size();
        // System.out.println(sz);
        int span = 1;
        if(sz == 0){
            ll.add(new Pair(span, price));
        }else {            
            int ptr = sz-1;
            Pair<Integer,Integer> last = ll.get(ptr);
            while(price >= last.getValue()){
                int lastSpan = last.getKey();
                span += lastSpan;
                if(ptr-lastSpan >= 0){ 
                    last = ll.get(ptr-lastSpan);
                    ptr -= lastSpan;
                }
                else
                    break;
            }
            ll.add(new Pair(span, price));
        }
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */