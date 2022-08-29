package 平常练习.已完成;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _139单词拆分 {
    public static void main(String[] args) {
        System.out.println(
                ways1("ccacccbcab", new ArrayList<>(List.of("cc", "bb", "aa", "bc", "ac", "ca", "ba", "cb"))));
    }

    /*
     * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
     * 
     * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
     */
    public static boolean ways1(String s, List<String> wordDict) {
        if (s.equals("")) {
            return true;
        }
        boolean res = false;
        for (int i = 0; i < s.length(); i++) {
            // 如果wordList中包含 s.substring(0, i + 1)，就去递归查看 s.substring(i + 1) 作为s 去截取
            // 如果最后全部被截取掉，则只会剩下"",遇到这种情况就返回成功即可
            if (wordDict.contains(s.substring(0, i + 1))) {
                // 由于只有在成功的情况的会返回一个true，使用或运算只要有一例成功，最终返回的结果就为true
                res = res || ways1(s.substring(i + 1), wordDict);
            }
        }
        return res;
    }

    // 为上一个版本的剪枝操作
    public static Set<String> set = new HashSet<>();

    public static boolean ways2(String s, List<String> wordList) {
        if (s.equals("")) {
            return true;
        }
        // 如果set集合中包含此字符串直接返回false，原因在19行
        if (set.contains(s)) {
            return false;
        }
        boolean res = false;
        for (int i = 0; i < s.length(); i++) {
            // 如果wordList中包含 s.substring(0, i + 1)，就去递归查看 s.substring(i + 1) 作为s 去截取
            // 如果最后全部被截取掉，则只会剩下"",遇到这种情况就返回成功即可
            if (wordList.contains(s.substring(0, i + 1))) {
                // 由于只有在成功的情况的会返回一个true，使用或运算只要有一例成功，最终返回的结果就为true
                res = res || ways2(s.substring(i + 1), wordList);
                // 如果res为false，说明当前的s不能够拆分为wordList中的值，我们进行记录，防止重复计算
                if (!res) {
                    set.add(s);
                }
            }
        }
        return res;
    }

    // 暴力解法，最容易爆掉
    public static boolean ways3(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        process3(res, new StringBuilder(), 0, wordDict, wordDict.size() + 1);
        for (String string : res) {
            if (string.equals(s)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param res           存储所有结果
     * @param stringBuilder 当前拼接的字符串
     * @param index         当前所在list中的位置
     * @param wordDict      可使用的单词
     * @param len           一共有多少个可以使用的单词+1,+1是作为了终止条件
     */
    public static void process3(List<String> res, StringBuilder stringBuilder, int index,
            List<String> wordDict, int len) {
        if (index == len) {
            return;
        }
        for (int i = 0; i < len - 1; i++) {
            stringBuilder.append(wordDict.get(i));
            res.add(stringBuilder.toString());
            process3(res, stringBuilder, index + 1, wordDict, len);
            stringBuilder = stringBuilder.delete(stringBuilder.length() - wordDict.get(i).length(),
                    stringBuilder.length());
        }
    }
}
