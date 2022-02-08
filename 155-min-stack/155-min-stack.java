class MinStack {
    private List<int[]> myList; 
    public MinStack() {
        myList = new ArrayList();
    }
    
    public void push(int val) {
        if(myList.isEmpty()){
            myList.add(new int[]{val, val});
        }else {
            int min = Math.min(val, myList.get(myList.size() - 1)[1]);
            myList.add(new int[]{val, min});
        }        
    }
    
    public void pop() {
        myList.remove(myList.size() - 1);
    }
    
    public int top() {
        return myList.get(myList.size() - 1)[0];
    }
    
    public int getMin() {
        return myList.get(myList.size() - 1)[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */