package 平常练习;

public class _151反转字符串中的单词 {
    public static void main(String[] args) {
        String s=  reverseWords("  hello world  ");
        System.out.println(s);
    }
    /*
     * 1.先进行前置后置空格和中间多余的空格
     * 2.讲整个字符串反转
     * 3.在对里面的单个单词进行反转
     */

    public static String reverseWords(String s) {
        s = process1(s);
        s = process2(s);
        s=process3(s);
        return s;
    }

    // 1.先进行前置后置空格和中间多余的空格
    public static String process1(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        // 完场删除前置后置空格和中间多余的空格
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            }
            // 如果 sb 为空，比如目前在前置空格就不添加， 此种方法使得只有一个单词之间只有一个空格
            else if (!sb.isEmpty() && sb.charAt(sb.length() - 1) != ' ') {
                sb.append(s.charAt(i));
            }
        }
        String res = sb.toString();
        if(res.charAt(res.length()-1)!=' '){
            return res;
        }else return res.substring(0, res.length()-1);

    }

    // 2.将整个字符串反转
    public static String process2(String s) {
        int len = s.length();
        char[] str = new char[len];
        int index = len - 1;
        for (int i = 0; i < len; i++) {
            str[i] = s.charAt(index);
            index--;
        }
        return new String(str);
    }

    // 3.在对里面的单个单词进行反转
    public static String process3(String s) {
        int index = 0;
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') {
                sb.append(process2(s.substring(index, i))).append(' ');
                index = i + 1;
            }
        }
        sb.append(process2(s.substring(index)));
        return sb.toString();
    }
}
