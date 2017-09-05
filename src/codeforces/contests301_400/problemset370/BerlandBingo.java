package codeforces.contests301_400.problemset370;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BerlandBingo implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> card = new ArrayList<>();
            int m = in.ni();
            for (int j = 0; j < m; j++) {
                card.add(in.ni());
            }
            list.add(card);
        }
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            List<Integer> a = list.get(i);
            boolean wins = true;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    List<Integer> b = list.get(j);
                    wins &= !a.containsAll(b);
                }
            }
            result[i] = wins ? "YES" : "NO";
        }
        for (String x : result) {
            out.println(x);
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
        try (BerlandBingo instance = new BerlandBingo()) {
            instance.solve();
        }
    }
}
