package 平常练习.已完成;

import java.util.Arrays;

public class _4寻找两个正序数组的中位数 {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }));
    }

    /*
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     * 
     * 算法的时间复杂度应该为 O(log (m+n)) 。
     */
    // 方法1
    // public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //     int len1 = nums1.length;
    //     int len2 = nums2.length;
    //     int[] num = new int[len1 + len2];
    //     // 下面是两个数组中有一个是空的情况
    //     if (len1 == 0) {
    //         if (len2 % 2 == 0) {
    //             return ((double) nums2[len2 / 2] + nums2[len2 / 2 - 1]) / 2;
    //         } else
    //             return (double) nums2[len2 / 2];
    //     }
    //     if (len2 == 0) {
    //         if (len1 % 2 == 0) {
    //             return ((double) nums1[len1 / 2] + nums1[len1 / 2 - 1]) / 2;
    //         } else
    //             return (double) nums1[len1 / 2];
    //     }
    //     int nums1Index = 0;
    //     int nums2Index = 0;
    //     int index = 0;
    //     while (nums1Index < len1 || nums2Index < len2) {
    //         // 判断是否到达了 数组的末尾
    //         int num1 = nums1Index == len1 ? Integer.MAX_VALUE : nums1[nums1Index];
    //         int num2 = nums2Index == len2 ? Integer.MAX_VALUE : nums2[nums2Index];
    //         if (num1 < num2) {
    //             num[index] = num1;
    //             index++;
    //             nums1Index++;
    //         } else if (num1 > num2) {
    //             num[index] = num2;
    //             index++;
    //             nums2Index++;
    //         } else {
    //             num[index++] = num1;
    //             num[index++] = num2;
    //             nums1Index++;
    //             nums2Index++;
    //         }
    //     }
    //     int lenSum = len1 + len2;
    //     if (lenSum % 2 == 0) {
    //         return ((double) num[lenSum / 2] + num[lenSum / 2 - 1]) / 2;
    //     } else
    //         return (double) num[lenSum / 2];
    // }

    // 方法二
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] nums = new int[len1 + len2];

        if (len1 == 0) {
            if (len2 % 2 == 0) {
                return ((double) nums2[len2 / 2] + nums2[len2 / 2 - 1]) / 2;
            } else
                return (double) nums2[len2 / 2];
        }
        if (len2 == 0) {
            if (len1 % 2 == 0) {
                return ((double) nums1[len1 / 2] + nums1[len1 / 2 - 1]) / 2;
            } else
                return (double) nums1[len1 / 2];
        }
        for (int i = 0; i < len1; i++) {
            nums[i] = nums1[i];

        }
        for (int i = len1; i < nums.length; i++) {
            nums[i] = nums2[i - len1];
        }
        Arrays.sort(nums);
        ;
        if (nums.length % 2 == 0) {
            return ((double) nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2;

        } else
            return (double) nums[nums.length / 2];

    }

    public static int[] pro(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] num = new int[len1 + len2];
        int nums1Index = 0;
        int nums2Index = 0;
        int index = 0;
        while (nums1Index < len1 || nums2Index < len2) {
            // 判断是否到达了 数组的末尾
            int num1 = nums1Index == len1 ? Integer.MAX_VALUE : nums1[nums1Index];
            int num2 = nums2Index == len2 ? Integer.MAX_VALUE : nums2[nums2Index];
            if (num1 < num2) {
                num[index] = num1;
                index++;
                nums1Index++;
            } else if (num1 > num2) {
                num[index] = num2;
                index++;
                nums2Index++;
            } else {
                num[index++] = num1;
                num[index++] = num2;
            }
        }
        return num;
    }
}
