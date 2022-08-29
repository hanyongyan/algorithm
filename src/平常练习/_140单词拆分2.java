package 平常练习;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _140单词拆分2 {
    public static void main(String[] args) {
        List<String> res = wordBreak("pineapplepenapple", new ArrayList<>(List.of("apple","pen","applepen","pine","pineapple")));
        for (String string : res) {
            System.out.println(string + ",");
        }
    }

    

    /*
     * 给定一个字符串 s 和一个字符串字典 wordDict ，在字符串 s 中增加空格来构建一个句子，使得句子中所有的单词都在词典中。以任意顺序
     * 返回所有这些可能的句子。
     * 
     * 注意：词典中的同一个单词可能在分段中被重复使用多次。
     * 
     */
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        process(res, s, wordDict, "");
        return res.stream().map(str -> str.substring(0,str.length()-1)).toList();
    }



    public static boolean process(List<String> res, String s, List<String> wordDict, String curString) {
        if (s.equals("")) {
            res.add(curString);
            return true;
        }
        boolean ans = false;
        for (int i = 0; i < s.length(); i++) {
            if (wordDict.contains(s.subSequence(0, i + 1))) {
                curString = curString + s.substring(0, i + 1) + " ";
                ans = ans || process(res, s.substring(i + 1), wordDict, curString);
                curString = curString.substring(0, curString.length() - i - 2);
            }
        }
        return false;
    }
    
}
