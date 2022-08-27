package 平常练习.已完成;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _49字母异位词分组 {
    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        String key = "123";
        List<String> list = map.getOrDefault(key, new ArrayList<String>());
        list.add("e");
        System.out.println(list);

    }

    /*
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     * 
     * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
     * 
     */
    //字母异位词排序以后得到字符串肯定是相同的，
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ch = s.toCharArray();
            //排序，
            Arrays.sort(ch);
            String key = new String(ch);
            //如果有此key则返回此key对应的value，否则返回我们设置的value
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);

        }
        return new ArrayList<List<String>>(map.values());
    }
}
