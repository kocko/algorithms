package codeforces.contests401_500.problemset495;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class ModularEquations implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int a = in.ni(), b = in.ni();
        if (b > a) {
            out.println(0);
        } else if (a == b) {
            out.println("infinity");
        } else {
            Set<Integer> divisors = getDivisors(a - b);
            int count = 0;
            for (int i : divisors) {
                if (i > b) count++;
            }
            out.println(count);
        }
    }

    private Set<Integer> getDivisors(int x) {
        int maxD = (int) Math.sqrt(x);
        Set<Integer> result = new TreeSet<>();
        result.add(x);
        result.add(1);
        for (int i = 2; i <= maxD; i++) {
            if (x % i == 0) {
                result.add(i);
                int d = x / i;
                if (d != i) {
                    result.add(d);
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
        try (ModularEquations instance = new ModularEquations()) {
            instance.solve();
        }
    }
}
