package Arrays.Practice;

import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        set.add("Apple"); // duplicate element, will be ignored

        System.out.println("Set: " + set);

        set.remove("Banana");

        System.out.println("Set after removal: " + set);

        System.out.println("Is set empty? " + set.isEmpty());

        System.out.println("Size of set: " + set.size());
    }
}
