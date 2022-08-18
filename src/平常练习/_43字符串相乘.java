package 平常练习;

import java.math.BigInteger;
import java.time.temporal.Temporal;

public class _43字符串相乘 {
    public static void main(String[] args) {

        System.out.println(multiply("498828660196", "840477629533"));
    }

    /*
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     */
    public static String multiply(String num1, String num2) {
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;

        String ans = "0";
        int zero = 0;
        //使用方法类似与手动计算乘法
        for (int i = len1; i >= 0; i--) {
            String tempAns = "";
            int add = 0;
            int j = len2;
            //完成一个字符对应num2的乘法
            while (j >= 0 || add != 0) {
                int x = num1.charAt(i) - '0';
                int y = j >= 0 ? num2.charAt(j) - '0' : 0;
                tempAns = tempAns+((x * y + add) % 10);
                add = (x * y + add) / 10;
                // 开始下一位置的比较
                j--;
            }
            // 先反转再补0
            tempAns = new StringBuilder(tempAns).reverse().toString();
            for (int k = 0; k < zero; k++) {
                tempAns= tempAns +"0";
            }
            //使补0的个数增加
            zero++;
            //此处即使使用long也会爆掉
            BigInteger tempAnsBig = new BigInteger(tempAns);
            BigInteger ansBig = new BigInteger(ans);
            BigInteger temp = ansBig.add(tempAnsBig);
            // Long temp = Long.parseLong(tempAns) + Long.parseLong(ans);
            ans = String.valueOf(temp);
            // ans = addStrings(tempAns, ans);没有使用此句是因为415题已经写过不需要反复使用，使用更简单的完成假发
        }
        return ans;
    }

    /*
     * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
     * 同时下面这个方法也是415题 字符串相加 的解法
     */
    public static String addStrings(String num1, String num2) {
        // 获取两个字符串的长度
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        // add代表进位
        int add = 0;
        StringBuilder ans = new StringBuilder();
        // 先从最后面的字符开始比较
        // add != 0 是防止最后的进位没有添加上去
        while (len1 >= 0 || len2 >= 0 || add != 0) {
            int x = len1 >= 0 ? num1.charAt(len1) - '0' : 0;
            int y = len2 >= 0 ? num2.charAt(len2) - '0' : 0;
            // ans添加当前位置的字符和上一位置的字符的进位除以10的余数
            ans.append((x + y + add) % 10);
            // 将进位保存在add中
            add = (x + y + add) / 10;
            // 开始下一位置的比较
            len1--;
            len2--;
        }
        // 因为是使用append方法添加字符，所以需要将add的值反转
        return ans.reverse().toString();
    }
}
