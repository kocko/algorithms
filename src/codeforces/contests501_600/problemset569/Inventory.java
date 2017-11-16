package codeforces.contests501_600.problemset569;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Inventory implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] x = new int[n];
        int[] count = new int[100001];
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
            count[x[i]]++;
        }
        int next = 1;
        for (int i = 0; i < n; i++) {
            int k = x[i];
            if (count[k] >= 2 || k > n) {
                count[k]--;
                while (next <= n && count[next] != 0) {
                    next++;
                }
                count[next]++;
                x[i] = next;
            }
        }
        for (int i : x) {
            out.print(i + " ");
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
        try (Inventory instance = new Inventory()) {
            instance.solve();
        }
    }
}
