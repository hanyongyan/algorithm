package 平常练习.已完成;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.print.attribute.IntegerSyntax;

public class _47全排列2 {
    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{-1,-1,2}));
    }

    /*
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return list;
        List<Integer> tempList = new ArrayList<>();
        for (Integer num : nums) {
            tempList.add(num);
        }
        process(tempList, list, 0, nums.length);
        return list;
    }

    public static void process(List<Integer> tempList, List<List<Integer>> list, int index, int length) {
        if(index==length){
            list.add(new ArrayList<>(tempList));
        }
        //数字的范围是 -10 ~ 10
        boolean[] judge = new boolean[21];
        for(int j=index;j<length;j++){
            //以为数字的范围是从 -10 开始，对应的数组下标为 0 ，所以要加上10
            int judgeNum = tempList.get(j)+10;
            //判断当前位置是否出现此数字，如果当前位置出现了此数字就跳过
            if(!judge[judgeNum]){
                //设置当前数字已经出现过
                judge[judgeNum]=true;
                Collections.swap(tempList, index, j);
                process(tempList, list, index+1, length);
                Collections.swap(tempList, index, j);
            }
        }
    }
}
