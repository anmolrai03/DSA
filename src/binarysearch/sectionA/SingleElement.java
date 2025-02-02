package binarysearch.sectionA;

public class SingleElement {
    public static int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[nums.length-1] != nums[nums.length-2]) return nums[nums.length-1];

        int s = 1;
        int e = nums.length-2;
        while(s<=e){
            int m = s+ (e-s)/2;
            if(nums[m] != nums[m+1] && nums[m] != nums[m-1]) return nums[m];
            if(m % 2 == 0 && nums[m-1] == nums[m] ){
                e = m-1;
            } else if(m%2 != 0 && nums[m+1] == nums[m]){
                e = m - 1;
            } else{
                s = m+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3,4,4,8,8};
        int[] arr1 = {3,3,7,7,10,11,11};
        System.out.println(singleNonDuplicate(arr));
        System.out.println(singleNonDuplicate(arr1));
    }
}
