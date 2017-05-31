package codeforces.contests501_600.problemset583;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class GcdTable implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        TreeMap<Integer, Integer> x = new TreeMap<>((a, b) -> b - a);
        for (int i = 0; i < n * n; i++) {
            int next = in.ni();
            x.put(next, x.getOrDefault(next, 0) + 1);
        }
        int[] result = new int[n];
        int idx = 0;
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(x.keySet());
        for (int value : numbers) {
            while (x.get(value) > 0) {
                result[idx] = value;
                x.put(value, x.get(value) - 1);
                for (int j = 0; j < idx; j++) {
                    int gcd = gcd(value, result[j]);
                    x.put(gcd, x.get(gcd) - 2);
                }
                idx++;
            }
        }

        for (int i = 0; i < n; i++) {
            out.print(result[i]);
            out.print(' ');
        }
    }

    private int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
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
        try (GcdTable instance = new GcdTable()) {
            instance.solve();
        }
    }
}
