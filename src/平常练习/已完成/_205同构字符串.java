package 平常练习.已完成;

import java.util.HashMap;
import java.util.Map;


public class _205同构字符串 {
    public static void main(String[] args) {
        System.out.println(isIsomorphic(  "badc", "baba"));
    }
  


    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            // 如果此键不存在添加
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
            }
            // 如果此键存在，但是此键对应的值与t.charAt(i)不同，说明不是同构
            else {
                char temp1 = map.get(s.charAt(i));

                if (temp1 != t.charAt(i)) {
                    return false;
                }
            }

        }
        return true;

        // Map<Character, Character> s2t = new HashMap<Character, Character>();
        // Map<Character, Character> t2s = new HashMap<Character, Character>();
        // int len = s.length();
        // for (int i = 0; i < len; ++i) {
        //     char x = s.charAt(i), y = t.charAt(i);
        //     if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)) {
        //         return false;
        //     }
        //     s2t.put(x, y);
        //     t2s.put(y, x);
        // }
        // return true;
    }
}
