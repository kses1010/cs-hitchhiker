package basic.datastructure.recursive;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    private int n;
    private int k;
    private List<List<Integer>> combinations;

    public Combinations(int n, int k) {
        this.n = n;
        this.k = k;
        this.combinations = new ArrayList<>();
    }

    public List<List<Integer>> combine() {
        dfs(new ArrayList<>(), 0, 1);
        return combinations;
    }

    private void dfs(List<Integer> combi, int depth, int start) {
        if (depth == k) {
            combinations.add(new ArrayList<>(combi));
        } else {
            for (int i = start; i <= n; i++) {
                combi.add(i);
                dfs(combi, depth + 1, i + 1);
                combi.remove(combi.size() - 1);
            }
        }
    }
}
