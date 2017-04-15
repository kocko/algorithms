package codeforces.contests701_800.problemset797;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class KFactorization implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        List<Integer> list = findDivisors(n);
        if (list.size() < k) {
            out.println(-1);
        } else {
            for (int i = 0; i < k - 1; i++) {
                out.print(list.get(i));
                out.print(' ');
            }
            int prod = 1;
            for (int i = k - 1; i < list.size(); i++) {
                prod *= list.get(i);
            }
            out.print(prod);
            out.println();
        }
    }
    
    private List<Integer> findDivisors(int n) {
        List<Integer> result = new ArrayList<>();
        while (n > 1) {
            for (int i = 2; i <= n; i++) {
                if (n % i == 0) {
                    result.add(i);
                    n /= i;
                    break;
                }
            }
        }
        return result;
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
        try (KFactorization instance = new KFactorization()) {
            instance.solve();
        }
    }
}
