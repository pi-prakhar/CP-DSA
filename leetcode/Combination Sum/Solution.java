import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public static void addToOut(ArrayList<Integer> temp,List<List<Integer>> out){
        ArrayList<Integer> newTemp = new ArrayList<Integer>(temp);
        Collections.sort(newTemp);
        for(List<Integer> innerList : out){
            if(innerList.equals(newTemp)) return;
        }
        out.add(newTemp);

    }
    public static void solve(int target, int[] candidates, List<List<Integer>> out,ArrayList<Integer>  temp, int[] dp){

        if (target < 0 || dp[target] == -1) return;
        if (target == 0) {
            addToOut(temp, out);
            return;
        }
        int outLen = out.size();
        for (int candidate : candidates) {
            temp.add(candidate);
            solve(target - candidate, candidates, out, temp, dp);
            temp.remove(temp.size()-1);
        }
        if (outLen == out.size() && dp[target] != 1) dp[target] = -1;
        else dp[target] = 1;
        return ;
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> out = new ArrayList<>();
        int[] dp = new int[target+1];
        solve(target, candidates, out, new ArrayList<Integer>(), dp);
        return out;
    }

    public static void main(String[] args) {
        combinationSum(new int[]{2,3,5}, 8);
    }
}