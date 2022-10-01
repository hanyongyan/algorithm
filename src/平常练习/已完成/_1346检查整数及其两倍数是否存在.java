package 平常练习.已完成;

import java.util.HashSet;
import java.util.Set;

public class _1346检查整数及其两倍数是否存在 {
    public static void main(String[] args) {

    }

    public static boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (Integer i : arr) {
            // 查看 set 集合中是否含有当前数的两倍 或者 1/2
            if (set.contains(i * 2) || (i % 2 == 0 && set.contains(i / 2))) {
                return true;    
            }
            set.add(i);
        }
        return false;
    }
}
