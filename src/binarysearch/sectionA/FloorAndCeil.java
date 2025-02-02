package binarysearch.sectionA;

import java.util.Arrays;

public class FloorAndCeil {
    public static void main(String[] args) {
        Floor flr = new Floor();
        Ceil cil = new Ceil();
        int[] arr = {3, 4, 4, 7, 8 , 9, 10};
        int target = 5;
        int floor = flr.floor(arr , target);
        int ceil = cil.ceil(arr, target);
        int[] ans = {floor , ceil};
        System.out.println(Arrays.toString(ans));
    }
}
