package 每日一题;

import static org.junit.Assert.fail;

import java.util.Arrays;

public class 字符串轮转 {
    public static void main(String[] args) {
        System.out.println(isFlipedString("waterbottle", "erbottlewat"));
    }

    /*
     * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
     */
    public static boolean isFlipedString(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        // 两者长度不同肯定不是旋转而成的
        if (len1 != len2) {
            return false;
        }
        // 两者长度相同 有一个长度为 0 所以返回 true
        if (len1 == 0) {
            return true;
        }
        // 假设 s1 -> s2 字符串旋转了 j 个单位
        for (int i = 0; i < len1; i++) {
            boolean flag = true;
            for (int j = 0; j < len1; j++) {
                if (s1.charAt((i + j) % len1) != s2.charAt(j)) {
                    flag = false;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
}
