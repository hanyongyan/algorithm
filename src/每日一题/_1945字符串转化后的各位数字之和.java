package 每日一题;
public class _1945字符串转化后的各位数字之和{
    public static void main(String[] args) {
        System.out.println(getLucky("iiii", 1));
    }

    public static int getLucky(String s, int k) {
        // 先将字符串转化为数字
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            sb.append(ch - 'a' + 1);
        }
        String digits = sb.toString();
        // 转换完毕
        // digits 是最终转换完成后的字符串，
        // i <= k 是要转换 k 此，digits.length() > 1是为了防止字符转只有一位的情况下一直进行转化
        for (int i = 1; i <= k && digits.length() > 1; ++i) {
            int sum = 0;
            for (int j = 0; j < digits.length(); ++j) {
                char ch = digits.charAt(j);
                sum += ch - '0';
            }
            digits = Integer.toString(sum);
        }

        return Integer.parseInt(digits);
    }
}