package 平常练习.已完成;

import java.util.ArrayList;
import java.util.List;

public class _22括号生成 {
    public static void main(String[] args) {

    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        process(list, n, n, "");
        return list;
    }

    /**
     *
     * @param list      最后的返回结果
     * @param n         左括号的剩余个数
     * @param m         右括号的剩余个数
     */
    public static void process(List<String> list,int left,int right,String str){
        if (left == 0 && right == 0) {
            list.add(str.toString());
            return;
        }
        //相等的情况下，只能添加左括号
        if(left==right){
            process(list, left-1, right, str+"(");
        }
        else if(left<right){
            //剩余左括号小于右括号，下一个可以用左括号也可以用右括号
            if(left>0){
                process(list, left-1, right, str+"(");
            }
            process(list, left, right-1, str+")");
        }
        
    }
}
