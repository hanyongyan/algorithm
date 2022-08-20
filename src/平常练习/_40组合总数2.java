package 平常练习;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;


public class _40组合总数2 {
    public static void main(String[] args) {
        System.out.println(ways1(new int[] { 14, 6, 25, 9, 30, 20, 33, 34, 28, 30, 16, 12, 31, 9, 9, 12, 34, 16, 25, 32,
                8, 7, 30, 12, 33, 20, 21, 29, 24, 17, 27, 34, 11, 17, 30, 6, 32, 21, 27, 17, 16, 8, 24, 12, 12, 28, 11,
                33, 10, 32, 22, 13, 34, 18, 12 }, 27));
    }

    /*
     * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * 
     * candidates 中的每个数字在每个组合中只能使用 一次 。
     * 
     * 注意：解集不能包含重复的组合。 
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Arrays.sort(candidates);
        
        process1(candidates, target, 0, res, list);
        return res;
    }

    public static void process1(int[] candidates, int target, int index, List<List<Integer>> res,
            List<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (index == candidates.length) {
            return;
        }
        for (int j = index; j < candidates.length; j++) {
            // 如果 target - candidates[j] < 0 ，那么 target - candidates[j+...] < 0
            if (target - candidates[j] < 0) {
                break;
            }
            // 减去重复情况
            if (j > index && candidates[j] == candidates[j - 1]) {
                continue;
            }
            list.add(candidates[j]);
            //j位置已经使用，去使用j后面的数据
            process1(candidates, target - candidates[j], j + 1, res, list);
            list.remove(list.size() - 1);

        }

    }

    // 此方法可行，不过暴力破解超时,上面是剪枝操作
    public static List<List<Integer>> ways1(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        process2(candidates, target, 0, res, list);
        return res;
    }

    public static void process2(int[] candidates, int target, int index, List<List<Integer>> res,
            List<Integer> list) {
        // 找到结果
        if (target == 0) {
            // 因为题目要求不能够重复，所以进行如下判断
            List<Integer> tempList = new ArrayList<>(list);
            Collections.sort(tempList);
            if (!res.contains(tempList)) {
                res.add(new ArrayList<>(tempList));
            }
            return;
        }
        // 超出长度也没有找到结果
        if (index == candidates.length) {
            return;
        }
        // index位置前的已经完成，只需查看index后面的即可
        for (int j = index; j < candidates.length; j++) {
            list.add(candidates[j]);
            process2(candidates, target - candidates[j], j + 1, res, list);
            list.remove(list.size() - 1);
        }
    }

}
