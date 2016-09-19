package hackerrank.contests.weekofcode23;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UnexpectedProblem implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        String s = in.next();
        int m = in.ni(), n = s.length();
        int[] z = z(s.toCharArray());
        int k = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (z[i] == n - i) {
                k = z[i];
                break;
            }
        }
        if (k == 0) {
            out.println(0);
        } else {
            int r;
            if (n % k != 0) {
                r = m / n;
            } else {
                boolean ok = true;
                for (int i = n - k; i >= 0; i -= k) {
                    if (z[i] == 0 || z[i] % k != 0) {
                        ok = false;
                        break;
                    }
                }
                if (!ok) {
                    k = n; 
                } 
                r = m / k;
            }
            int MOD = (int) 1e9 + 7;
            out.println(r % MOD);
        }
    }
        
    private int[] z(char[] t) {
        int n = t.length;
        int[] z = new int[n]; z[0] = n;
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i > r) {
                l = r = i;
                while (r < n && t[r - l] == t[r]) {
                    r++;
                }
                z[i] = r - l;
                r--;
            } else {
                int k = i - l;
                if (z[k] < r - i + 1) {
                    z[i] = z[k];
                } else {
                    l = i;
                    while (r < n && t[r - l] == t[r]) {
                        r++;
                    }
                    z[i] = r - l;
                    r--;
                }
            }
        }
        return z;
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
        try (UnexpectedProblem instance = new UnexpectedProblem()) {
            instance.solve();
        }
    }
}
