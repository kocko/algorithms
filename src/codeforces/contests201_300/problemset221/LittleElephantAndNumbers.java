package codeforces.contests201_300.problemset221;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.sqrt;

public class LittleElephantAndNumbers implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), limit = (int) sqrt(n), result = 0;
        init(n);
        for (int i = 1; i <= limit; i++) {
            if (n % i == 0) {
                if (hasCommonDigits(i)) result++;
                if (n != i * i) {
                    if (hasCommonDigits(n / i)) result++;
                }
            }
        }
        out.println(result);
    }
    
    private boolean[] has = new boolean[10];    
    
    private void init(int n) {
        while (n > 0) {
            int rem = n % 10;
            has[rem] = true;
            n /= 10;
        }
    }
    
    private boolean hasCommonDigits(int n) {
        while (n > 0) {
            int rem = n % 10;
            if (has[rem]) return true;
            n /= 10;
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
        try (LittleElephantAndNumbers instance = new LittleElephantAndNumbers()) {
            instance.solve();
        }
    }
}
