package codeforces.contests801_900.problemset876;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DivisiblityOfDifferences implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni(), m = in.ni();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int next = in.ni();
            list.get(next % m).add(next);
        }
        for (List<Integer> l : list) {
            if (l.size() >= k) {
                out.println("Yes");
                for (int i = 0; i < k; i++) {
                    out.print(l.get(i));
                    out.print(' ');
                }
                return;
            }
        }
        out.println("No");
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
        try (DivisiblityOfDifferences instance = new DivisiblityOfDifferences()) {
            instance.solve();
        }
    }
}
