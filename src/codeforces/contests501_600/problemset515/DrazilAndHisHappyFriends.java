package codeforces.contests501_600.problemset515;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DrazilAndHisHappyFriends implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        int b = in.ni();
        boolean[] boys = new boolean[n];
        for (int i = 0; i < b; i++) boys[in.ni()] = true;
        int g = in.ni();
        boolean[] girls = new boolean[m];
        for (int i = 0; i < g; i++) girls[in.ni()] = true;
        int max = m * n;
        for (int i = 0; i < 2 * max; i++) {
            int boy = i % n, girl= i % m;
            boys[boy] = girls[girl] = boys[boy] || girls[girl];
        }
        boolean happy = true;
        for (int i = 0; i < n; i++) happy &= boys[i];
        for (int i = 0; i < m; i++) happy &= girls[i];
        out.println(happy ? "Yes" : "No");
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
        try (DrazilAndHisHappyFriends instance = new DrazilAndHisHappyFriends()) {
            instance.solve();
        }
    }
}
