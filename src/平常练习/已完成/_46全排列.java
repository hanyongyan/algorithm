package 平常练习.已完成;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _46全排列 {
    public static void main(String[] args) {
        System.out.println(permute(new int[] { 1, 2, 3 }));
        System.out.println();
        
    }

    /*
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        //数据全部导入，方便数据的转换
        List<Integer> tempList = new ArrayList<>();
        for (int num : nums) {
            tempList.add(num);
        }
        process1(0, nums.length, list, tempList);
        return list;
    }

    public static void process1(int index,int len,List<List<Integer>> list ,List<Integer> tempList) {
        //说明已经遍历完整个数组
        if(index==len){
            //此处使用 new ArrayList<>(tempList) 而不是直接使用 list.add(tempList) 
            //是因为直接使用add(tempList) 是一个引用，添加的值会随tempList的改变而改变
            //我们需要的是某一时刻的快照，应该使用 new ArrayList<>(tempList)
            list.add(new ArrayList<>(tempList));
            // list.add(tempList);
            return ;
        }
        for(int j=index;j<len;j++){
            //使得index及后面的数字，均可以在index位置出现
            Collections.swap(tempList, index, j);
            process1(index+1, len, list, tempList);
            //因为上面调换了位置。所以要恢复初始模式
            Collections.swap(tempList, index, j);
        }
    }
}
