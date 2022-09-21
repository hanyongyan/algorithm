import java.util.*;
import java.util.stream.Collectors;

import org.junit.Test;

public class test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(4);
        list.add(2);
        list.add(1);
        Collections.sort(list,(a,b)->{
            return b-a;
        });
        for (Integer integer : list) {
            System.out.println(integer);
        }

    }

    @Test
    public void test() {

    }
}
