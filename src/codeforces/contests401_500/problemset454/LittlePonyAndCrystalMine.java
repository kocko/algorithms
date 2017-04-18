package codeforces.contests401_500.problemset454;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LittlePonyAndCrystalMine implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        n = in.ni();
        x = new char[n];
        Arrays.fill(x, '*');
        generate(n / 2, n / 2);
    }
    
    private int n;
    private char[] x;
    
    private void generate(int left, int right) {
        if (left >= 0 && right < n) {
            x[left] = x[right] = 'D';
            print();
            generate(left - 1, right + 1);
            if (left != right) {
                x[left] = x[right] = '*';
                print();
            }
        }
    }
    
    private void print() {
        for (char c : x) {
            out.print(c);
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

    public static void main(String[] args) throws IOException {
        try (LittlePonyAndCrystalMine instance = new LittlePonyAndCrystalMine()) {
            instance.solve();
        }
    }
}
