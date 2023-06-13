class MinStack {
    private class Node {
        Integer item;
        Integer minItem;
        Node next;
        private Node(Integer item, Integer minItem){
            this.item = item;
            this.minItem = minItem;
            next = null;
        }
    }

    private Node top;

    public MinStack() {
        top = new Node(null, null);
    }
    
    public void push(int val) {
        if(isEmpty()){
            Node newNode = new Node(val, val);
            top.next = newNode;
        } else {
            int minSoFar = Math.min(val, top.next.minItem);
            Node newNode = new Node(val, minSoFar);
            newNode.next = top.next;
            top.next = newNode;
        }        
    }
    
    private boolean isEmpty(){
        return top.next == null;
    }
    public void pop() {
        top.next = top.next.next;        
    }
    
    public int top() {
        return top.next.item;
    }
    
    public int getMin() {
        return top.next.minItem;
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