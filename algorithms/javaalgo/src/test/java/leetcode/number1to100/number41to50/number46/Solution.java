package leetcode.number1to100.number41to50.number46;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private int[] checks;
    private int n;
    private List<List<Integer>> answers = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        checks = new int[n];
        dfs(new ArrayList<>(), 0, nums);

        return answers;
    }


    private void dfs(List<Integer> perm, int L, int[] nums) {
        // 리프까지 도착하면 백트래킹
        if (L == n) {
            answers.add(new ArrayList<>(perm));
        } else {
            for (int i = 0; i < n; i++) {
                if (checks[i] == 0) {
                    checks[i] = 1;
                    perm.add(nums[i]);
                    dfs(perm, L + 1, nums);
                    checks[i] = 0;
                    perm.remove(perm.size() - 1);
                }
            }
        }
    }
}
