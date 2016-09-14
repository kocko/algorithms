package codeforces.contests701_800.problemset714;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class FilyaAndHomework implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        Set<Integer> list = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            list.add(in.ni());
        }
        if (list.size() > 3) {
            out.println("NO");
        } else if (list.size() == 3) {
            Integer[] x = list.toArray(new Integer[3]);
            boolean ok = x[2] - x[1] == x[1] - x[0];
            out.println(ok ? "YES" : "NO");
        } else {
            out.println("YES");
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
        try (FilyaAndHomework instance = new FilyaAndHomework()) {
            instance.solve();
        }
    }
}
