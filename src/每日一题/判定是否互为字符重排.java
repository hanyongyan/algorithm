package 每日一题;

import java.util.Arrays;
import java.util.Collection;

public class 判定是否互为字符重排 {
    public static void main(String[] args) {
System.out.println(CheckPermutation("abc", "bca"));
    }

    public static boolean CheckPermutation(String s1, String s2) {
        int len1= s1.length();
        int len2 = s2.length();
        if(len1!=len2){
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int j = 0;
        Arrays.sort(c1);
        Arrays.sort(c2);
        for (int i = 0; i < c2.length; i++) {
            if(c1[i]!=c2[j]){
                return false;
            }
            j++;
        }
        return true;
    }
}
