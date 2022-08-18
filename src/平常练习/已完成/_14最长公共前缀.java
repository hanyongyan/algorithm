package 平常练习.已完成;

import java.util.Arrays;

public class _14最长公共前缀 {
    public static void main(String[] args) {
        String[] str = { "flower", "flow", "flight" };
        String perfix1 = ways1(str);
        String perfix2 = ways2(str);
        String perfix3 = ways3(str);
        String perfix4 = ways4(str);
        System.out.println(perfix1);
        System.out.println(perfix2);
        System.out.println(perfix3);
        System.out.println(perfix4);
    }

    /*
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     */

    /*
     * 纵向对比，找出最长公共前缀
     */

    public static String ways1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int len = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < len; i++) {
            // 比对第i个字符是否相同
            // c代表了strs[0]的第i个字符
            char c = strs[0].charAt(i);
            // j代表了除了strs[0]之外的字符串
            for (int j = 1; j < count; j++) {
                // 如果长度到达了第 j 个字符串的长度或者两个字符不相等时，比对结束返回结果
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        // 以上条件完全符合说明，strs[0]完全与其他匹配
        return strs[0];
    }

    /*
     * 横向对比，找出最长公共前缀
     * perfix(0, strs.length - 1) = perfix(((0,1),2)...n-1)
     */
    public static String ways2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String perfix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            // perfix代表前i个字符串的最长公共前缀
            perfix = process2(perfix, strs[i]);
            // 说明没有公共字符串，直接返回即可
            if (perfix.length() == 0) {
                return perfix;
            }
        }
        return perfix;
    }

    /*
     * 判断两个字符串的最长公共前缀
     */
    public static String process2(String str1, String str2) {
        int minLen = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < minLen) {
            if (str1.charAt(index) != str2.charAt(index)) {
                // 两字符串不等时，说明最长公共前缀结束
                return str1.substring(0, index);
            }
            index++;
        }
        // 较短的串与较长的串是完全匹配的，返回较短的串
        return str1.substring(0, minLen);
    }

    /*
     * 分治法
     * perfix(0, strs.length - 1) = perfix(0, mid) + perfix(mid + 1, strs.length -
     * 1)
     */
    public static String ways3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String perfix = process3(strs, 0, strs.length - 1);
        return perfix;
    }

    public static String process3(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        }
        // 这样获得mid而不是使用（start + end）/ 2是防止溢出
        int mid = (end - start) / 2 + start;
        String perfix1 = process3(strs, start, mid);
        String perfix2 = process3(strs, mid + 1, end);
        String perfix = process4(perfix1, perfix2);
        return perfix;
    }

    public static String process4(String str1, String str2) {
        int minLen = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < minLen) {
            if (str1.charAt(index) != str2.charAt(index)) {
                // 两字符串不等时，说明最长公共前缀结束
                return str1.substring(0, index);
            }
            index++;
        }
        // 较短的串与较长的串是完全匹配的，返回较短的串
        return str1.substring(0, minLen);
    }

    /*
     * 先完成排序，对比第一个和最后一个即可，由于是字典序排序所以可以这样对比
     */
    public static String ways4(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs);
        String start = strs[0];
        String end = strs[strs.length - 1];
        int minLen = Math.min(start.length(), end.length());
        int i;
        for (i = 0; i < minLen; i++) {
            if (start.charAt(i) != end.charAt(i)) {
                return start.substring(0, i);
            }
        }
        return start.substring(0, i);
    }
}
