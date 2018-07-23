package codeforces.contests1001_1100.problemset1006;

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

public class PolycarpsPractice implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        List<Task> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(new Task(i, in.ni()));
        }
        list.sort(Comparator.comparingInt(x -> -x.complexity));
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans += list.get(i).complexity;
            list.get(i).max = true;
        }
        out.println(ans);
        list.sort(Comparator.comparingInt(x -> x.idx));
        int day = 0;
        for (int i = 0; i < n; i++) {
            if (list.get(i).max) {
                if (k > 1) {
                    out.print(day + 1);
                    out.print(' ');
                    k--;
                    day = 0;
                    continue;
                }
            }
            day++;
        }
        out.print(day);
    }

    private class Task {
        private int idx, complexity;
        private boolean max;

        private Task(int idx, int complexity) {
            this.idx = idx;
            this.complexity = complexity;
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
        try (PolycarpsPractice instance = new PolycarpsPractice()) {
            instance.solve();
        }
    }
}
