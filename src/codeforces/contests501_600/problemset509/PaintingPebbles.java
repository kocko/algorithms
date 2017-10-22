package codeforces.contests501_600.problemset509;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PaintingPebbles implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni(), max = 0, min = 101;
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
            max = Math.max(x[i], max);
            min = Math.min(x[i], min);
        }
        if (max - min > k) {
            out.println("NO");
            return;
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) result.add(new ArrayList<>());
        int nextColor = 1;
        for (int i = 0; i < min; i++) {
            for (List<Integer> list : result) {
                list.add(nextColor);
            }
            nextColor++;
            if (nextColor > k) nextColor = 1;
        }
        for (int i = 0; i < n; i++) {
            List<Integer> list = result.get(i);
            if (list.size() < x[i]) {
                nextColor = 1;
                int diff = x[i] - list.size();
                for (int j = 0; j < diff; j++) {
                    list.add(nextColor++);
                    if (nextColor == k + 1) nextColor = 1;
                }
            }
        }
        out.println("YES");
        for (List<Integer> list : result) {
            for (Integer value : list) {
                out.print(value);
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
        try (PaintingPebbles instance = new PaintingPebbles()) {
            instance.solve();
        }
    }
}
