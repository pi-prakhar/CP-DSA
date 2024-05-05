public class Solution {
    public static int searchMin(int[] nums){
        int l = 0;
        int h = nums.length-1;
        int mid = 0;
        int target = nums[l];
        int index = l;

        while(l<=h){

            mid = (l+h)/2;
            if(nums[mid] >= target){
                l = mid+1;
            }
            else{
                target = nums[mid];
                index =  mid;
                h = mid -1; 
            }
        }

        return index;
    }

    public static int resolve(int num , int k, int length){
        return (num+k)%(length);
    }
    


    public static int search(int[] nums, int target, int k) {
        int length = nums.length;
        int l = 0;
        int h = length-1;
        int mid = resolve(0, k, length);

        while(l<=h){

            mid = (l+h)/2;
            if(nums[resolve(mid,k,length)] ==  target){
                return resolve(mid,k,length);
            }
            if(nums[resolve(mid, k, length)] > target){
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return -1;   
    }


    public static void main(String[] args) {
        // int[] nums = new int[] {0,1,2,4,5,6,7};
        // int[] nums = new int[] {1,2,4,5,6,7,0};
        // int[] nums = new int[] {2,4,5,6,7,0,1};
        // int[] nums = new int[] {4,5,6,7,0,1,2};
        // int[] nums = new int[] {5,6,7,0,1,2,4};
        int[] nums = new int[] {6,7,0,1,2,4,5};
        //int[] nums = new int[] {3,1};
        int k = searchMin(nums);
        System.out.println(k);
        int target = 1;
        System.out.println(search(nums, target, k));
    }
}