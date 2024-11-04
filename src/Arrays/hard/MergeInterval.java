package Arrays.hard;

import java.util.*;

public class MergeInterval {

    public static List< List< Integer > > mergeOverlappingIntervals(int [][]arr){
        // Write your code here.
        List<List<Integer>> ans = new ArrayList<>();

        //sort intervals
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        //Operations from here.

        int j = 0;
        for (int[] nums : arr) {

            if (ans.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[0]);
                list.add(nums[1]);
                ans.add(j, list);
            } else {
                if (nums[0] <= ans.get(j).get(1)) {
                    ans.get(j).set(1, Math.max(nums[1], ans.get(j).get(1)));
                } else {
                    j += 1;
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[0]);
                    list.add(nums[1]);
                    ans.add(j, list);
                }
            }
        }
        return ans;
    }
    
    public static int[][] merge(int[][] intervals) {

        List<List<Integer>> ans = new ArrayList<>();
        //sorting the intervals
        Arrays.sort(intervals , new Comparator<int[]>(){
            public int compare(int[] a , int[] b){
                return a[0] - b[0];
            }
        });

        int j = 0;
        for(int[] arr : intervals){
            if(ans.isEmpty()){
                List<Integer> list = new ArrayList<>();
                list.add(arr[0]);
                list.add(arr[1]);
                ans.add(list);
            }
            else{
                if(arr[0] <= ans.get(j).get(1)){
                    ans.get(j).set(1,Math.max(arr[1] , ans.get(j).get(1)));
                }
                else{
                    j += 1;
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[0]);
                    list.add(arr[1]);
                    ans.add(list);
                }
            }
        }

        int[][] result = new int[ans.size()][2];
        for(int i = 0; i< ans.size(); i++){
            result[i][0] = ans.get(i).get(0);
            result[i][1] = ans.get(i).get(1);
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 4}, {3, 5}, {6, 7}};
        int[][] arr1 = {{1, 2}, {1, 3}, {1, 6}, {3, 4}, {4, 4}, {4, 5}, {5, 5}, {6, 6}, {6, 6}};
        int[][] arr2 = {{1, 4},
                {3, 3},
                {3, 3},
                {3, 3},
                {3, 4},
                {4, 4},
                {5, 5},
                {5, 5},
                {5, 6}};
        System.out.println((mergeOverlappingIntervals(arr)));
        System.out.println((mergeOverlappingIntervals(arr1)));
        System.out.println((mergeOverlappingIntervals(arr2)));
        System.out.println();
        System.out.println("mergerhere");
        int[][] ans = merge(arr);
        int[][] ans1 = merge(arr1);
        int[][] ans2 = merge(arr2);
        printArray(ans);
        printArray(ans1);
        printArray(ans2);
    }

    private static void printArray(int[][] arr) {
        for(int[] a: arr){
            System.out.println(Arrays.toString(a));
        }
        System.out.println();
        
    }
}
