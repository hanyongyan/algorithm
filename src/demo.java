import java.util.*;

public class demo {
    public static void main(String[] args) {
        List<Integer> list =new ArrayList<>();
        
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
