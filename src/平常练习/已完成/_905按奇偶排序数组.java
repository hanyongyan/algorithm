package 平常练习.已完成;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _905按奇偶排序数组 {
    public static void main(String[] args) {

    }

    /*
     * 给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。
     * 
     * 返回满足此条件的 任一数组 作为答案。
     */
    public static int[] sortArrayByParity(int[] nums) {
        int len = nums.length;
        // 记录奇数
        Queue<Integer> odd = new LinkedList<>();
        // 记录偶数
        Queue<Integer> even = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] % 2 == 0) {
                even.add(nums[i]);
            } else {
                odd.add(nums[i]);
            }
        }
        int evenSize = even.size();
        for (int i = 0; i < evenSize; i++) {
            nums[i] = even.poll();
        }
        for (int i = evenSize; i < len; i++) {
            nums[i] = odd.poll();
        }
        return nums;
    }
    public static int[] ways2(int[] nums){
        int len = nums.length;
        int index=0;
        for (int i = 0; i < len; i++) {
            if(nums[i]%2==0){
                nums[index++] = nums[i];
            }
        }
        for (int i = 0; i < len; i++) {
            if(nums[i]%2==1){
                nums[index++] = nums[i];
            }
        }
        return nums;
    }
}
