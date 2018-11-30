package codeforces.contests1001_1100.problemset1082;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MaximumDiameterGraph implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), total = 0;
        int[] d = new int[n];
        ArrayDeque<Integer> ones = new ArrayDeque<>();
        List<Integer> others = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            d[i] = in.ni();
            if (d[i] == 1) {
                ones.add(i);
            } else {
                others.add(i);
            }
            total += d[i];
        }
        if (total < 2 * (n - 1)) {
            out.println("NO");
            return;
        }
        int diameter = 0;
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < others.size() - 1; i++) {
            int u = others.get(i), v = others.get(i + 1);
            result.add(new int[]{u + 1, v + 1});
            d[u]--;
            d[v]--;
            diameter++;
        }
        ArrayDeque<Integer> additional = new ArrayDeque<>();
        for (int i = 1; i < others.size() - 1; i++) {
            if (d[others.get(i)] > 0) {
                additional.add(others.get(i));
            }
        }
        for (int v : new int[]{others.get(0), others.get(others.size() - 1)}) {
            if (ones.size() > 0) {
                int u = ones.pollFirst();
                result.add(new int[]{u + 1, v + 1});
                d[u]--;
                d[v]--;
                diameter++;
                if (d[v] > 0) {
                    additional.add(v);
                }
            }
        }
        while (!ones.isEmpty()) {
            int u = ones.pollFirst(), v = additional.pollFirst();
            result.add(new int[]{u + 1, v + 1});
            if (--d[v] > 0) {
                additional.add(v);
            }
        }
        out.println("YES " + diameter);
        out.println(result.size());
        for (int[] edge : result) {
            out.println(edge[0] + " " + edge[1]);
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
        try (MaximumDiameterGraph instance = new MaximumDiameterGraph()) {
            instance.solve();
        }
    }
}
