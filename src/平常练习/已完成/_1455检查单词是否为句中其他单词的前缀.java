package 平常练习.已完成;

public class _1455检查单词是否为句中其他单词的前缀 {
    public static void main(String[] args) {
        int res = isPrefixOfWord("i love eating burger", "burg");
        System.out.println(res);
    }

    /*
     * 给你一个字符串 sentence 作为句子并指定检索词为 searchWord ，其中句子由若干用 单个空格 分隔的单词组成。请你检查检索词
     * searchWord 是否为句子 sentence 中任意单词的前缀。
     * 
     * 如果 searchWord 是某一个单词的前缀，则返回句子 sentence 中该单词所对应的下标（下标从 1 开始）。如果 searchWord
     * 是多个单词的前缀，则返回匹配的第一个单词的下标（最小下标）。如果 searchWord 不是任何单词的前缀，则返回 -1 。
     * 
     * 字符串 s 的 前缀 是 s 的任何前导连续子字符串。
     */
    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] strs = sentence.split(" ");
        int index = 0;
        int len = searchWord.length();
        for (index = 0; index < strs.length; index++) {
            if (strs[index].length()>=len && searchWord.equals(strs[index].substring(0,len))) {
                return index + 1;
            }
        }
        return -1;
    }
}
