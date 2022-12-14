package 每日一题;

import java.util.HashSet;
import java.util.Set;

public class _1832判断句子是否为全字母句 {
	public static void main(String[] args) {
		System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
	}

	public static boolean checkIfPangram(String sentence) {
		int len = sentence.length();
		if (len < 26)
			return false;
		int[] chars = new int[26];
		for (int i = 0; i < len; i++) {
			chars[sentence.charAt(i) - 97] = 1;
		}
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != 1) {
				return false;
			}
		}
		return true;
	}

	public static boolean process2(String sentence) {
		int len = sentence.length();
		if (len < 26) {
			return false;
		}
		int state = 0;
		for (int i = 0; i < len; i++) {
			// 对 进行 右移
			state |= 1 << (sentence.charAt(i) - 'a');
		}
		return state == (1 << 26) - 1;
	}
}
