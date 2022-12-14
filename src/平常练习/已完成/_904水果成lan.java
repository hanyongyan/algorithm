package 平常练习.已完成;

import java.util.HashSet;
import java.util.Set;

public class _904水果成lan {
    public static void main(String[] args) {
        System.out.println(totalFruit(new int[] { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 }));
    }

    public static int totalFruit(int[] fruits) {
        // 使用 set 集合来判断 是否只摘了两种果子
        Set<Integer> set = new HashSet<>();
        int len = fruits.length;
        int pre = -1;
        int res = 0;
        for (int i = 0; i < len; i++) {
            // 先把当前数据加入 set
            set.add(fruits[i]);
            // 如果大于三就说明现在来到了第三种果子，我们就需要进行处理
            if (set.size() > 2) {
                // 因为是当前树是第三种果子，i-1位置的数就是第二种果子，我们需要排除第一种果子
                pre = i - 1;
                int tempDel = fruits[i - 1];
                // 当 pre 位置的果子与 第二种果子不同时，就找到了第一种果子
                while (fruits[pre] == tempDel) {
                    pre--;
                }
                // 我们从set集合中把第一种果子删掉，
                set.remove(fruits[pre]);
            }
            
            res = Math.max(res, i - pre);
        }
        return res;
    }
}
