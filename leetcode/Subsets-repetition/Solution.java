import java.util.ArrayList;
import java.util.List;

class Solution {
    private static void solve(List<List<Integer>> out,int[] nums, ArrayList<Integer> temp,int start){
        out.add(new ArrayList<>(temp));
        for(int index = start; index< nums.length; index++){
            if(index > start && nums[index] == nums[index-1]) continue; 
            temp.add(nums[index]);
            solve(out, nums, temp, index+1);
            temp.remove(temp.size() -1);
        }
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        solve(out, nums, new ArrayList<Integer>(), 0);
        return out;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
        List<List<Integer>> subsetsList = subsets(nums);
        for(List<Integer> subset : subsetsList){
            for (Integer element : subset) {
                System.out.print(element + " ");
            }
            System.out.println("\n");
        }
    }
}