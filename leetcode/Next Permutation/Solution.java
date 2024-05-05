import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public static void sortNums (int[] nums, int startIndex, int endIndex){  
        Arrays.sort(nums, startIndex, endIndex+1);
    }
    public static void recSort (int[] nums, int startIndex, int endIndex){
        int start = startIndex;
        int end = endIndex;
        while (end > start){
            int index = end-1;
            while(index >= start){
                if (nums[index] < nums[end]) {
                    int temp = nums[index];
                    nums[index] = nums[end];
                    nums[end] = temp;
                    sortNums(nums, index+1 ,endIndex);
                    return;
                }
                index--;
            }
            end--;
        }

    }
    public static void nextPermutation(int[] nums) {
        //return x.toString().compareTo( y.toString() );
        int i,j;
        int length = nums.length;
        boolean found = false;
        for(i=length-1;i>0;i--){
            j = i-1;
            if (nums[j] < nums[i]){
                found =  true;
                recSort(nums,j, length-1);
                return;
            }
        }

        if(!found){
            sortNums(nums, 0, length);
        }
    }

    public static void main(String[] args) {
        int[] nums =  new int[]{2,2,7,5,4,3,2,2,1};
        // int result = Integer.toString(1).compareTo(Integer.toString(5));
        // System.out.println(result);
        nextPermutation(nums);

        for(int i : nums){
            System.out.println(i);
        }
    }
}