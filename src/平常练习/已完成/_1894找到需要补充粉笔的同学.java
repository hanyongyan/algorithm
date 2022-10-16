package 平常练习.已完成;

public class _1894找到需要补充粉笔的同学 {
    public static void main(String[] args) {
        System.out.println(chalkReplacer(new int[] { 3, 4, 1, 2 }, 25));
    }

    public static int chalkReplacer(int[] chalk, int k) {
        int res = -1, len = chalk.length;
        long  sum = 0;
        for (int i = 0; i < len; i++) {
            sum += chalk[i];
        }
        long surplus = k % sum;
        for (int i = 0; i < len; ++i) {
            if(chalk[i]>surplus){
                res = i;
                break;
            }
            surplus-=chalk[i];
        }
        return res;
    }
}
