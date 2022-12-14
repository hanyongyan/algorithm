package 平常练习.已完成;

import java.util.Arrays;
import java.util.Comparator;

public class _977有序数组的平方 {
  public static void main(String[] args) {
    int[] res = sortedSquares(new int[]{-4,-1,0,3,10})  ;
    for (int res2 : res) {
      System.out.println(res2);
    }
  }

  public static int[] sortedSquares(int[] nums) {
    Integer[] integerArr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
    Arrays.sort(integerArr, (Integer one, Integer two) -> {
      return Math.abs(one)-Math.abs(two);
    });
    int[] res = new int[nums.length];
    for (int i = 0; i < res.length; i++) {
      res[i] = integerArr[i]*integerArr[i];
    }
    return res;
  }
}
