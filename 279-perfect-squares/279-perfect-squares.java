class Solution {
    /*
    Note: in a typical BFS algorithm, the queue variable usually would be of array or list type. 
    However, here we use the set type, in order to eliminate the redundancy of remainders within the same level. 
    As it turns out, this tiny trick could even provide a 5 times speedup on running time.
    */
  public int numSquares(int n) {

    ArrayList<Integer> square_numsList = new ArrayList<Integer>();
    for (int i = 1; i * i <= n; ++i) {
      square_numsList.add(i * i);
    }

    Set<Integer> queue = new HashSet<Integer>();
    queue.add(n);

    int level = 0;
    while (queue.size() > 0) {
      level += 1;
      Set<Integer> next_queue = new HashSet<Integer>();
        //runs at each level
      for (Integer remainder : queue) {
        for (Integer square : square_numsList) {
          if (remainder.equals(square)) {
            return level;
          } else if (remainder > square) {
            next_queue.add(remainder - square);
          } else {
              break;//if rem <  current sq, then it will happen for rest of the sq in the list so break
          }
        }
      }
      queue = next_queue;
    }
    return level;
  }
}