package 平常练习.已完成;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToDoubleBiFunction;

public class _67二进制求和 {
    public static void main(String[] args) {
System.out.println(addBinary("1010", "1011"));
    }

    /*
     * 给你两个二进制字符串，返回它们的和（用二进制表示）。
     * 
     * 输入为 非空 字符串且只包含数字 1 和 0。
     * 
     */
    public static String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int alen = a.length() - 1;
        int blen = b.length() - 1;
        //代表进位
        int add = 0;
        int sum = 0;
        while (alen >= 0 || blen >= 0 || add == 1) {
            int num1 = alen >= 0 ? a.charAt(alen) - '0' : 0;
            int num2 = blen >= 0 ? b.charAt(blen) - '0' : 0;
            sum = num1 + num2 + add;
            //进位是除以2的值
            add = sum / 2;
            //添加的值是除以2的余数
            res.append(sum % 2);
            alen--;
            blen--;
        }
        //因为是反着添加的所以需要反转
        return res.reverse().toString();
    }

}
