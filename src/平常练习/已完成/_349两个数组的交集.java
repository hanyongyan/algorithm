package 平常练习.已完成;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _349两个数组的交集 {
    public static void main(String[] args) {
        int[] arr = intersection(new int[]{1,2,2,1}, new int[]{2,2});
        for (int arr2 : arr) {
            System.out.println(arr2);
        }
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i]))
                res.add(nums2[i]);
        }
        // 将 set 转为 int 数组
        return res.stream().mapToInt(x->x).toArray();
    }
}