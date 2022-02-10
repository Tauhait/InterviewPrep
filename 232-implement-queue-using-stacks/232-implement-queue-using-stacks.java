class MyQueue {
    private Stack<Integer> stk1;
    private Stack<Integer> stk2;
    private Integer front;
    public MyQueue() {
        stk1 = new Stack();
        stk2 = new Stack(); 
        front = null;
    }
    
    public void push(int x) { 
        if(stk1.isEmpty()){
            front = x;
        }
        stk1.push(x);
    }
    
    public int pop() {
        while(!stk1.isEmpty()){
            stk2.push(stk1.pop());
        }
        int val = stk2.pop();
        if(!stk2.isEmpty()){
            front = stk2.peek();
        }else {
            front = null;
        }
        
        while(!stk2.isEmpty()){
            stk1.push(stk2.pop());
        }
        return val;
    }
    
    public int peek() {
        return front;
    }
    
    public boolean empty() {
        return stk1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */