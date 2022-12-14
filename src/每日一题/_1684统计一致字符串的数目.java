package 每日一题;

import java.util.HashSet;
import java.util.Set;

public class _1684统计一致字符串的数目 {
  public static void main(String[] args) {
    System.out.println(countConsistentStrings("abc", new String[] { "a", "b", "c", "ab", "ac", "bc", "abc" }));
  }

  public static int countConsistentStrings(String allowed, String[] words) {
    char[] str = allowed.toCharArray();
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < str.length; i++) {
      set.add(str[i]);
    }
    int len = words.length;
    int res = 0;
    int wordLength = 0;
    ONE: for (int i = 0; i < len; i++) {
      wordLength = words[i].length();
      for (int j = 0; j < wordLength; j++) {
        if (!set.contains(words[i].charAt(j))) {
          continue ONE;
        }
      }
      res++;
    }
    return res;
  }
}
