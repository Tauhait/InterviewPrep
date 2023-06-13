class MyQueue {
    private Stack<Integer> input;
    private Stack<Integer> output;
    private int peekEl;
    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
        peekEl = -1;
    }
    
    public void push(int x) {
        if(input.isEmpty()){
            peekEl = x;
        }        
        input.push(x);
    }
    
    public int pop() {
        if(output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }
        return output.pop();
    }
    
    public int peek() {
        if(output.isEmpty()){
            return peekEl;
        }
        return output.peek();
    }
    
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
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