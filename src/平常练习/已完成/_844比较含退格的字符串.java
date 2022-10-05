package 平常练习.已完成;

public class _844比较含退格的字符串 {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
        String[] s = "ab#c".split("#");
        for (String string : s) {
            System.out.println(string);
        }
    }

    public static boolean backspaceCompare(String s, String t) {
        StringBuilder ss = new StringBuilder();
        StringBuilder tt = new StringBuilder();
        int slen = s.length();
        int tlen = t.length();
        for (int i = 0; i < slen; i++) {
            if (ss.length() == 0 && s.charAt(i) == '#') {
                // 由题意可知
                continue;
            }
            if (s.charAt(i) != '#') {
                ss.append(s.charAt(i));
            } else {
                ss.deleteCharAt(ss.length() - 1);
            }
        }
        for (int i = 0; i < tlen; i++) {
            if (tt.length() == 0 && t.charAt(i) == '#') {
                // 由题意可知
                continue;
            }
            if (t.charAt(i) != '#') {
                tt.append(t.charAt(i));
            } else {
                tt.deleteCharAt(tt.length() - 1);
            }
        }
        return ss.toString().equals(tt.toString());
    }

}
