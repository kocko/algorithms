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

public class LefthandersAndRighthanders implements Closeable {
    
    private InputReader in;
    private PrintWriter out;

    private LefthandersAndRighthanders() throws IOException {
        in = new InputReader(new FileInputStream(new File("input.txt")));
        out = new PrintWriter(new FileOutputStream(new File("output.txt")));
    }

    public void solve() {
        int n = in.ni();
        char[] x = in.next().toCharArray();
        int[][] result = new int[n / 2][2];
        for (int desk = 0; desk < n / 2; desk++) {
            result[desk][0] = desk + 1;
            result[desk][1] = desk + 1 + n / 2;
            if (x[desk] == 'R' && x[desk + n / 2] == 'L') {
                result[desk][1] = (result[desk][0] ^ result[desk][1]) ^ (result[desk][0] = result[desk][1]);
            }
        }
        for (int[] desk : result) {
            out.println(desk[0] + " " + desk[1]);
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

    public static void main(String[] args) throws IOException {
        try (LefthandersAndRighthanders instance = new LefthandersAndRighthanders()) {
            instance.solve();
        }
    }
}
