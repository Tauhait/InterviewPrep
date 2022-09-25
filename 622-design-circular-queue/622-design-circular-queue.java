class MyCircularQueue {
    private int[] circularArr;
    private int tail;
    private int head;
    private int k;
    private int curSize;
    public MyCircularQueue(int k) {
        circularArr = new int[k];
        head = 0;
        tail = -1;
        this.k = k;
        curSize = 0;
    }
    
    public boolean enQueue(int value) {
        if(isFull())
            return false;
        tail = (tail + 1) % k;
        circularArr[tail] = value;
        curSize++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty())
            return false;
        head = (head + 1) % k;
        curSize--;
        return true;
    }
    
    public int Front() {
        if(isEmpty())
            return -1;
        return circularArr[head];
    }
    
    public int Rear() {
        if(isEmpty())
            return -1;
        return circularArr[tail];
    }
    
    public boolean isEmpty() {
        return curSize == 0;
    }
    
    public boolean isFull() {
        return curSize == k;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */