package codeforces.contests801_900.problemset822;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CrosswordSolving implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        char[] s = in.next().toCharArray(), t = in.next().toCharArray();
        int min = (int) 1e9;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= m - n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (s[j] != t[i + j]) {
                    list.add(j + 1);
                }
            }
            if (list.size() > 0 && list.size() < min) {
                min = list.size();
                result = list;
            } else if (list.size() == 0) {
                out.println(0);
                return;
            }
        }
        out.println(min);
        for (int i = 0; i < min; i++) {
            out.print(result.get(i));
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
        try (CrosswordSolving instance = new CrosswordSolving()) {
            instance.solve();
        }
    }
}
