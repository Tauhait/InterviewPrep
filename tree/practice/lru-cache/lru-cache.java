class LRUCache {
    private class DLL {
        private int key;
        private int value;
        private DLL prev;
        private DLL next;
        private DLL(int key, int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private int capacity;
    private int size;
    private DLL head;
    private DLL tail;
    private Map<Integer, DLL> valueNodeMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        valueNodeMap = new HashMap<>();
        head = new DLL(-1, -1);
        tail = new DLL(-1, -1);

        head.prev = null;
        head.next = tail;
        tail.prev = head;
        tail.next = null;
    }
    
    private void remove(DLL node){
        DLL nextNode = node.next;
        DLL prevNode = node.prev;
        node.prev.next = nextNode;
        node.next.prev = prevNode;
    }

    private void add(DLL node){
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    
    private void moveToHead(DLL node){
        remove(node);
        add(node);
    }

    public void put(int key, int value) {
        DLL valueNode = valueNodeMap.get(key);
        DLL newNode   = new DLL(key, value);
        valueNodeMap.put(key, newNode);
        add(newNode);
        if(valueNode != null){
            remove(valueNode); 
        } else {
            size++;             
            if(size > capacity){
                valueNodeMap.remove(tail.prev.key); // important line
                remove(tail.prev);
                size--;
            }            
        }
    }

    public int get(int key) {
        if(valueNodeMap.containsKey(key)) {
            DLL getNode = valueNodeMap.get(key);
            moveToHead(getNode);
            return getNode.value;
        }
        return -1;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */