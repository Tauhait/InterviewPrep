class MyStack {
    private List<Integer> q;
    public MyStack() {
        q = new LinkedList();
    }
    
    public void push(int x) {
        q.add(x);
    }
    
    public int pop() {
        if(!q.isEmpty()){
            int popElem = top();
            q.remove(q.size() - 1);
            return popElem;
        }
        return -1;
    }
    
    public int top() {
        if(!q.isEmpty()){
            return q.get(q.size() - 1);
        }
        return -1;
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