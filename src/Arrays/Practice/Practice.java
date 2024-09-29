package Arrays.Practice;

import java.util.ArrayList;

public class Practice {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(list);
        int temp = list.get(0);
        list.set(0 , list.get(1));
        list.set(1, temp);
        
    }
}
