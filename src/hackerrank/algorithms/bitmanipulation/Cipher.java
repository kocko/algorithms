package hackerrank.algorithms.bitmanipulation;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Cipher implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int n = in.ni(), k = in.ni();
        char[] cipher = in.next().toCharArray();
        int[] result = new int[n];
        int[] xor = new int[n];
        result[0] = cipher[0] - '0';
        xor[0] = result[0];
        for (int i = 1; i < n; i++) {
            if (i < k) {
                result[i] = (cipher[i] - '0') ^ xor[i - 1];
            } else {
                result[i] = (cipher[i] - '0') ^ (xor[i - 1] ^ xor[i - k]);
            }
            xor[i] = result[i] ^ xor[i - 1];
        }
        for (int i : result) {
            out.print(i);
        }
        out.println();
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

    public static void main(String[] args) {
        new Cipher().solve();
    }
}
