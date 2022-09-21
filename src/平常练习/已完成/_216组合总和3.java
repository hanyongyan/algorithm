package 平常练习.已完成;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

public class _216组合总和3 {
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 9));
    }

    /*
     * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
     * 
     * 只使用数字1到9
     * 每个数字 最多使用一次 
     * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
     */
    // public static List<List<Integer>> res = new ArrayList<>();
    // public static List<Integer> tempList = new ArrayList<>();

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        process(k, n, 1,res,tempList);
        return res;
    }

    /**
     * 
     * @param k   k个数
     * @param n   和为n
     * @param cur 当前位置
     */
    public static void process(int k, int n, int cur,List<List<Integer>> res,List<Integer> tempList) {
        // 使用了k个数而且k个数的和为n
        if (n == 0 && k == 0) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        if (n < 0 || k < 0) {
            return;
        }
        for (int i = cur; i <= 9; i++) {
            if(n-i<0){
                return;
            }
            // 当前这个数要
            tempList.add(i);
            // i + 1 是因为当前选择了 i 下一个应该从 i + 1 进行选择
            process(k - 1, n - i, i + 1,res,tempList);
            tempList.remove(tempList.size() - 1);
            // 删除以后就是这个数不要
        }

    }
}
