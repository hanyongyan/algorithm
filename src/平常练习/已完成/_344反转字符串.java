package 平常练习.已完成;

import java.util.Collection;

public class _344反转字符串 {
    public static void main(String[] args) {
        
    }
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while(left<=right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }
}
