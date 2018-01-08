package codeforces.contests901_1000.problemset913;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ChristmasSpruce implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        List<List<Integer>> children = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            children.add(new ArrayList<>());
        }
        boolean[] hasChildren = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            int parent = in.ni();
            children.get(parent).add(i);
            hasChildren[parent] = true;
        }
        boolean result = true;
        for (int i = 1; i <= n; i++) {
            if (hasChildren[i]) {
                int count = 0;
                List<Integer> next = children.get(i);
                for (int c : next) if (!hasChildren[c]) count++;
                result &= count >= 3;
            }
        }
        out.println(result ? "Yes" : "No");
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
        try (ChristmasSpruce instance = new ChristmasSpruce()) {
            instance.solve();
        }
    }
}
