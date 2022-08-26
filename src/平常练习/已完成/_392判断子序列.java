package 平常练习.已完成;

public class _392判断子序列 {
    public static void main(String[] args) {
        System.out.println(isSubsequence("axc","ahbgdc"));
    }

    /*
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * 
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，
     * 而"aec"不是）。
     */
    public static boolean isSubsequence(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        int i = 0;
        int j = 0;
        while (i < slen && j < tlen) {
            // 当两个字符相等时，去判断两者的下一个字符
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            }
            // 当两个字符不等时，去判断t的当前字符的下一个字符，s的字符不变
            else
                j++;
        }
        // 如果s字符串对比完毕说明s是t的子序列
        if (i==slen)
            return true;
        return false;
    }
}
