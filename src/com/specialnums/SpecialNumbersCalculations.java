package com.specialnums;

public class SpecialNumbersCalculations {
    public int factorial(int n) {
        int a = 1;
        for (int i = 1; i < n + 1; i++)
            a *= i;
        return a;
    }

    public int binomialTheorem(int n, int k) {
        return factorial(n) / (factorial(n - k) * factorial(k));
    }

    public int stirlingFirstKind(int n, int k) {
        if (k > n)
            return 0;
        if (k == 1)
            return factorial(n - 1);
        if (k == n)
            return 1;
        if (k == 0)
            return 0;
        if (k == n - 1)
            return binomialTheorem(n, 2);
        return (n - 1) * stirlingFirstKind(n - 1, k) + stirlingFirstKind(n - 1, k - 1);
    }

    public int stirlingSecondKind(int n, int k) {
        if (k > n || k == 0)
            return 0;
        if (n == k)
            return 1;
        return stirlingSecondKind(n - 1, k - 1) + k * stirlingSecondKind(n - 1, k);
    }

    public int bell(int n) {
        int b = 0;
        for (int i = 0; i < n + 1; i++)
            b += stirlingSecondKind(n, i);
        return b;
    }

    public int eulerFirstKind(int n, int k) {
        if (k == 0 && n == 0)
            return 1;
        if (k >= n)
            return 0;
        if (k == 0 || k == n - 1)
            return 1;
        return (k + 1) * eulerFirstKind(n - 1, k) + (n - k) * eulerFirstKind(n - 1, k - 1);
    }

    public int eulerSecondKind(int n, int k) {
        if (k >= n)
            return 0;
        if (k == 0)
            return 0;
        return (k + 1) * eulerSecondKind(n - 1, k) + (2 * n - 1 - k) * eulerSecondKind(n - 1, k - 1);
    }

    public double harmonic(int n) {
        double a = 0;
        for (int i = 1;i < n + 1; i++)
            a += 1 / (double)i;
        return a;
    }

    public int mersenne(int n) {
        return 2^n - 1;
    }

    public int fibonacci(int n) {
        if (n < 2)
            return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public int lucas(int n) {
        if (n == 0)
            return 2;
        if (n == 1)
            return 1;
        return lucas(n - 1) + lucas(n - 2);
    }
}
