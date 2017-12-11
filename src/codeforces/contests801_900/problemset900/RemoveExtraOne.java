package codeforces.contests801_900.problemset900;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class RemoveExtraOne implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] p = new int[n + 1];
        int first = 0, second = 0;
        int[] count = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = in.ni();
            if (p[i] > first) {
                second = first;
                first = p[i];
                count[p[i]]--;
            } else if (p[i] > second) {
                count[first]++;
                second = p[i];
            }
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            if (count[i] > count[result]) {
                result = i;
            }
        }
        out.println(result);
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
        try (RemoveExtraOne instance = new RemoveExtraOne()) {
            instance.solve();
        }
    }
}
