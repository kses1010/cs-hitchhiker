package basic.datastructure.recursive;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    private int n;
    private int[] checks;
    private int[] nums;
    private List<List<Integer>> permutations;

    public Permutations(int[] nums) {
        this.n = nums.length;
        this.checks = new int[nums.length];
        this.nums = nums;
        this.permutations = new ArrayList<>();
    }

    public List<List<Integer>> permute() {
        dfs(new ArrayList<>(), 0);
        return permutations;
    }

    public void dfs(List<Integer> perm, int depth) {
        if (depth == n) {
            permutations.add(new ArrayList<>(perm));
        } else {
            for (int i = 0; i < n; i++) {
                if (checks[i] == 0) {
                    checks[i] = 1;
                    perm.add(nums[i]);
                    dfs(perm, depth + 1);
                    checks[i] = 0;
                    perm.remove(perm.size() - 1);
                }
            }
        }
    }
}
