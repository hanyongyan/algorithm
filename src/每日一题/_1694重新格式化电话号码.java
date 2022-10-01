package 每日一题;

public class _1694重新格式化电话号码 {
    public static void main(String[] args) {
        System.out.println(reformatNumber("123 4-5678"));
    }

    public static String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        char[] str = number.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] != '-' && str[i] != ' ') {
                sb.append(str[i]);
            }
        }
        StringBuilder res = new StringBuilder();
        int index = 0;
        int len = sb.length();
        while (index < len) {
            if (len - index > 4) {
                res.append(sb.charAt(index++));
                res.append(sb.charAt(index++));
                res.append(sb.charAt(index++));
                res.append("-");

            } else if (len - index == 4) {
                res.append(sb.charAt(index++));
                res.append(sb.charAt(index++));
                res.append("-");
                res.append(sb.charAt(index++));
                res.append(sb.charAt(index++));
            } else if(len - index == 3){
                res.append(sb.charAt(index++));
                res.append(sb.charAt(index++));
                res.append(sb.charAt(index++));
            }
             else if(len - index == 2){
                res.append(sb.charAt(index++));
                res.append(sb.charAt(index++));
            }
        }

        return res.toString();
    }
}
