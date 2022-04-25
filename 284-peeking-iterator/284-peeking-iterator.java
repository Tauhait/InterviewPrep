// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    private List<Integer> itr = new ArrayList<Integer>();
    private int numElems;
    private int count = -1;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    while(iterator.hasNext()){
            itr.add(iterator.next());
        }
        numElems = itr.size();
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return itr.get(count + 1);
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    return itr.get(++count);
	}
	
	@Override
	public boolean hasNext() {
	    return (count + 1) < numElems;
	}
}