package 平常练习.已完成;

public class 左旋转字符串 {
    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg", 2));
    }

    public static String reverseLeftWords(String s, int n) {
        int len = s.length();
        int num = n % len;
        if (num == 0) {
            return s;
        }
        return s.substring(num, len) + s.substring(0, num);
    }
}
