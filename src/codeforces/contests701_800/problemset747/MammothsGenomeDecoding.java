package codeforces.contests701_800.problemset747;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MammothsGenomeDecoding implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        if (n % 4 != 0) {
            out.println("==="); return;
        }
        char[] x = in.next().toCharArray();
        int max = n / 4;
        int a = 0, c = 0, g = 0, t = 0;
        for (char m : x) {
            if (m == 'A') a++;
            else if (m == 'C') c++;
            else if (m == 'G') g++;
            else if (m == 'T') t++;
        }
        if (a > max || c > max || t > max || g > max) {
            out.println("==="); return;
        }
        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            if (x[i] == '?') {
                if (a < max) {
                    result[i] = 'A'; a++;
                } else if (c < max) {
                    result[i] = 'C'; c++;
                } else if (g < max) {
                    result[i] = 'G'; g++;
                } else if (t < max) {
                    result[i] = 'T'; t++;
                } else {
                    out.println("===");
                    return;
                }
            } else {
                result[i] = x[i];
            }
        }
        out.println(new String(result));
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
        try (MammothsGenomeDecoding instance = new MammothsGenomeDecoding()) {
            instance.solve();
        }
    }
}
