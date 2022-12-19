package 平常练习.已完成;

public class _541反转字符串2 {
    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));
    }

    public static String reverseStr(String s, int k) {
        int len = s.length();
        char[] chars = s.toCharArray();
        // 除去 2k 剩余的个数
        int remain = len % (2 * k);
        // 能够以 2k 为基准反转多少次
        int num = len / (2 * k);
        for (int i = 0; i < num; i++) {
            chars = withReverseStr(chars, i * k * 2, i * k * 2 + k - 1);
        }
        if (remain >= k) {
            chars = withReverseStr(chars, num * 2 * k, num * 2 * k + k - 1);
        }
        if (remain < k) {
            chars = withReverseStr(chars, num * 2 * k, len - 1);
        }
        return new String(chars);
    }

    public static char[] withReverseStr(char[] chars, int left, int right) {
        char temp;
        for (; left < right; left++, right--) {
            temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
        }
        return chars;
    }
}
