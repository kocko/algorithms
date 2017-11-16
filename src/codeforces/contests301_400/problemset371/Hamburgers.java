package codeforces.contests301_400.problemset371;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Hamburgers implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        long nb = 0, ns = 0, nc = 0;
        for (char c : x) {
            if (c == 'C') nc++;
            if (c == 'S') ns++;
            if (c == 'B') nb++;
        }
        long b = in.nl(), s = in.nl(), c = in.nl();
        long pb = in.nl(), ps = in.nl(), pc = in.nl();
        long money = in.nl();
        long left = 0, right = (long) 1e13, result = 0;
        while (left <= right) {
            long count = left + (right - left) / 2;
            long need = 0;
            if (nb > 0) {
                long bread = count * nb - b;
                if (bread > 0) need += bread * pb;  
            }
            if (nc > 0) {
                long cheese = count * nc - c;
                if (cheese > 0) need += cheese * pc;
            }
            if (ns > 0) {
                long sausage = count * ns - s;
                if (sausage > 0) need += sausage * ps;
            }
            if (need <= money) {
                result = count;
                left = count + 1;
            } else {
                right = count - 1;
            }
        }
        out.println(result);
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
        try (Hamburgers instance = new Hamburgers()) {
            instance.solve();
        }
    }
}
