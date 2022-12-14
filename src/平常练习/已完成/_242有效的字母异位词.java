package 平常练习.已完成;

import java.time.format.FormatStyle;

public class _242有效的字母异位词 {
    public static void main(String[] args) {

    }

    public static boolean isAnagram(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen != tLen) {
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < tLen; i++) {
            arr[s.charAt(i) - 'a'] += 1;
            arr[t.charAt(i) - 'a'] -= 1;
        }
        for (int i = 0; i < 26; i++) {
            if(arr[i] != 0){
                return false;
            }
        }
        return true;
    }
}
