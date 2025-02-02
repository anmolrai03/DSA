package binarysearch.sectionA;

public class RotatedSearch2 {
    public static boolean search(int[] nums, int target) {
        int len = nums.length;
        int s = 0;
        int e = nums.length - 1;
        while( s<= e){
            int m = s + (e-s)/2;
            if(nums[m] == target) return true;

            if(s != m && e != m && nums[s] == nums[m] && nums[m] == nums[e]){
                s++;
                e--;
                // continue;
            }
            if(nums[s] <= nums[m]){
                if(target >= nums[s] && target <= nums[m]){
                    e = m-1;
                } else{
                    s = m+1;
                }
            } else{
                if(target>= nums[m] && target <= nums[e]){
                    s = m +1;
                } else{
                    e = m-1;
                }
            }
            
        }
        return false;
    }
    public static void main(String[] args) {
        // int[] arr = {2,5,6,0,1,2};
        int[] arr1 = {1,0 , 1,1 ,1};
        int[] arr2 = {21, 26, 30 ,30 ,32 ,33, 35 ,36, 40, 43 ,47, 49 ,4, 5 ,19 };
        // 15 50
// 21 26 30 30 32 33 35 36 40 43 47 49 4 5 19 

        // int target = 0;
        // System.out.println(search(arr, target));
        // System.out.println(search(arr1, target));
        System.out.println(search(arr2, 50));
    }
}
