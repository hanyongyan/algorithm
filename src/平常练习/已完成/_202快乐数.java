package 平常练习.已完成;

import java.util.HashSet;
import java.util.Set;

public class _202快乐数 {
    public static void main(String[] args) {

    }

    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = withIsHappy(n);
        }
        return n == 1;
    }

    private int withIsHappy(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }
}
