package codeforces.contests1001_1100.problemset1017;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class B implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        char[] x = in.next().toCharArray(), y = in.next().toCharArray();
        long zeroZero = 0, zeroOne = 0, oneZero = 0, oneOne = 0;
        
        for (int i = 0; i < n; i++) {
            if (x[i] == '0') {
                if (y[i] == '0') zeroZero++;
                else zeroOne++;
            } else {
                if (y[i] == '0') oneZero++;
                else oneOne++;
            }
        }
        long result = 0;
        result += zeroZero * (oneZero + oneOne);
        result += zeroOne * (oneZero);
        result += oneZero * (zeroZero + zeroOne);
        result += oneOne * (zeroZero);
        out.println(result >> 1);
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
        try (B instance = new B()) {
            instance.solve();
        }
    }
}
