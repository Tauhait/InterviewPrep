class MedianFinder {
    private ArrayList<Integer> myList;

    public MedianFinder() {
        myList = new ArrayList<Integer>();
    }
    //to find the insertion position of new element
    private int binarySearch(int val){//O(log n)
        int low = 0;//set low to starting index always for BS
        int high = myList.size() - 1;//set high to end index always for BS
        
        while(low <= high){
            int mid = low + (high - low)/2;
            if(val < myList.get(mid)){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }
    
    public void addNum(int num) {//O(n) : inserting into linear DS 
        if(myList.size() == 0){
            myList.add(num);
        }else {
            int insertIndex = binarySearch(num);
            if(insertIndex == myList.size()){
                myList.add(num);
            }else {
               myList.add(insertIndex, num); 
            }            
        }        
    }
    
    public double findMedian() {
        // for(Integer i : myList){
        //     System.out.print(i + " ");
        // }
        // System.out.println("\n");
        int listSize = myList.size();
        if(listSize % 2 == 0){
            return (myList.get(listSize/2 - 1) + myList.get(listSize/2))/2.0f;
        }else {
            return myList.get(listSize/2);
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */