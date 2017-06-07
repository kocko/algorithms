package codeforces.contests801_900.problemset814;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AnExpressTrainToReveries implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] a = new int[n], b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.ni();
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.ni();
        }
        boolean[] used = new boolean[n + 1];
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) {
                result[i] = a[i];
                used[a[i]] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            if (result[i] == 0) {
                if (!used[a[i]]) {
                    result[i] = a[i];
                } else if (!used[b[i]]) {
                    result[i] = b[i];
                } else {
                    for (int j = 1; j <= n; j++) {
                        if (!used[j]) {
                            result[i] = j;
                            used[j] = true;
                            break;
                        }
                    }
                }
                used[result[i]] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            out.print(result[i]);
            out.print(' ');
        }
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
        try (AnExpressTrainToReveries instance = new AnExpressTrainToReveries()) {
            instance.solve();
        }
    }
}
