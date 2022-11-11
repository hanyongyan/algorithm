package 每日一题;

import java.util.HashSet;
import java.util.Set;

public class _1704判断字符串的两半是否相似 {
  public static void main(String[] args) {
    System.out.println(halvesAreAlike("book"));
  }

  public static boolean halvesAreAlike(String s) {
    int len = s.length();
    if (len % 2 == 1) {
      return false;
    }
    Set<Character> set = getSet();
    int sum1 = 0;
    int sum2 = 0;
    for (int i = 0; i < len / 2; i++) {
      if (set.contains(s.charAt(i))) {
        sum1++;
      }
      if (set.contains(s.charAt(i + len / 2))) {
        sum2++;
      }
    }
    return sum1 == sum2;
  }

  public static Set<Character> getSet() {
    Set<Character> set = new HashSet<>();
    set.add('a');
    set.add('e');
    set.add('i');
    set.add('o');
    set.add('u');
    set.add('A');
    set.add('E');
    set.add('I');
    set.add('O');
    set.add('U');
    return set;
  }
}
