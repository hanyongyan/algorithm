package 每日一题;

import java.util.ArrayList;
import java.util.List;

public class _1441用栈操作构建数组 {
    public static void main(String[] args) {
        List<String> list = buildArray(new int[] { 2, 3, 4, 5, 8, 9, 10 }, 10);
        for (String string : list) {
            System.out.println(string);
        }
    }

    public static List<String> process(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int pre = 0;
        // 进行当前数字和上一个数字的对比
        for (int cur : target) {
            // 得到当前数字与前一个数字的差值 
            int len = cur - pre;
            // 当len != 1 时进行的 push and pop 操作
            for (int i = 0; i < len - 1; i++) {
                res.add("Push");
                res.add("Pop");
            }
            // 两者之差不为 1 ，前面的是进行的 中间少的值的运算，最后进行 push 操作
            res.add("Push");
            pre = cur;
        }
        return res;
    }

    public static List<String> buildArray(int[] target, int n) {

        List<String> res = new ArrayList<>();
        int length = target.length;
        int one = target[0];
        // 下面是完成第一个数字的 push 和 pop
        // 第一个数字为几 就 push 和 pop 几次
        for (int i = 0; i < one - 1; i++) {
            res.add("Push");
            res.add("Pop");
        }
        res.add("Push");
        // 完成 1... 位置的 push and pop
        for (int i = 1; i < length; i++) {
            // 判断当前位置与上一个位置两者的差
            int len = target[i] - target[i - 1];
            // 如果两者之差不为 1
            if (len != 1) {
                // 就一直进行 push and pop 操作
                // 为什么是 len - 1 呢，
                // 比如 target[i] = 8,target[i - 1] = 6，肯定是进行了 一次 Push and pop 所以是len - 1
                for (int j = 0; j < len - 1; j++) {
                    res.add("Push");
                    res.add("Pop");
                }
                // 最后肯定是 push 操作
                res.add("Push");
            } else {
                res.add("Push");
            }
        }
        return res;
    }
}
