package codeforces.contests600_699.problemset660;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SeatingOnBus implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int n = in.ni(), m = in.ni();
        List<Integer> first = new ArrayList<>(), second = new ArrayList<>(), third = new ArrayList<>(), fourth = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            if (i <= 2 * n) {
                if (i % 2 == 1) {
                    first.add(i);
                } else {
                    second.add(i);
                }
            } else {
                if (i % 2 == 1) {
                    third.add(i);
                } else {
                    fourth.add(i);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (third.size() > i - 1) {
                out.print(third.get(i - 1) + " ");
            }
            if (first.size() > i - 1) {
                out.print(first.get(i - 1) + " ");
            }
            if (fourth.size() > i - 1) {
                out.print(fourth.get(i - 1) + " ");
            }
            if (second.size() > i - 1) {
                out.print(second.get(i - 1) + " ");
            }
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

    public static void main(String[] args) {
        new SeatingOnBus().solve();
    }
}
