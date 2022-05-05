class MyStack {
    private LinkedList<Integer> q;
    public MyStack() {
        q = new LinkedList();
    }
    
    // Push element x onto stack.
    public void push(int x) {
        q.add(x);
        int sz = q.size();
        //we can invert the order of queue elements when pushing a new element.
        while (sz > 1) {
            q.add(q.remove());
            sz--;
        }
    }
    
    public int pop() {
        return q.remove();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */