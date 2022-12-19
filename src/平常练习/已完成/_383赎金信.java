package 平常练习.已完成;

public class _383赎金信 {
  public static void main(String[] args) {
    System.out.println(canConstruct("aa", "aab"));
  }

  public static boolean canConstruct(String ransomNote, String magazine) {
    int len1 = ransomNote.length();
    int len2 = magazine.length();
    int[] arr = new int[26];
    for (int i = 0; i < len1; i++) {
      arr[ransomNote.charAt(i) - 'a']++;
    }
    for (int i = 0; i < len2; i++) {
      arr[magazine.charAt(i) - 'a']--;
    }
    for (int i = 0; i < 26; i++) {
      if (arr[i] > 0) {
        return false;
      }
    }
    return true;
  }
}
