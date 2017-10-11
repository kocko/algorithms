package codeforces.contests201_300.problemset234;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Weather implements Closeable {
    
    private InputReader in;
    private PrintWriter out;
    
    private Weather() throws IOException {
        in = new InputReader(new FileInputStream(new File("input.txt")));
        out = new PrintWriter(new FileOutputStream(new File("output.txt")));
    }

    public void solve() {
        int n = in.ni();
        int[] x = new int[n];
        int[] negative = new int[n], zeroes = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
            if (x[i] < 0) {
                if (i > 0) {
                    negative[i] = negative[i - 1] + 1;
                    zeroes[i] = zeroes[i - 1];
                } else {
                    negative[i] = 1;
                }
            } else if (x[i] > 0) {
                if (i > 0) {
                    negative[i] = negative[i - 1];
                    zeroes[i] = zeroes[i - 1];
                } else {
                    zeroes[i] = 1;
                }
            } else {
                if (i > 0) {
                    negative[i] = negative[i - 1];
                    zeroes[i] = zeroes[i - 1] + 1;
                } else {
                    zeroes[i] = 1;
                }
            }
        }
        int result = (int) 1e9;
        for (int i = 0; i < n - 1; i++) {
            int expectedNegative = i + 1, 
                actualNegative = negative[i], 
                changeToNegative = expectedNegative - actualNegative;
            int expectedPositive = n - expectedNegative, 
                actualPositive = expectedPositive - (negative[n - 1] - negative[i]) - (zeroes[n - 1] - zeroes[i]), 
                changeToPositive = expectedPositive - actualPositive;
            if (changeToNegative + changeToPositive < result) {
                result = changeToNegative + changeToPositive;
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
        try (Weather instance = new Weather()) {
            instance.solve();
        }
    }
}
