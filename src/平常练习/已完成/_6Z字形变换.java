package 平常练习.已完成;

public class _6Z字形变换 {
    public static void main(String[] args) {
        String s = convert("", 1);
        System.out.println(s);
    }

    public static String convert(String s, int numRows) {
        //如果间隔为一那么就不用进行，跟原字符串一样
        if (numRows == 1) {
            return s;
        }
        StringBuilder str = new StringBuilder();
        int index = 0;
        //第一行和最后一行的间隔
        int StartEndJiange = numRows * 2 - 3;
        //第一行的拼接
        while (index < s.length()) {
            str.append(s.charAt(index));
            index = index + StartEndJiange + 1;
        }

        //中间行的两个间隔
        int midJiange1 = StartEndJiange - 2;
        int midJiange2 = 1;

        //中间的拼接
        for (int i = 1; i < numRows - 1; i++) {
            index = i;
            int jiOu = 1;
            while (index < s.length()) {
                //规律可由画图得
                str.append(s.charAt(index));
                if (jiOu % 2 == 1) {
                    index = index + midJiange1 + 1;
                } else {
                    index = index + midJiange2 + 1;
                }
                jiOu+=1;
            }
            midJiange1 -= 2;
            midJiange2 += 2;
        }

        //最后一行的拼接
        index = numRows - 1;
        while (index < s.length()) {
            str.append(s.charAt(index));
            index = index + StartEndJiange + 1;
        }
        return str.toString();
    }
}
