package codeforces.contests701_800.problemset754;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LeshaAndArraySplitting implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] x = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
            sum += x[i];
        }
        if (sum != 0) {
            out.println("YES");
            out.println(1);
            out.println(1 + " " + n);
        } else {
            int f = -1;
            for (int i = 0; i < n; i++) {
                if (x[i] != 0) {
                    f = i + 1;
                    break;
                }
            }
            if (f != -1) {
                out.println("YES");
                out.println(2);
                out.println(1 + " " + f);
                out.println((f + 1) + " " + n);
            } else {
                out.println("NO");
            }
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
        try (LeshaAndArraySplitting instance = new LeshaAndArraySplitting()) {
            instance.solve();
        }
    }
}
