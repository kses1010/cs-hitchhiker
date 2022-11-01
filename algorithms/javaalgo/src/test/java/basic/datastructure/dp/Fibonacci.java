package basic.datastructure.dp;

public class Fibonacci {

    private int[] fibo;

    public Fibonacci(int n) {
        this.fibo = new int[n + 1];
    }

    public int getFiboNumber(int n) {
        if (fibo[n] > 0) {
            return fibo[n];
        }
        if (n == 1 || n == 2) {
            return fibo[n] = 1;
        }
        return fibo[n] = getFiboNumber(n - 2) + getFiboNumber(n - 1);
    }

    public int getFiboNumberIter(int n) {
        fibo[0] = 1;
        fibo[1] = 1;

        for (int i = 2; i < n; i++) {
            fibo[i] = fibo[i - 2] + fibo[i - 1];
        }

        return fibo[n - 1];
    }
}
