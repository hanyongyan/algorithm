package 贪心;

import java.util.HashMap;
import java.util.Map;

public class _409最长回文串 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }

    /*
     * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
     * 
     * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
     */

    public static int longestPalindrome(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (Integer integer : map.values()) {
            res += integer/2*2;
            if(integer%2==1&&res%2==0){
                res++;
            }
        }
        return res;
    }
}
