package codeforces.contests901_1000.problemset978;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Mentors implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        List<Mentor> list = new ArrayList<>();
        int[] rates = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            rates[i] = in.ni();
            list.add(new Mentor(i, rates[i]));
        }
        list.sort(Comparator.reverseOrder());
        int[] result = new int[n + 1];

        for (int i = n - 2; i >= 0; i--) {
            Mentor current = list.get(i), next = list.get(i + 1);
            if (current.rate > next.rate) {
                result[current.idx] = n - i - 1;
            } else if (current.rate == next.rate) {
                result[current.idx] = result[next.idx];
            }
        }

        while (k-- > 0) {
            int u = in.ni(), v = in.ni();
            if (rates[u] < rates[v]) {
                result[v]--;
            } else if (rates[u] > rates[v]) {
                result[u]--;
            }
        }

        for (int i = 1; i <= n; i++) {
            out.print(result[i]);
            out.print(' ');
        }
    }

    private class Mentor implements Comparable<Mentor> {
        private int idx, rate;

        private Mentor(int idx, int rate) {
            this.idx = idx;
            this.rate = rate;
        }

        @Override
        public int compareTo(Mentor o) {
            return Integer.compare(rate, o.rate);
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
        try (Mentors instance = new Mentors()) {
            instance.solve();
        }
    }
}
