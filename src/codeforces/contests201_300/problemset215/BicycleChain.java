package codeforces.contests201_300.problemset215;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class BicycleChain implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.ni();
        int m = in.ni();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) b[i] = in.ni();
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (b[j] % a[i] == 0) {
                    list.add(b[j] / a[i]);
                }
            }
        }
        Collections.sort(list, Comparator.reverseOrder());
        int result = 1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == list.get(0)) result++;
            else break;
        }
        out.println(result);
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
        try (BicycleChain instance = new BicycleChain()) {
            instance.solve();
        }
    }
}
