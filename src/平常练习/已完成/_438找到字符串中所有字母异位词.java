package 平常练习.已完成;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _438找到字符串中所有字母异位词 {
    public static void main(String[] args) {
        List<Integer> list = findAnagrams("abab", "ab");
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    /*
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     * 
     * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
     */

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int sLen=s.length();
        int pLen=p.length();
    
        if(sLen<pLen){
            return ans;
        }
        //建立两个数组存放字符串中字母出现的词频，并以此作为标准比较
        int [] sCount=new int[26];
        int [] pCount=new int[26];
    
        //当滑动窗口的首位在s[0]处时 （相当于放置滑动窗口进入数组）
        for(int i=0;i<pLen;i++){
            ++sCount[s.charAt(i)-'a']; //记录s中前pLen个字母的词频
            ++pCount[p.charAt(i)-'a']; //记录要寻找的字符串中每个字母的词频(只用进行一次来确定)
        }
    
        //判断放置处是否有异位词     (在放置时只需判断一次)
        if(Arrays.equals(sCount,pCount)){
             ans.add(0);
        }   
    
        //开始让窗口进行滑动
        for(int i=0;i<sLen-pLen;i++){ //i是滑动前的首位
            --sCount[s.charAt(i) -'a'];       //将滑动前首位的词频删去
            ++sCount[s.charAt(i+pLen) -'a'];  //增加滑动后最后一位的词频（以此达到滑动的效果）
    
            //判断滑动后处，是否有异位词
            if(Arrays.equals(sCount,pCount)){
                ans.add(i+1);
            } 
        }
    
        return ans;
    }
    // 下面是暴力解法 超时
    // public static List<Integer> findAnagrams(String s, String p) {
    // int sLen = s.length();
    // int pLen = p.length();
    // if (sLen < pLen) {
    // return new ArrayList<>();
    // }
    // List<String> list = process(p);
    // List<Integer> res = new ArrayList<>();
    // int index = -1;
    // for (String string : list) {
    // searchAllIndex(s, string, res);
    // }
    // Collections.sort(res);
    // return res;
    // }

    // private static void searchAllIndex(String str, String key, List<Integer> res)
    // {
    // int a = str.indexOf(key);// *第一个出现的索引位置
    // while (a != -1) {
    // res.add(a);
    // a = str.indexOf(key, a + 1);// *从这个索引往后开始第一个出现的位置
    // }
    // }

    // // 下面的三个方法是为了寻找全排列
    // public static List<String> process(String p) {
    // Set<String> res = new HashSet<>();
    // process2(p, res, 0);
    // return new ArrayList<>(res);
    // }

    // // 得到所有的排列结果
    // public static void process2(String p, Set<String> res, int index) {
    // if (index == p.length() - 1) {
    // res.add(new String(p));
    // return;
    // }
    // for (int i = index; i < p.length(); i++) {
    // p = swap(p, index, i);
    // process2(p, res, index + 1);
    // p = swap(p, index, i);
    // }
    // }

    // // 交换位置
    // public static String swap(String p, int left, int right) {
    // char[] ch = p.toCharArray();
    // char c = ch[left];
    // ch[left] = ch[right];
    // ch[right] = c;
    // return new String(ch);
    // }
}
