class Tri {
  private int n = 38;
  public int[] nums = new int[n];
  Tri() {
    nums[1] = 1;
    nums[2] = 1;
    for (int i = 3; i < n; ++i)
      nums[i] = nums[i - 1] + nums[i - 2] + nums[i - 3];
  }
}

class Solution {
  public static Tri t = new Tri();
  public int tribonacci(int n) {
    return t.nums[n];
  }
}