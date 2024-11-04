package Arrays.codetantra;
import java.util.List;
import java.util.ArrayList;
public class ReverseArray {
    public static List<Integer> reverseArray(List<Integer> arr){
        //Reverse without extra space
        int startIdx = 0;
        int endIdx = arr.size()-1;
        while(startIdx <= endIdx){
            int temp = arr.get(startIdx);
            arr.set(startIdx,arr.get(endIdx));
            arr.set(endIdx,temp);
            startIdx++;
            endIdx--;
        }
        return arr;
    }

    public static void main(String[] args) {
        List<Integer> arr =new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        // System.out.println(arr);
        System.out.println(reverseArray(arr));
    }
}
