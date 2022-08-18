package 平常练习.已完成;



public class _5最长回文子串 {
    public static void main(String[] args) {
        String str = "asdfghjkllkjhgfdsa";
        String s1 = ways1(str);
        String s2 = ways2(str);
        System.out.println(s1);
        System.out.println(s2);
    }

    //暴力解法
    public static String ways1(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        //最长回文串的长度
        int maxLen = 1;
        //回文串的起始位置
        int begin = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i+1; j < len; j++) {
                if (j - i + 1 > maxLen && process1(s.toCharArray(), i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     *从left...right依次收缩判断是否是回文串
     * @param str           整个字符串
     * @param left          传入左边界
     * @param right         传入有边界
     * @return              从left -> right是不是回文串
     */
    public static boolean process1(char[] str, int left, int right) {
        while (left<right) {
            if (str[left] != str[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    //中心扩散法
    public static String ways2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        //max1为奇数范围的回文串，max2是偶数范围
        int max1 = 0;
        int max2 = 0;
        int curMax = 0;

        for (int i = 0; i < len - 1; i++) {
            max1 = process2(s.toCharArray(), i, i);
            max2 = process2(s.toCharArray(), i, i + 1);
            curMax = Math.max(max1, max2);
            if (curMax > maxLen) {
                maxLen = curMax;
                begin = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 判断中心位置为 i， j 的最长回文串
     *
     * @param str 由整个串判断
     * @param i   中心串的左边
     * @param j   中心串的右边
     * @return 返回最长回文串的长度
     */
    public static int process2(char[] str, int i, int j) {
        while (i >= 0 && j <= str.length - 1) {
            if (str[i] == str[j]) {
                i--;
                j++;
            } else {
                break;
            }
        }
        return j - i - 1;
    }

}
