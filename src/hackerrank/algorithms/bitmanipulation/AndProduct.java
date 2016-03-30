package hackerrank.algorithms.bitmanipulation;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Long.toBinaryString;

public class AndProduct implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            long a = in.nl(), b = in.nl();
            char[] binaryA = toBinaryString(a).toCharArray();
            char[] binaryB = toBinaryString(b).toCharArray();
            if (binaryA.length == binaryB.length) {
                char[] binary = new char[binaryA.length];
                int i;
                for (i = 0; i < binary.length; i++) {
                    if (binaryA[i] == binaryB[i]) {
                        binary[i] = binaryA[i];
                    } else break;
                }
                for (; i < binary.length; i++) {
                    binary[i] = '0';
                }
                out.println(Long.parseLong(new String(binary), 2));
            } else {
                out.println(0);
            }
        }
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
        new AndProduct().solve();
    }
}
