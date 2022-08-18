package 平常练习.已完成;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class _17电话号码的字母组合 {
    public static void main(String[] args) {
        List<String> list1 = letterCombinations("");
        System.out.println(list1);

    }

    //暴力解法
    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return list;
        }
        process(digits, 0, "");
        return list;
    }

    /**
     *
     * @param digits        需要转化的字符串
     * @param index         使用index的到当前需要去转化的数字
     * @param str           当前生成的字符串
     */
    public static void process(String digits, int index,String str) {
        if (index == digits.length()) {
            list.add(str);
            return;
        }
        String s1 = map.get(digits.charAt(index));
        //循环使用当前数字对应的字符串中的字符
        for (int i = 0; i < s1.length(); i++) {
            //依次调用下一个数字对应的字符串中的字符
            process(digits,index+1,str+s1.charAt(i));
        }
    }

    public static Map<Character, String> map =
            Map.of('2', "abc", '3', "def",'4', "ghi",
                    '5', "jkl",'6', "mno",'7', "pqrs",'8', "tuv",'9', "wxyz");


    public static List<String> list = new ArrayList<>();
}
