package codeforces.contests401_500.problemset431;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ShowerLine implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int[][] x = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                x[i][j] = in.ni();
            }
        }
        int[] perm = new int[]{0, 1, 2, 3, 4};
        int max = 0;
        do {
            int score = calculate(perm, x);
            max = Math.max(max, score);
        } while (nextPermutation(perm));
        out.println(max);
    }

    private int calculate(int[] order, int[][] g) {
        int result = 0;
        result += g[order[0]][order[1]] + g[order[1]][order[0]] + g[order[2]][order[3]] + g[order[3]][order[2]];
        result += g[order[1]][order[2]] + g[order[2]][order[1]] + g[order[3]][order[4]] + g[order[4]][order[3]];
        result += g[order[2]][order[3]] + g[order[3]][order[2]] + g[order[3]][order[4]] + g[order[4]][order[3]];
        return result;
    }

    private boolean nextPermutation(int[] input) {
        int n = input.length;
        int p = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (input[i] < input[i + 1]) {
                p = i;
                break;
            }
        }
        if (p == -1) return false;

        int q = 0;
        for (int i = n - 1; i > p; i--) {
            if (input[i] > input[p]) {
                q = i;
                break;
            }
        }
        int temp = input[p];
        input[p] = input[q];
        input[q] = temp;
        if (p < n - 1) {
            int left = p + 1, right = n - 1;
            while (left < right) {
                temp = input[left];
                input[left] = input[right];
                input[right] = temp;
                left++; right--;
            }
        }
        return true;
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int ni() {
            return Integer.parseInt(next());
        }

        public long nl() {
            return Long.parseLong(next());
        }

        public void close() throws IOException {
            reader.close();
        }
    }

    public static void main(String[] args) throws IOException {
        try (ShowerLine instance = new ShowerLine()) {
            instance.solve();
        }
    }
}
