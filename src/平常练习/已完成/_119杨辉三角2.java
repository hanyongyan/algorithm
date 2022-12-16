package 平常练习.已完成;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _119杨辉三角2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(0);
        list.add(0, 4);
        for (Integer list2 : list) {
            System.out.println(list2);
        }
    }

    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i <= rowIndex; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    //使得这一排的第一个和最后一个都为1
                    row.add(1);
                } else {
                    //使得一排中的中间元素符合题意C.get(i-1).get(j-1) 是取上一排的第j-1个元素 后面那个是取上一排的第j个元素 因为本排的第j个元素由上一排的第j-1个元素与第j个元素相加
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(row);
        }
        return res.get(rowIndex);
    }
    
}
