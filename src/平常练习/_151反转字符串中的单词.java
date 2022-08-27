package 平常练习;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _151反转字符串中的单词 {
    public static void main(String[] args) {
       System.out.println(reverseWords("the sky is blue"));
    }

    /*
     * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
     * 
     * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
     * 
     * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
     * 
     * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
     * 
     *  
     */
    public static String reverseWords(String s) {
        //将字符串根据" " 分割开来
        String[] strs = s.split(" ");
        StringBuilder  res = new StringBuilder();
        for(int i=strs.length-1;i>=0;i--){
            //分割开来以后会存在 "" 这样的情况，需要去除
            if(!strs[i].equals("")){
                res.append(strs[i]).append(" ");
            }
        }
        //trim 去除前导空格和尾随空格
        return res.toString().trim();

    }

    //官方题解，没有上面的执行率高
    public static String reverseWords2String(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
        //join方法 按照list中元素的顺序 依次添加，每两次添加之间在添加一个 " "

    }
}
