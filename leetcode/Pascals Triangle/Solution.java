import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void solve (List<List<Integer>> out, int nums){
        if (nums == 1){
            ArrayList<Integer> dummyList = new ArrayList<Integer>();
            dummyList.add(1);
            out.add(dummyList);
            return;
        }
        solve(out,nums-1);
        ArrayList<Integer> dummyList = new ArrayList<Integer>();
        for (int i = 0; i<nums ; i++ ){
            if (i == 0 || i == nums-1) dummyList.add(1);
            else dummyList.add(out.get(nums-2).get(i-1)+ out.get(nums-2).get(i));
        }
        out.add(dummyList);

    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> out = new ArrayList<>();
        solve(out, numRows);
        return out;
    }

    public static void main(String[] args) {
        generate(4);
    }
};