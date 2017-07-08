package codeforces.contests201_300.problemset218;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Airport implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        int[] a = new int[m], b = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = b[i] = in.ni();
        }
        int max = 0, min = 0;
        for (int i = 0; i < n; i++) {
            int price = 0, plane = -1;
            for (int j = 0; j < m; j++) {
                if (a[j] > price) {
                    price = a[j];
                    plane = j;
                }
            }
            a[plane]--;
            max += price;
        }
        for (int i = 0; i < n; i++) {
            int price = 1005, plane = -1;
            for (int j = 0; j < m; j++) {
                if (b[j] > 0 && b[j] < price) {
                    price = b[j];
                    plane = j;
                }
            }
            b[plane]--;
            min += price;
        }
        out.println(max + " " + min);
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
        try (Airport instance = new Airport()) {
            instance.solve();
        }
    }
}
