package 平常练习.已完成;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _229多数元素2 {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] {4,1,3,1,3,3,1,2,3,2,4,2,1,4,4,4,4,4}));
        System.out.println(5/3);
    }

    /*
     * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
     */
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        //默认值设置为1是防止nums[i] != nums[i+1] 的情况会漏记一个数
        int number = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                number++;
            } else {
                //满足要求就添加
                if (number > len / 3) {
                    res.add(nums[i]);
                }
                //不等的情况重置
                number = 1;
            }
        }
        //防止到最后几个数满足要求但是不会运行到上面的else分支无法完成添加
        if (number >= len / 3) {
            res.add(nums[len - 1]);
        }
        return res;
    }
}
