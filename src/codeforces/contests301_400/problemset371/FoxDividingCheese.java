package codeforces.contests301_400.problemset371;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class FoxDividingCheese implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int a = in.ni(), b = in.ni();
        Map<Integer, Integer> x = factorize(a), y = factorize(b);
        int result = 0;
        for (int k : new int[]{2, 3, 5}) {
            result += abs(x.getOrDefault(k, 0) - y.getOrDefault(k, 0));
            x.remove(k); 
            y.remove(k);
        }
        for (Map.Entry<Integer, Integer> entry : x.entrySet()) {
            if (!entry.getValue().equals(y.getOrDefault(entry.getKey(), 0))) {
                result = -1;
                break;
            }
        }
        for (Map.Entry<Integer, Integer> entry : y.entrySet()) {
            if (!entry.getValue().equals(x.getOrDefault(entry.getKey(), 0))) {
                result = -1;
                break;
            }
        }
        out.println(result);
    }

    private Map<Integer, Integer> factorize(int n) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                int cnt = result.getOrDefault(i, 0) + 1;
                result.put(i, cnt);
                n /= i;
            }
        }
        if (n > 1) {
            int cnt = result.getOrDefault(n, 0) + 1;
            result.put(n, cnt);
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
        try (FoxDividingCheese instance = new FoxDividingCheese()) {
            instance.solve();
        }
    }
}
