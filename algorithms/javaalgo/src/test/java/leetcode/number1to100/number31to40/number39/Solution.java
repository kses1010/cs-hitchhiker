package leetcode.number1to100.number31to40.number39;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private int length;
    private List<List<Integer>> answers = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        length = candidates.length;
        dfs(new ArrayList<>(), 0, target, candidates);

        return answers;
    }

    private void dfs(List<Integer> combi, int s, int rest, int[] candidates) {
        if (rest < 0) {
            return;
        }
        if (rest == 0) {
            answers.add(new ArrayList<>(combi));
            return;
        }
        for (int i = s; i < length; i++) {
            combi.add(candidates[i]);
            dfs(combi, i, rest - candidates[i], candidates);
            combi.remove(combi.size() - 1);
        }
    }
}
