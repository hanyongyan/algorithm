package 平常练习.已完成;

public class 替换空格 {
    public static void main(String[] args) {

    }

    public static String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c != ' ') sb.append(c);
            else sb.append("%20");
        }
        return sb.toString();
    }
}
