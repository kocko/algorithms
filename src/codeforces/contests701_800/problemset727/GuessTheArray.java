package codeforces.contests701_800.problemset727;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GuessTheArray implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] result = new int[n + 1];
        int k = n / 3;
        int rem = n % 3;
        int left;
        for (int i = 0; i < k; i++) {
            left = 3 * i + 1;
            ask(left, left + 1);
            int x = in.ni();
            ask(left + 1, left + 2);
            int y = in.ni();
            ask(left, left + 2);
            int z = in.ni();
            result[left] = (x - y + z) / 2;
            result[left + 1] = (x + y - z) / 2;
            result[left + 2] = (-x + y + z) / 2;
        }
        if (rem > 0) {
            left = n - rem + 1;
            for (int i = left; i <= n; i++) {
                ask(left - 1, i);
                int x = in.ni();
                result[i] = x - result[left - 1];
            }
        }
        print(result);
    }
    
    private void ask(int left, int right) {
        out.println("? " + left + " " + right);
        out.flush();
    }
    
    private void print(int[] result) {
        out.print("! ");
        for (int i = 1; i < result.length; i++) {
            out.print(result[i]);
            if (i < result.length - 1) {
                out.print(" ");
            }
        }
        out.println();
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
        try (GuessTheArray instance = new GuessTheArray()) {
            instance.solve();
        }
    }
}
