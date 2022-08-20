package 平常练习;

import java.util.ArrayList;
import java.util.List;

public class _77组合 {
    public static void main(String[] args) {
        List<List<Integer>> res = combine(3, 2);
        System.out.println(res);
    }

    /*
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     * 
     * 你可以按 任何顺序 返回答案。
     */

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        process(n + 1, k, 1, 0,res,tempList);
        return res;
    }

    /**
     * 
     * @param n     n代表范围
     * @param k     k代表个数
     * @param index index代表当前位置
     * @param len   len代表现在使用了多少个数字
     */
    public static void process(int n, int k, int index, int len, List<List<Integer>> res, List<Integer> tempList) {
        //使用了k个数就返回，完成了目标
        if (len == k ) {
            res.add(new ArrayList<>(tempList));
            return ;
        }
        for (int j = index; j < n; j++) {
            tempList.add(j);
            //递归的去添加后面的数
            process(n, k, index + 1, len + 1, res, tempList);
            tempList.remove(tempList.size() - 1);
            //运行到此步说明要进行下一个数字的组合，此时的位置已经向后移动了一步，所以index++
            index++;
        }
    }
}
