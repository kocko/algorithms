package codeforces.contests201_300.problemset244;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DividingOrange implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(new ArrayList<>());
        }
        boolean[] used = new boolean[n * k + 1];
        for (int i = 0; i < k; i++) {
            int next = in.ni();
            result.get(i).add(next);
            used[next] = true;
        }
        int idx = 0;
        for (int i = 1; i <= n * k; i++) {
            if (!used[i]) {
                result.get(idx % k).add(i);
                idx++;
            }
        }
        for (List<Integer> list : result) {
            for (int i : list) {
                out.print(i);
                out.print(' ');
            }
            out.println();
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
        try (DividingOrange instance = new DividingOrange()) {
            instance.solve();
        }
    }
}
