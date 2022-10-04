package 每日一题;

public class _921使括号有效的最少添加 {
    public static void main(String[] args) {

    }

    public static int minAddToMakeValid(String s) {
        int len = s.length();
        int leftCount = 0;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            // 如果当前是 左括号
            if (s.charAt(i) == '(') {
                // 对左括号进行计数
                leftCount++;
            } 
            // 如果当前是 右括号
            else {
                // 如果左括号还有的情况 左右括号匹配成功，减去一个左括号
                if (leftCount != 0) {
                    leftCount--;
                }
                // 如果左括号没有了 说明这是多了一个右括号 对这个右括号进行计数，即需要在当前位置需要添加的左括号个数
                else{
                    ans++;
                }
            }
        }
        // 为什么会返回两者之和呢？ ans 是当 leftCount 为 0 时前面需要添加的左括号，如果遍历结束 leftCount 不为 0 ，后面仍需添加左括号
        return ans+leftCount;
    }
}
