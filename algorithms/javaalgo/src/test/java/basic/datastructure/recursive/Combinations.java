package basic.datastructure.recursive;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    private int n;
    private int k;
    private int[] candidates;
    private List<List<Integer>> combinations;

    public Combinations(int n, int k) {
        this.n = n;
        this.k = k;
        this.combinations = new ArrayList<>();
    }

    public Combinations(int[] candidates) {
        this.n = candidates.length;
        this.candidates = candidates;
        this.combinations = new ArrayList<>();
    }

    public List<List<Integer>> combine() {
        combiDfs(new ArrayList<>(), 0, 1);
        return combinations;
    }

    private void combiDfs(List<Integer> combi, int depth, int start) {
        if (depth == k) {
            combinations.add(new ArrayList<>(combi));
        } else {
            for (int i = start; i <= n; i++) {
                combi.add(i);
                combiDfs(combi, depth + 1, i + 1);
                combi.remove(combi.size() - 1);
            }
        }
    }

    public List<List<Integer>> combiSum(int target) {
        combiSumDfs(new ArrayList<>(), target, 0);
        return combinations;
    }

    private void combiSumDfs(List<Integer> combi, int rest, int start) {
        if (rest < 0) {
            return;
        }
        if (rest == 0) {
            combinations.add(new ArrayList<>(combi));
            return;
        }
        for (int i = start; i < n; i++) {
            combi.add(candidates[i]);
            combiSumDfs(combi, rest - candidates[i], i);
            combi.remove(combi.size() - 1);
        }
    }
}
