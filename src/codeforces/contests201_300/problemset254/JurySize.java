package codeforces.contests201_300.problemset254;

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

public class JurySize implements Closeable {

    private InputReader in;
    private PrintWriter out;

    private JurySize() throws IOException {
        in = new InputReader(new FileInputStream(new File("input.txt")));
        out = new PrintWriter(new FileOutputStream(new File("output.txt")));
    }
    public void solve() {
        int n = in.ni();
        int[] x = new int[1000];
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] prefix = new int[12];
        for (int i = 1; i < 12; i++) {
            prefix[i] = prefix[i - 1] + days[i];
        }
        for (int i = 0; i < n; i++) {
            int month = in.ni(), date = in.ni(), people = in.ni(), time = in.ni();
            int k = prefix[month - 1] + date + 500;
            for (int j = 0; j < time; j++) {
                x[--k] += people; 
            }
        }
        int result = 0;
        for (int i = 0; i < 1000; i++) {
            result = Math.max(result, x[i]);
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
        try (JurySize instance = new JurySize()) {
            instance.solve();
        }
    }
}
