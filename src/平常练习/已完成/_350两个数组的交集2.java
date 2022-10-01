package 平常练习.已完成;

import java.util.Arrays;

public class _350两个数组的交集2 {
    public static void main(String[] args) {
       int[] res = intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4});
       for (int i : res) {
         System.out.println(i);  
       }
    }

    // 暴力解法
    public static int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int x = 0;
        int y = 0;
        int[] tempRes = new int[len1 < len2 ? len1 : len2];
        int sum = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (x < len1 && y < len2) {
            if (nums1[x] == nums2[y]) {
                tempRes[sum] = nums1[x];
                sum++;
                x++;
                y++;
            } else if (nums1[x] > nums2[y]) {
                y++;
            } else if(nums1[x] < nums2[y]){
                x++;
            }
        }
        return Arrays.copyOfRange(tempRes, 0, sum);
    }
}
