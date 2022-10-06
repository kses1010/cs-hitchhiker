package leetcode.number1to100.number71to80.number77;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<List<Integer>> answers = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(new ArrayList<>(), 0, n, k, 1);
        return answers;
    }

    private void dfs(List<Integer> combi, int L, int n, int k, int s) {
        if (L == k) {
            answers.add(new ArrayList<>(combi));
        } else {
            for (int i = s; i <= n; i++) {
                combi.add(i);
                dfs(combi, L + 1, n, k, i + 1);
                combi.remove(combi.size() - 1);
            }
        }
    }
}
