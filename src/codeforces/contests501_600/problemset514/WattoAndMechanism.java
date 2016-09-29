package codeforces.contests501_600.problemset514;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class WattoAndMechanism implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private final long MOD = (long) 1e16 + 7;
    
    private Set<Long> set = new HashSet<>();
    private long[] powers = new long[600001];

    public void solve() {
        int n = in.ni(), m = in.ni();
        calculatePowers();
        while (n-- > 0) {
            set.add(hash(in.next()));
        }
        while (m-- > 0) {
            String next = in.next();
            long originalHash = hash(next);
            
            if (contained(next, originalHash)) {
                out.println("YES");
            } else {
                out.println("NO");
            }
        }
    }
    
    private void calculatePowers() {
        powers[0] = 1;
        final int PRIME = 31;
        for (int i = 1; i < powers.length; i++) {
            powers[i] = (powers[i - 1] * PRIME) % MOD;
        }
    }
    
    private long hash(String s) {
        long result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += powers[i] * (s.charAt(i) - 'a' + 1) % MOD;    
        }
        return result;
    }
    
    private boolean contained(String s, long hash) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            long temp = hash - (powers[i] * (s.charAt(i) - 'a' + 1)) % MOD;
            for (char c = 'a'; c <= 'c'; c++) {
                if (c != s.charAt(i)) {
                    int x = c - 'a' + 1;
                    long newHash = temp + powers[i] * (x) % MOD;
                    if (set.contains(newHash)) return true;
                }
            }
        }
        return false;
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
        try (WattoAndMechanism instance = new WattoAndMechanism()) {
            instance.solve();
        }
    }
}
