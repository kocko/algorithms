package codeforces.contests601_700.problemset680;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BearAndPrime100 implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);
    
    int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
    
    public void solve() {
        int yeses = 0;
        for (int i = 0; i < 20; i++) {
            if (yeses <= 1 && primes[i] > 50) {
                out.println("prime");
                out.flush();
                return;
            } else if (yeses == 2) {
                out.println("composite");
                out.flush();
                return;
            }
            out.println(primes[i]);
            String response = in.next();
            if ("yes".equals(response)) {
                yeses++;
                if (primes[i] < 10 && yeses < 2) {
                    out.println(primes[i] * primes[i]);
                    response = in.next();
                    if ("yes".equals(response)) {
                        yeses++;
                    }
                }
            }
        }
        out.println("composite");
        out.flush();
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
        new BearAndPrime100().solve();
    }
}
