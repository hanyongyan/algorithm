package 贪心.已完成;

import java.util.HashMap;
import java.util.Map;

public class _680验证回文串2 {
    public static void main(String[] args) {
        System.out.println(validPalindrome("abc"));
    }

    /*
     * 给你一个字符串 s，最多 可以从中删除一个字符。
     * 
     * 请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。
     */
    public static boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        // 假定s是一个回文串，先找到不等的两个地方
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left++;
            right--;
        }
        // 相当于一个从左边删除了一个，一个从右边删除了一个，判断两个是否能有一个回文串
        // 如果能有一个说明删除一个字符能够构成回文串
        return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
    }

    // 判断 left...right 是否为回文串
    public static boolean isPalindrome(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
