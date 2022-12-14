package 每日一题;

public class _1775通过最少操作次数使数组的和相等 {
  public static void main(String[] args) {
    System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
  }

  public static int minOperations(int[] nums1, int[] nums2) {
    int len1 = nums1.length;
    int len2 = nums2.length;
    return 0;
  }

  public static int removeElement(int[] nums, int val) {
    int len = nums.length;
    int sum = 0;
    for (int i = 0; i < len; i++) {
      if (nums[i] != val) {
        sum++;
      }
    }
    return sum;
  }
}