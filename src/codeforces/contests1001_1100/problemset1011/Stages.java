package codeforces.contests1001_1100.problemset1011;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Math.*;

public class Stages implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        k = in.ni();
        char[] x = in.next().toCharArray();
        for (int i = 0; i < n; i++) {
            has[x[i] - 'a'] = true;
        }
        recurse(0, -2, 0);
        out.println(result == MAX_VALUE ? -1 : result);
    }
    
    private int k;
    private int result = MAX_VALUE;
    private boolean[] has = new boolean[26];
    
    private void recurse(int idx, int last, int weight) {
        if (idx == k) {
            result = min(result, weight);
        } else {
            if (last >= 25) return;
            for (int i = last + 2; i < 26; i++) {
                if (has[i]) recurse(idx + 1, i, weight + i + 1);
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
        try (Stages instance = new Stages()) {
            instance.solve();
        }
    }
}
