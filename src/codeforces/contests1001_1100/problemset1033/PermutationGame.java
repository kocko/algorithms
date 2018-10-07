package codeforces.contests1001_1100.problemset1033;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PermutationGame implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        n = in.ni();
        x = new int[n + 1];
        int start = -1;
        for (int i = 1; i <= n; i++) {
            x[i] = in.ni();
            if (x[i] == 1) {
                start = i;
            }
        }
        winning = new Boolean[n + 1];
        recurse(start);
        for (int i = 1; i <= n; i++) {
            out.print(winning[i] ? 'A' : 'B');
        }
    }

    private int n;
    private int[] x;
    private Boolean[] winning;
    
    private boolean recurse(int idx) {
        if (winning[idx] != null) return winning[idx];
        
        Boolean ans = false;
        int value = x[idx], mult = 1;
        while (true) {
            int left = idx - value * mult;  
            int right = idx + value * mult;  
            if (left < 1 && right > n) break;
            if (left >= 1 && x[left] > x[idx]) {
                ans |= !recurse(left);
            }
            if (right <= n && x[right] > x[idx]) {
                ans |= !recurse(right);
            }
            mult++;
        }
        return winning[idx] = ans;
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
        try (PermutationGame instance = new PermutationGame()) {
            instance.solve();
        }
    }
}
