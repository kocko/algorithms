package codeforces.contests401_500.problemset460;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LittleDimaAndEquation implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    long pow(int x, int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) result *= x;
        return result;
    }
    
    int s(long x) {
        int result = 0;
        while (x > 0) {
            result += x % 10;
            x /= 10;
        }
        return result;
    }
    
    public void solve() {
        int a = in.ni(), b = in.ni(), c = in.ni();
        List<Long> result = new ArrayList<>();
        for (int i = 1; i <= 81; i++) {
            long x = b * pow(i, a) + c;
            if (s(x) == i && x < 1000000000) {
                result.add(x);
            }
        }
        int x = result.size();
        out.println(x);
        if (x > 0) {
            for (Long l : result) {
                out.print(l + " ");
            }
            out.println();
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
        new LittleDimaAndEquation().solve();
    }
}
