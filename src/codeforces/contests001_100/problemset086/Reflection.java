package codeforces.contests001_100.problemset086;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reflection {
    private static long weight(int n) {
        return (long) (Math.pow(10, digits(n)) - 1 - n) * n;
    }

    private static int digits(int n) {
        return (n + "").length();
    }

    private static Long process(int n, int m) {
        long result = 1;
        int range = digits(m);
        int maxWeight = (int) (5 * Math.pow(10, range - 1));
        if (digits(n) < digits(m)) {
            if (maxWeight >= m) {
                result = weight(m);
            } else if (maxWeight < m) {
                result = weight(maxWeight);
            }
        } else {
            if (maxWeight >= n && maxWeight <= m) {
                result = weight(maxWeight);
            } else if (maxWeight < n) {
                result = weight(n);
            } else if (maxWeight > m) {
                result = weight(m);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int n, m;
        try {
            line = reader.readLine();
            n = Integer.parseInt(line.split(" ")[0]);
            m = Integer.parseInt(line.split(" ")[1]);
            System.out.println(process(n, m));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}