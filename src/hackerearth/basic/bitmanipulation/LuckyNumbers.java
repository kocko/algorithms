package hackerearth.basic.bitmanipulation;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class LuckyNumbers implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        final int MOD = (int) 1e9 + 7;
        preprocess();
        while (t-- > 0) {
            long n = in.nl(), sum = 0L;
            for (Long x : storage) {
                if (x <= n) {
                    sum = (sum + x) % MOD;
                }
            }
            out.println(sum);
        }
    }
    
    private Set<Long> storage = new HashSet<>();
    
    private void preprocess() {
        int[] bits = new int[60];
        for (int i = 0; i < 59; i++) {
            bits[i] = 1;
            for (int j = i + 1; j < 60; j++) {
                bits[j] = 1;
                storage.add(toDecimal(bits));
                bits[j] = 0;
            }
            bits[i] = 0;
        }
    }
    
    private long toDecimal(int[] bits) {
        String s = "";
        for (int i : bits) {
            s += i;
        }
        return Long.parseLong(s, 2);
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
        try (LuckyNumbers instance = new LuckyNumbers()) {
            instance.solve();
        }
    }
}
