package 平常练习.已完成;

public class _415字符串相加 {
    public static void main(String[] args) {
      String ans =   addStrings("1", "9");
        System.out.println(ans);
    }

    /*
     * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
     */
    public static String addStrings(String num1, String num2) {
        //获取两个字符串的长度
        int len1= num1.length()-1;
        int len2= num2.length()-1;
        //add代表进位
        int add= 0;
        StringBuilder ans = new StringBuilder();
        //先从最后面的字符开始比较
        //add != 0 是防止最后的进位没有添加上去
        while(len1>=0||len2>=0||add!=0){
            int x = len1>=0? num1.charAt(len1)-'0':0;
            int y = len2>=0? num2.charAt(len2)-'0':0;
            //ans添加当前位置的字符和上一位置的字符的进位除以10的余数
            ans.append((x+y+add)%10);
            //将进位保存在add中
            add = (x+y+add)/10;
            //开始下一位置的比较
            len1--;
            len2--;
        }
        //因为是使用append方法添加字符，所以需要将add的值反转
        return ans.reverse().toString();
    }
}
