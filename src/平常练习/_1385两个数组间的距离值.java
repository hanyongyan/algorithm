package 平常练习;

import java.util.Arrays;

public class _1385两个数组间的距离值 {
    public static void main(String[] args) {
        System.out.println(findTheDistanceValue(new int[] { 2, 1, 100, 3 }, new int[] { -5, -2, 10, -3, 7 }, 6));
    }

    /*
     * 给你两个整数数组 arr1 ， arr2 和一个整数 d ，请你返回两个数组之间的 距离值 。
     * 
     * 「距离值」 定义为符合此距离要求的元素数目：对于元素 arr1[i] ，不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d
     * 。
     */
    // 无脑解法
    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int ans = 0;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        ONE: for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                int temp = Math.abs(arr1[i] - arr2[j]);
                if (temp <= d) {
                    continue  ONE;
                }
            }
            ans++;
        }
        return ans;
    }
}
