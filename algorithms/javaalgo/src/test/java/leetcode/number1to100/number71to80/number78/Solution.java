package leetcode.number1to100.number71to80.number78;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private int length;
    private List<List<Integer>> answers = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        length = nums.length;
        dfs(new ArrayList<>(), 0, nums);

        return answers;
    }

    private void dfs(List<Integer> subset, int s, int[] nums) {
        answers.add(new ArrayList<>(subset));

        for (int i = s; i < length; i++) {
            subset.add(nums[i]);
            dfs(subset, i + 1, nums);
            subset.remove(subset.size() - 1);
        }
    }
}
