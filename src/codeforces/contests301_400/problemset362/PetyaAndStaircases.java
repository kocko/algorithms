package codeforces.contests301_400.problemset362;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class PetyaAndStaircases implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(in.ni());
        }
        boolean can = true;
        if (m > 0) {
            Collections.sort(list);
            can = list.get(0) != 1 && list.get(m - 1) != n;
            for (int i = 1; i < m - 1; i++) {
                int prev = list.get(i - 1), current = list.get(i), next = list.get(i + 1);
                if (prev + 1 == current && next - 1 == current) {
                    can = false;
                    break;
                }
            }
        }
        out.println(can ? "YES" : "NO");
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
        try (PetyaAndStaircases instance = new PetyaAndStaircases()) {
            instance.solve();
        }
    }
}
