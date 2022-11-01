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
}
