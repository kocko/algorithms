package codeforces.contests701_800.problemset736;

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

public class Urbanization implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int n1 = in.ni(), n2 = in.ni();
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.nl());
        }
        Collections.sort(list, Collections.reverseOrder());
        long sum = 0L;
        for (int i = 0; i < n1; i++) {
            sum += list.get(i);
        }
        double d1 = sum / (double) n1;
        sum = 0L;
        for (int i = n1; i < n1 + n2; i++) {
            sum += list.get(i);
        }
        double d2 = sum / (double) n2;
        double a = d1 + d2;

        sum = 0L;
        for (int i = 0; i < n2; i++) {
            sum += list.get(i);
        }
        d1 = sum / (double) n2;
        sum = 0L;
        for (int i = n2; i < n1 + n2; i++) {
            sum += list.get(i);
        }
        d2 = sum / (double) n1;
        double b = d1 + d2;
        out.println(Math.max(a, b));
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
        try (Urbanization instance = new Urbanization()) {
            instance.solve();
        }
    }
}
